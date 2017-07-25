package com.example.android.habittrackerapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shinam on 24/07/2017.
 */

public class HabitAdapter extends ArrayAdapter<Habit> {

    public HabitAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Habit> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        Habit currentHabit = getItem(position);

        holder.date.setText(currentHabit.getDate().toString() + ", " + currentHabit.getHours());
        holder.message.setText(currentHabit.getMessage());

        if (currentHabit.getRepeat() == 1) {
            holder.repeat.setText("Yes");
        } else
            holder.repeat.setText("No");

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.message)
        TextView message;
        @BindView(R.id.repeatValue)
        TextView repeat;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
