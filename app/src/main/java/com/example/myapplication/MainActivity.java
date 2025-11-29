package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button1);
        ConstraintLayout rootLayout = findViewById(R.id.parentLayout);
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(findViewById(R.id.mole1));
        buttons.add(findViewById(R.id.mole2));
        buttons.add(findViewById(R.id.mole3));
        buttons.add(findViewById(R.id.mole4));
        buttons.add(findViewById(R.id.mole5));

        TextView headerTextView = findViewById(R.id.headerText);


        WhackAMole game = new WhackAMole(buttons, headerTextView);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                game.makeRandomWhackable();
            }
        });

    }
}