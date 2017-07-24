package com.example.android.habittrackerapp;

/**
 * Created by Shinam on 24/07/2017.
 */

public class Habit {

    public String date;
    public String message;
    public String hours;

    public Habit(String date, String message, String hours) {
        this.date = date;
        this.message = message;
        this.hours = hours;
    }

    public Habit() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
