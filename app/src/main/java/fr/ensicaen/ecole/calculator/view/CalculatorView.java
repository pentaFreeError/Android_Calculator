package fr.ensicaen.ecole.calculator.view;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import fr.ensicaen.ecole.calculator.R;
import fr.ensicaen.ecole.calculator.viewmodel.CalculatorViewModel;

public class CalculatorView {
    private final CalculatorViewModel _viewmodel;
    private List<Button> _buttonList;

    private final Spinner spinnerFrom;
    private final Spinner spinnerTo;

    private final AppCompatActivity _root;

    public CalculatorView(AppCompatActivity root, CalculatorViewModel viewModel) {
        _viewmodel = viewModel;
        _root = root;

        createButtonList();
        HorizontalScrollView scrollView = _root.findViewById(R.id.container);
        TextView textview = _root.findViewById(R.id.display);

        _viewmodel.getTextDisplay().observe(_root, new_display -> {
            textview.setText(new_display);
            scrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
        });

        _viewmodel.getValidNext().observe(_root, nextSet -> {
            for (Button button : _buttonList) {
                if (nextSet.contains(button.getText().charAt(0))) {
                    button.setAlpha(1);
                    button.setEnabled(true);
                } else {
                    button.setAlpha(0.3f);
                    button.setEnabled(false);
                }
            }
        });

        spinnerFrom = _root.findViewById(R.id.spinner_from_currency);
        spinnerTo = _root.findViewById(R.id.spinner_to_currency);

        ArrayAdapter<String> adapter = getStringArrayAdapter();

        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);
    }

    public void createButtonList() {
        _buttonList = Arrays.asList(
                _root.findViewById(R.id.btn_0),
                _root.findViewById(R.id.btn_1),
                _root.findViewById(R.id.btn_2),
                _root.findViewById(R.id.btn_3),
                _root.findViewById(R.id.btn_4),
                _root.findViewById(R.id.btn_5),
                _root.findViewById(R.id.btn_6),
                _root.findViewById(R.id.btn_7),
                _root.findViewById(R.id.btn_8),
                _root.findViewById(R.id.btn_9),
                _root.findViewById(R.id.btn_add),
                _root.findViewById(R.id.btn_subtract),
                _root.findViewById(R.id.btn_multiply),
                _root.findViewById(R.id.btn_divide),
                _root.findViewById(R.id.btn_equals),
                _root.findViewById(R.id.btn_close),
                _root.findViewById(R.id.btn_open),
                _root.findViewById(R.id.btn_dot)
        );
    }

    private ArrayAdapter<String> getStringArrayAdapter() {
        String[] currencies = {
                "EUR", "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD",
                "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP",
                "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "FJD", "FKP", "FOK", "GBP", "GEL",
                "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR",
                "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT",
                "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MUR", "MVR",
                "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR",
                "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SLL",
                "SOS", "SRD", "SSP", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TVD", "TWD", "TZS",
                "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR",
                "ZMW", "ZWL"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(_root, R.layout.spinner_item, currencies);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        return adapter;
    }

    public void onButtonClick(View view) {
        String buttonText = ((Button) view).getText().toString();
        String spinnerFromText = spinnerFrom.getSelectedItem().toString();
        String spinnerToText = spinnerTo.getSelectedItem().toString();
        _viewmodel.handleButtonPress(buttonText, spinnerFromText, spinnerToText);
    }
}
