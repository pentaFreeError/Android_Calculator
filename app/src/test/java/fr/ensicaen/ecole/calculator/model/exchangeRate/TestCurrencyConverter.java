package fr.ensicaen.ecole.calculator.model.exchangeRate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;
import org.mockito.Mockito;

public class TestCurrencyConverter {
    
    @Test
    public void convert_test() {
        CurrencyRateReader mockReader = Mockito.mock(CurrencyRateReader.class);
        when(mockReader.readRate("EUR", "AED")).thenReturn(new BigDecimal(3.15));
        when(mockReader.readRate("USD", "EUR")).thenReturn(new BigDecimal(1.2));

        CurrencyConverter converter = new CurrencyConverter(mockReader);
        
        BigDecimal conversion = converter.convert("EUR", "AED", new BigDecimal(3)); 

        verify(mockReader).readRate("EUR", "AED");
        assertEquals(new BigDecimal(3.15).multiply(new BigDecimal(3)).setScale(3, RoundingMode.HALF_UP), conversion);

        conversion = converter.convert("USD", "EUR", new BigDecimal(5)); 

        verify(mockReader).readRate("USD", "EUR");
        assertEquals(new BigDecimal(1.2).multiply(new BigDecimal(5)).setScale(3, RoundingMode.HALF_UP), conversion);

        BigDecimal[] tab = {new BigDecimal(Integer.MAX_VALUE), new BigDecimal(Integer.MIN_VALUE), new BigDecimal(Double.MAX_VALUE), new BigDecimal(Double.MIN_VALUE)}; 

        for(BigDecimal value : tab) {
            conversion = converter.convert("USD", "EUR", value); 
            assertEquals(new BigDecimal(1.2).multiply(value).setScale(3, RoundingMode.HALF_UP), conversion);
        }
    }
}