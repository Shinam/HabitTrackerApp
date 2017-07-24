package com.example.android.habittrackerapp.data;

import android.provider.BaseColumns;

/**
 * Created by Shinam on 24/07/2017.
 */

public final class HabitContract {

    private HabitContract() {
    }

    public static final class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "habits";


        public final static String _ID = BaseColumns._ID;


        public final static String COLUMN_HABIT_DATE = "date";

        public final static String COLUMN_HABIT_MESSAGE = "message";

        public final static String COLUMN_HABIT_HOUR = "hour";
    }

}

