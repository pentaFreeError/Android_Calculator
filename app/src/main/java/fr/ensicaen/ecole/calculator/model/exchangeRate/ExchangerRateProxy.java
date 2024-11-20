package fr.ensicaen.ecole.calculator.model.exchangeRate;
import fr.ensicaen.ecole.calculator.model.exchangeRate.exceptions.ApiException;
import fr.ensicaen.ecole.calculator.model.exchangeRate.exceptions.ExchangeRateSaveException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Optional;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;

public class ExchangerRateProxy implements ExchangeRateFetcher{
    final private ExchangeRateDataBase _database;
    final private Cache<String, String> _exchangeRateCache;
    private ExchangeRateFetcher _api = new PrivateExchangeRateFetcher();
    private static final String _defaultApiUrl = "https://api.exchangerate-api.com/v4/latest/";

    public ExchangerRateProxy(ExchangeRateDataBase database) {
        _database = database;
        _exchangeRateCache = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(10)
            .build();
    }

    public ExchangerRateProxy(ExchangeRateDataBase database, ExchangeRateFetcher api) {
        this(database);
        _api = api;
    }

    public String getExchangeRate(String currency) throws ApiException { 
        return getExchangeRate(_defaultApiUrl, currency);
    }

    @Override
    public String getExchangeRate(String apiUrl, String currency) throws ApiException {
        // Case already in the cache
        String cachedRate = _exchangeRateCache.getIfPresent(currency);
        if (cachedRate != null) {
            return cachedRate;
        }
       
        // Case not in the cache but in the database
        if(_database != null) {
            Optional<String> optionalExchangeRate = _database.getExchangeRate(currency);
            if (optionalExchangeRate.isPresent()) {
                String rate = optionalExchangeRate.get();
                _exchangeRateCache.put(currency, rate);
                return rate;
            }
        }

        // Case not in the cache, not in the database so we call the api
        String exchangeRate = _api.getExchangeRate(apiUrl, currency);
        _exchangeRateCache.put(currency, exchangeRate);
        if(_database != null) {
            try {
                _database.saveExchangeRate(currency, exchangeRate);
            } catch (ExchangeRateSaveException e) {
                // if we cant save we just don't do it
            }
        }
        return exchangeRate;
    }

    final static private class PrivateExchangeRateFetcher implements ExchangeRateFetcher {
        @Override
        public String getExchangeRate(String apiUrl, String currency) throws ApiException {
            String urlString = apiUrl + currency;

            try {
                URL url = (new URI(urlString)).toURL();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                if (conn.getResponseCode() == 200) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    return response.toString();
                }
            } catch (Exception ignored){}
            throw new ApiException(urlString);
        }
    }
}


