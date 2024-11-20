package fr.ensicaen.ecole.calculator.model.exchangeRate;

import java.math.BigDecimal;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import fr.ensicaen.ecole.calculator.model.exchangeRate.exceptions.ApiException;

public class CurrencyRateReader {
    final private  ExchangerRateProxy _proxy;

    public CurrencyRateReader(ExchangerRateProxy proxy) {
        _proxy = proxy;
    }

    BigDecimal readRate(String currencyToConvertFrom, String currencyToConvertInto) throws ApiException {
        String jsonRate = _proxy.getExchangeRate(currencyToConvertFrom);
        
        JsonObject jsonObject = null;
        try {
            jsonObject = JsonParser.parseString(jsonRate).getAsJsonObject();
        } catch (Exception e) {
            throw new ApiException("Json format not valid !");
        }

        JsonObject rates = jsonObject.getAsJsonObject("rates");
        BigDecimal rate = new BigDecimal(1);
        try {
            rate = new BigDecimal(rates.get(currencyToConvertInto).getAsDouble());
        } catch (Exception e) {
            throw new ApiException("Json format not valid !");
        }

        return rate;
    }
}
