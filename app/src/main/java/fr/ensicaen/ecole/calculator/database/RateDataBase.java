package fr.ensicaen.ecole.calculator.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.Optional;

import fr.ensicaen.ecole.calculator.model.exchangeRate.ExchangeRateDataBase;
import fr.ensicaen.ecole.calculator.model.exchangeRate.exceptions.ExchangeRateSaveException;

public class RateDataBase implements ExchangeRateDataBase {

    private SQLiteDatabase database;

    public RateDataBase(Context context) {
        DataBaseHelper dbHelper = new DataBaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    @Override
    public Optional<String> getExchangeRate(String currency) {
        try (Cursor cursor = database.query(
                DataBaseHelper.TABLE_RATES,
                new String[]{DataBaseHelper.COLUMN_RATE},
                DataBaseHelper.COLUMN_CURRENCY + " = ?",
                new String[]{currency},
                null,
                null,
                null
        )) {

            if (cursor.moveToFirst()) {
                String rate = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.COLUMN_RATE));
                return Optional.of(rate);
            } else {
                return Optional.empty();
            }
        }
    }

    @Override
    public void saveExchangeRate(String currency, String rate) throws ExchangeRateSaveException {
        try {
            ContentValues values = new ContentValues();
            values.put(DataBaseHelper.COLUMN_CURRENCY, currency);
            values.put(DataBaseHelper.COLUMN_RATE, rate);

            long result = database.insertWithOnConflict(
                    DataBaseHelper.TABLE_RATES,
                    null,
                    values,
                    SQLiteDatabase.CONFLICT_REPLACE
            );

            if (result == -1) {
                throw new ExchangeRateSaveException("Failed to save exchange rate for currency: " + currency);
            }
        } catch (SQLException e) {
            throw new ExchangeRateSaveException("Database error while saving exchange rate: " + e.getMessage());
        }
    }
}
