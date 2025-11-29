package com.example.myapplication;


import android.annotation.SuppressLint;
import android.widget.TextView;

public class Points {
    private int points;
    private TextView headerTextView;

    public Points(TextView headerTextView) {
        this.points = 0;
        this.headerTextView = headerTextView;
    }

    @SuppressLint("DefaultLocale")
    public void addPoint() {
        this.points++;
        this.headerTextView.setText(String.format("Points: %d", this.points));
    }

    @SuppressLint("DefaultLocale")
    public void losePoint() {
        this.points--;
        this.headerTextView.setText(String.format("Points: %d", this.points));
    }
}
