package com.example.myapplication;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private Timer timer;           // ← ADD THIS
    private TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button1);
        ConstraintLayout rootLayout = findViewById(R.id.parentLayout);
        ArrayList<ImageButton> buttons = new ArrayList<>();
        buttons.add(findViewById(R.id.mole1));
        buttons.add(findViewById(R.id.mole2));
        buttons.add(findViewById(R.id.mole3));
        buttons.add(findViewById(R.id.mole4));
        buttons.add(findViewById(R.id.mole5));

        TextView headerTextView = findViewById(R.id.headerText);


        WhackAMole game = new WhackAMole(buttons, headerTextView);
        game.points.setLifeListener(() -> {

            stopGameTimer(game);
            headerTextView.setText("GAME OVER!\nYou had " + game.points.getPoints() + " points.");

        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopGameTimer(game);
                startGameTimer(game);
                game.makeRandomWhackable();
                game.points.resetGame();
            }
        });


    }


    public void startGameTimer(WhackAMole game) {

        timer = new Timer();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                // This runs in background thread!
                // You must update UI on the UI thread:
                runOnUiThread(() -> {
                    game.makeAllUnWhackable();
                    game.makeRandomWhackable();

                });
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 2000); // run every 3 second
    }
    public void stopGameTimer(WhackAMole game) {
        if (timer!=null) {
            timer.cancel();
            timer.purge();
            timer=null;
        }
    }


}