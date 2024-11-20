package fr.ensicaen.ecole.calculator.model.exchangeRate;

import java.math.BigDecimal;
import java.math.RoundingMode;

import fr.ensicaen.ecole.calculator.model.exchangeRate.exceptions.ApiException;

public class CurrencyConverter {
    final private CurrencyRateReader _reader;

    public CurrencyConverter(CurrencyRateReader reader) {
        _reader = reader;
    }
    public BigDecimal convert(String currencyToConvertFrom, String currencyToConvertInto, BigDecimal amount) {
        BigDecimal rate = new BigDecimal(1);
        try {
            rate = _reader.readRate(currencyToConvertFrom, currencyToConvertInto);
        } catch (ApiException e) {
            // no internet connection so the rate = 1 and we have a normal calculator without the conversion
        }
        return (rate.multiply(amount)).setScale(3, RoundingMode.HALF_UP);
    } 
}
