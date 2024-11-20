package fr.ensicaen.ecole.calculator.model.exchangeRate.exceptions;

public class ApiException extends RuntimeException {
    public ApiException(String url) {
        super("API call failed at URL: " + url);
    }
}
