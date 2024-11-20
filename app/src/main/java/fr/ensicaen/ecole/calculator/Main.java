package fr.ensicaen.ecole.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import fr.ensicaen.ecole.calculator.database.RateDataBase;
import fr.ensicaen.ecole.calculator.model.exchangeRate.ExchangeRateDataBase;
import fr.ensicaen.ecole.calculator.model.exchangeRate.exceptions.ExchangeRateSaveException;
import fr.ensicaen.ecole.calculator.view.CalculatorView;
import fr.ensicaen.ecole.calculator.viewmodel.CalculatorViewModel;

public class Main extends AppCompatActivity {

    private CalculatorView _view;

    public void onButtonClick(View view) {
        _view.onButtonClick(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExchangeRateDataBase ratesRepo = new RateDataBase(this);
        CalculatorViewModel viewmodel = new ViewModelProvider(this).get(CalculatorViewModel.class);
        viewmodel.setDataBase(ratesRepo);

        _view = new CalculatorView(this, viewmodel);
    }
}