package com.example.myapplication;


import android.annotation.SuppressLint;
import android.widget.TextView;

public class Points {
    private int points;
    private TextView headerTextView;
    private int lives;

    public interface LifeListener {
        void onGameOver();
    }

    private LifeListener listener;

    public Points(TextView headerTextView) {
        this.points = 0;
        this.lives = 3;
        this.headerTextView = headerTextView;
    }

    public void setLifeListener(LifeListener listener) {
        this.listener = listener;
    }

    @SuppressLint("DefaultLocale")
    public void addPoint() {
        this.points++;
        this.headerTextView.setText(String.format("Points: %d\nLives: %d", this.points, this.lives));
    }


    @SuppressLint("DefaultLocale")
    public void loseLife() {
        this.lives--;
        this.headerTextView.setText(String.format("Points: %d\nLives: %d", this.points, this.lives));
        if (lives <= 0 && listener != null) {
            listener.onGameOver();
        }
    }

    public void resetGame(){
        this.points= 0;
        this.lives = 3;
        this.headerTextView.setText(String.format("Points: %d\nLives: %d", this.points, this.lives));
    }

    public int getPoints() {
        return this.points;
    }
}
