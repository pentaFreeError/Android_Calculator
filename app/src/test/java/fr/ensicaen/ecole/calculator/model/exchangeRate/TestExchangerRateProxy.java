package fr.ensicaen.ecole.calculator.model.exchangeRate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import fr.ensicaen.ecole.calculator.model.exchangeRate.exceptions.ApiException;
import fr.ensicaen.ecole.calculator.model.exchangeRate.exceptions.ExchangeRateSaveException;

public class TestExchangerRateProxy {
    final private String[] _currencies = {"EUR", "USD"};
    final private String _apiUrl = "https://api.exchangerate-api.com/v4/latest/";
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
    public void api_call_works_test() {
        ExchangeRateFetcher mockApi = Mockito.mock(ExchangeRateFetcher.class);
        when(mockApi.getExchangeRate(_apiUrl, _currencies[0])).thenReturn(_apiResultsExample[0]);
        when(mockApi.getExchangeRate(_apiUrl, _currencies[1])).thenReturn(_apiResultsExample[1]);

        ExchangerRateProxy proxy = new ExchangerRateProxy(null, mockApi);
        String lastRate = new String();
        for(String currency : _currencies) {
            try {
                lastRate = proxy.getExchangeRate(_apiUrl, currency);
            } catch(ApiException e) {
                fail("API call failed for currency: " + currency + " with exception: " + e.getMessage());
            }

            JsonObject jsonObject = null;
            try {
                jsonObject = JsonParser.parseString(lastRate).getAsJsonObject();
            } catch(Exception e) {
                fail("The given json from the api dont follow the format ! ");
            }
            
            JsonElement baseElement = jsonObject.get("base");
            JsonObject rates = jsonObject.getAsJsonObject("rates");

            assertNotNull(rates, "Cannot find the base attribut in the given json from the api");
            assertNotNull(baseElement, "Cannot find the base attribut in the given json from the api");
            
            String base = baseElement.getAsString();
            double selfRate = 0;
            try {
                selfRate = rates.get(currency).getAsDouble();
            } catch(Exception e) {
                fail("Cannot find the rate attribut in the given json from the api");
            }

            assertEquals(base, currency);
            assertEquals(selfRate, 1.0);
        }
    }

    @Test
    public void invalid_api_url_test() {
        String serverWhoSend404ErrorUrl = "https://httpstat.us/404";
        ExchangerRateProxy proxy = new ExchangerRateProxy(null);
        boolean catchWorked = false;

        try {
            proxy.getExchangeRate("This/is/a/random/url", _currencies[0]);
        } catch (ApiException e) {
            catchWorked = true;
        }

        assertTrue(catchWorked);
        catchWorked = false;

        try {
            proxy.getExchangeRate(serverWhoSend404ErrorUrl, _apiUrl);
        } catch(ApiException e) {
            catchWorked = true;
        }

        assertTrue(catchWorked);
    }

    @Test 
    public void other_api_call() {
        ExchangerRateProxy proxy = new ExchangerRateProxy(null);
        boolean validCatch = true;
        String content = null;

        try {
            content = proxy.getExchangeRate("https://example.com/", "");
        } catch(ApiException e) {
            validCatch = false;
        }
        assertTrue(validCatch);
        assertNotNull(content);
    }

    @Test
    public void database_dont_need_to_call_api_test() {
        ExchangeRateDataBase mockDatabase = Mockito.mock(ExchangeRateDataBase.class);
        when(mockDatabase.getExchangeRate(_currencies[0])).thenReturn(Optional.of("42"));

        ExchangerRateProxy proxy = new ExchangerRateProxy(mockDatabase);
        String actualRate = null;
        try {
           actualRate = proxy.getExchangeRate("This/is/a/random/url", _currencies[0]);
        } catch(ApiException e) {
            fail("Api call failed but we are not supposed to call the api !"); 
        }
        
        verify(mockDatabase).getExchangeRate(_currencies[0]);
        assertEquals("42", actualRate);
        // The dateBase already got the rate so we test that we dont call saveRate
        verify(mockDatabase, never()).saveExchangeRate(_currencies[0], "42");
    }

    
    @Test
    public void database_need_to_call_api_test() {

        ExchangeRateFetcher mockApi = Mockito.mock(ExchangeRateFetcher.class);
        when(mockApi.getExchangeRate(_apiUrl, _currencies[0])).thenReturn(_apiResultsExample[0]);

        ExchangeRateDataBase mockDatabase = Mockito.mock(ExchangeRateDataBase.class);
        // retrun null = database dont have the rate of this currency  
        when(mockDatabase.getExchangeRate(_currencies[0])).thenReturn(Optional.empty());

        ExchangerRateProxy proxy = new ExchangerRateProxy(mockDatabase, mockApi);
        String actualRate = null; 

        try {
            actualRate = proxy.getExchangeRate(_apiUrl, _currencies[0]);
        } catch (ApiException e) {
            fail("Api call failed !");
        }

        verify(mockDatabase).getExchangeRate(_currencies[0]);
        assertNotNull(actualRate);
        // The dateBase dont have the rate so we save it  
        verify(mockDatabase).saveExchangeRate(_currencies[0], actualRate);
    }

