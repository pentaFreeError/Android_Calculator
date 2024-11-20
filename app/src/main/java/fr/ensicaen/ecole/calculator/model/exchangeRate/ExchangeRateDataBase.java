package fr.ensicaen.ecole.calculator.model.exchangeRate;
import java.util.Optional;

import fr.ensicaen.ecole.calculator.model.exchangeRate.exceptions.ExchangeRateSaveException;

public interface ExchangeRateDataBase {
    Optional<String> getExchangeRate(String currency);
    void saveExchangeRate(String currency, String rate) throws ExchangeRateSaveException; 
}

    
