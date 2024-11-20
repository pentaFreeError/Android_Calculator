package fr.ensicaen.ecole.calculator.model.exchangeRate;

import fr.ensicaen.ecole.calculator.model.exchangeRate.exceptions.ApiException;

public interface ExchangeRateFetcher {
    public String getExchangeRate(String apiUrl, String currency) throws ApiException;
}
