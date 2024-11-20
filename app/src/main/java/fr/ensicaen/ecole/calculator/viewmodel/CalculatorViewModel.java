package fr.ensicaen.ecole.calculator.viewmodel;

import android.os.Looper;
import android.util.Log;
import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fr.ensicaen.ecole.calculator.model.exchangeRate.CurrencyConverter;
import fr.ensicaen.ecole.calculator.model.exchangeRate.CurrencyRateReader;
import fr.ensicaen.ecole.calculator.model.exchangeRate.ExchangeRateDataBase;
import fr.ensicaen.ecole.calculator.model.exchangeRate.ExchangerRateProxy;
import fr.ensicaen.ecole.calculator.model.expression.ExpressionValidator;
import fr.ensicaen.ecole.calculator.model.expression.SimpleCalculator;


public class CalculatorViewModel extends ViewModel {
    private final MutableLiveData<String> _text_display = new MutableLiveData<>(new String(""));
    private final ExpressionValidator _validator;
    private final MutableLiveData<Set<Character>> _vaild_next = new MutableLiveData<>(new HashSet<>(Set.of()));
    private final SimpleCalculator _calculator;

    private ExchangerRateProxy _proxy;
    private CurrencyRateReader _reader;

    private CurrencyConverter _converter;
    public LiveData<String> getTextDisplay() { return _text_display; }

    public LiveData<Set<Character>> getValidNext() { return _vaild_next; }

    public CalculatorViewModel() {
        super();
        _validator = new ExpressionValidator();
        _calculator = new SimpleCalculator();
        updateValidNext();
    }

    private void updateValidNext() {
        _vaild_next.setValue(_validator.getPossibleNextCharacters(_text_display.getValue()));
    }
    private void handleClearButtonPress() {
        _text_display.setValue("");
        updateValidNext();
    }
    private void handleEqualsButtonPress(String spinnerFromText, String spinnerToText) {
        double result = _calculator.calculate(_text_display.getValue());
        if(Double.isNaN(result)) {
            _text_display.setValue("");
            updateValidNext();
        } else {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());

            executor.execute(() -> {
                        BigDecimal conversion = _converter.convert(spinnerFromText, spinnerToText, new BigDecimal(result));
                        handler.post(() -> {
                            _text_display.setValue(Double.toString(_calculator.calculate(conversion.toString())));
                            updateValidNext();
                        });
            });
        }
    }
    public void handleRemoveButtonPress() {
        String oldValue = _text_display.getValue();
        if(oldValue != null && !oldValue.isEmpty()) {
            _text_display.setValue(oldValue.substring(0, oldValue.length() - 1));
        }
        updateValidNext();
    }
    public void setDataBase(ExchangeRateDataBase database) {
        _proxy = new ExchangerRateProxy(database);
        _reader = new CurrencyRateReader(_proxy);
        _converter = new CurrencyConverter(_reader);
    }
    public void handleButtonPress(String button_char, String spinnerFromText, String spinnerToText) {
        if(button_char.equals("C")) {
            handleClearButtonPress();
            return;
        } else if(button_char.equals("=")) {
            handleEqualsButtonPress(spinnerFromText, spinnerToText);
            return;
        } else if (button_char.equals("⌫")) {
            handleRemoveButtonPress();
            return;
        }
        String oldValue = _text_display.getValue();
        _text_display.setValue(oldValue + button_char);
        updateValidNext();
    }
}
