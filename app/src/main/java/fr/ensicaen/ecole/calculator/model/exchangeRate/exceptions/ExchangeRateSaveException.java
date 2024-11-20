package fr.ensicaen.ecole.calculator.model.exchangeRate.exceptions;

public class ExchangeRateSaveException extends RuntimeException {
    public ExchangeRateSaveException(String currency) {
        super("Failed to save exchange rate for currency " + currency);
    }
}
