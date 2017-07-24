package com.example.android.habittrackerapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.android.habittrackerapp.Habit;
import com.example.android.habittrackerapp.data.HabitContract.HabitEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shinam on 24/07/2017.
 */

public class HabitDb extends SQLiteOpenHelper {

    public static final String LOG_TAG = HabitDb.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "habit.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;
    private Context context;

    /**
     * Constructs a new instance of {@link HabitDb}.
     *
     * @param context of the app
     */
    public HabitDb(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_DATE + " TEXT, "
                + HabitEntry.COLUMN_HABIT_MESSAGE + " TEXT, "
                + HabitEntry.COLUMN_HABIT_HOUR + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }

    public void insertHabit(Habit habit) {
        HabitDb mHabit = new HabitDb(context);

        SQLiteDatabase db = mHabit.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(HabitEntry.COLUMN_HABIT_DATE, habit.getDate());
        values.put(HabitEntry.COLUMN_HABIT_MESSAGE, habit.getMessage());
        values.put(HabitEntry.COLUMN_HABIT_HOUR, habit.getHours());

        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(context, "Error with saving habit", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(context, "Habit saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    public List<Habit> readHabit() {
        HabitDb mHabit = new HabitDb(context);

        SQLiteDatabase db = mHabit.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + HabitEntry.TABLE_NAME, null);


        List<Habit> listName = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Habit habit = new Habit();
                habit.setDate(cursor.getString(1));
                habit.setMessage(cursor.getString(2));
                habit.setHours(cursor.getString(3));

                listName.add(habit);
                cursor.moveToNext();
            }
        } else
            return null;
        return listName;
    }
}