    @Test 
    public void database_cant_save_test() {
        ExchangeRateFetcher mockApi = Mockito.mock(ExchangeRateFetcher.class);
        when(mockApi.getExchangeRate(_apiUrl, _currencies[0])).thenReturn(_apiResultsExample[0]);
        
        ExchangeRateDataBase mockDatabase = Mockito.mock(ExchangeRateDataBase.class);
        // retrun null = database dont have the rate of this currency  
        when(mockDatabase.getExchangeRate(_currencies[0])).thenReturn(Optional.empty());

        ExchangerRateProxy proxy = new ExchangerRateProxy(mockDatabase, mockApi);
        String actualRate = null; 

        doThrow(new ExchangeRateSaveException("Database error"))
            .when(mockDatabase)
            .saveExchangeRate(anyString(), anyString());

        try {
            actualRate = proxy.getExchangeRate(_apiUrl, _currencies[0]);
        } catch (ApiException e) {
            fail("Api call failed !");
        }

        verify(mockDatabase).getExchangeRate(_currencies[0]);
        assertNotNull(actualRate);
        verify(mockDatabase).saveExchangeRate(_currencies[0], actualRate); 
    }

    @Test
    public void rate_available_in_api_added_to_cache_test() {
        ExchangeRateFetcher mockApi = Mockito.mock(ExchangeRateFetcher.class);
        when(mockApi.getExchangeRate(_apiUrl, _currencies[0])).thenReturn(_apiResultsExample[0]);

        doThrow(new ApiException("api error"))
            .when(mockApi)
            .getExchangeRate("This/is/a/random/url", _currencies[0]);

        String actualRate = null; 
        ExchangeRateDataBase mockDatabase = Mockito.mock(ExchangeRateDataBase.class);
        when(mockDatabase.getExchangeRate(_currencies[0])).thenReturn(Optional.empty());
        ExchangerRateProxy proxy = new ExchangerRateProxy(mockDatabase, mockApi);

        try {
            actualRate = proxy.getExchangeRate(_apiUrl, _currencies[0]);
        } catch (ApiException e) {
            fail("Api call failed !");
        }

        // try to get the rate for the same currency
        String cacheRate = null;
        try {
            cacheRate = proxy.getExchangeRate("This/is/a/random/url", _currencies[0]);
        } catch(ApiException e) {
            fail("The api is called despite having the rate in the cache");
        }

        verify(mockDatabase, times(1)).getExchangeRate(_currencies[0]);
        assertNotNull(actualRate);
        verify(mockDatabase, times(1)).saveExchangeRate(_currencies[0], actualRate); 
        assertEquals(actualRate, cacheRate);
    }

    @Test
    public void rate_available_in_database_added_to_cache_test() {
        String actualRate = null; 
        ExchangeRateDataBase mockDatabase = Mockito.mock(ExchangeRateDataBase.class);
        when(mockDatabase.getExchangeRate(_currencies[0])).thenReturn(Optional.of("42"));
        ExchangerRateProxy proxy = new ExchangerRateProxy(mockDatabase);

        try {
            actualRate = proxy.getExchangeRate("This/is/a/random/url", _currencies[0]);
        } catch (ApiException e) {
            fail("Database dont contain the rate");
        }

        String cacheRate = null;
        try {
            cacheRate = proxy.getExchangeRate("This/is/a/random/url", _currencies[0]);
        } catch(ApiException e) {
            fail("The api is called despite having the rate in the cache");
        }

        verify(mockDatabase, times(1)).getExchangeRate(_currencies[0]);
        assertNotNull(actualRate);
        assertNotNull(cacheRate);
        verify(mockDatabase, never()).saveExchangeRate(_currencies[0], actualRate); 
        assertEquals(actualRate, cacheRate);
        assertEquals("42", cacheRate);
    }
}
