package fr.ensicaen.ecole.calculator.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "calculator.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_RATES = "rates";
    public static final String COLUMN_CURRENCY = "currency";
    public static final String COLUMN_RATE = "rate";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_RATES + " (" +
                    COLUMN_CURRENCY + " TEXT, " +
                    COLUMN_RATE + " TEXT);";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RATES);
        onCreate(db);
    }
}

