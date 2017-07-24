package com.example.android.habittrackerapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.habittrackerapp.data.HabitDb;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<Habit> mListHabit;
    private ListView habitListView;
    private TextView empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        HabitDb habitDb = new HabitDb(this);

        mListHabit = habitDb.readHabit();

        if (mListHabit != null) {

            HabitAdapter mAdapter = new HabitAdapter(this, 0, mListHabit);

            habitListView = (ListView) findViewById(R.id.list);

            habitListView.setAdapter(mAdapter);
        } else {
            empty = (TextView) findViewById(R.id.empty);
            empty.setText(R.string.emptyList);
        }
    }
}
