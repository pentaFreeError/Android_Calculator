package fr.ensicaen.ecole.calculator.model.exchangeRate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.mockito.Mockito;

public class TestCurrencyRateReader {
    final private String[] _currencies = {"EUR", "USD"};
    final static private String _invalidFormat = "{\n" +
            "    \"base\": \"EUR\",\n" +
            "    \"date\": \"2024-11-16\"\n" +
            "}";
    final private String[] _apiResultsExample = {
            "{\n" +
                    "    \"provider\": \"https://www.exchangerate-api.com\",\n" +
                    "    \"WARNING_UPGRADE_TO_V6\": \"https://www.exchangerate-api.com/docs/free\",\n" +
                    "    \"terms\": \"https://www.exchangerate-api.com/terms\",\n" +
                    "    \"base\": \"EUR\",\n" +
                    "    \"date\": \"2024-11-16\",\n" +
                    "    \"time_last_updated\": 1731715201,\n" +
                    "    \"rates\": {\n" +
                    "        \"EUR\": 1,\n" +
                    "        \"AED\": 3.87\n" +
                    "    }\n" +
                    "}",

            "{\n" +
                    "    \"provider\": \"https://www.exchangerate-api.com\",\n" +
                    "    \"WARNING_UPGRADE_TO_V6\": \"https://www.exchangerate-api.com/docs/free\",\n" +
                    "    \"terms\": \"https://www.exchangerate-api.com/terms\",\n" +
                    "    \"base\": \"USD\",\n" +
                    "    \"date\": \"2024-11-16\",\n" +
                    "    \"time_last_updated\": 1731715201,\n" +
                    "    \"rates\": {\n" +
                    "        \"USD\": 1,\n" +
                    "        \"AED\": 3.67\n" +
                    "    }\n" +
                    "}"
    };
    
    @Test
    public void read_json_valid_format() {
        ExchangerRateProxy mockProxy = Mockito.mock(ExchangerRateProxy.class);
        when(mockProxy.getExchangeRate(_currencies[0])).thenReturn(_apiResultsExample[0]);
        when(mockProxy.getExchangeRate(_currencies[1])).thenReturn(_apiResultsExample[1]);
        BigDecimal rate = null;

        CurrencyRateReader reader = new CurrencyRateReader(mockProxy);

        try {
            rate = reader.readRate(_currencies[0], "AED");
        } catch(Exception e) {
            fail("valid json format but still getting an exception");
        }

        verify(mockProxy).getExchangeRate(_currencies[0]);
        assertEquals(new BigDecimal(3.87), rate);

        try {
            rate = reader.readRate(_currencies[1], "AED");
        } catch(Exception e) {
            fail("valid json format but still getting an exception");
        }

        verify(mockProxy).getExchangeRate(_currencies[1]);
        assertEquals(new BigDecimal(3.67), rate);
        
        try {
            rate = reader.readRate(_currencies[0], _currencies[0]);
        } catch(Exception e) {
            fail("valid json format but still getting an exception");
        }

        verify(mockProxy).getExchangeRate(_currencies[1]);
        assertEquals(new BigDecimal(1), rate);
    }

    @Test
    public void read_json_not_valid_format() {
        ExchangerRateProxy mockProxy = Mockito.mock(ExchangerRateProxy.class);
        when(mockProxy.getExchangeRate(_currencies[0])).thenReturn("Hmalnlgasmlkgamklajgmlakjgamgjamlg");
        CurrencyRateReader reader = new CurrencyRateReader(mockProxy);
        boolean validCatch = false;

        try {
            reader.readRate(_currencies[0], "AED");
        } catch(Exception e) {
            validCatch = true;
        }

        verify(mockProxy).getExchangeRate(_currencies[0]);
        assertTrue(validCatch);
    }

    @Test
    public void read_json_valid_format_but_not_expected_format() {
        ExchangerRateProxy mockProxy = Mockito.mock(ExchangerRateProxy.class);
        when(mockProxy.getExchangeRate(_currencies[0])).thenReturn(_invalidFormat);
        CurrencyRateReader reader = new CurrencyRateReader(mockProxy);
        boolean validCatch = false;

        try {
            reader.readRate(_currencies[0], "AED");
        } catch(Exception e) {
            validCatch = true;
        }

        verify(mockProxy).getExchangeRate(_currencies[0]);
        assertTrue(validCatch);
    }
}
