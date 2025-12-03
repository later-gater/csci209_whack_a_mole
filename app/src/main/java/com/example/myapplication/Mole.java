package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Mole {
    private ImageButton button;
    private Boolean whackable;

    public Points points;


    // add image that pops up

    public Mole(ImageButton button, Points points) {
        this.button = button;
        this.whackable = false;
        this.points = points;

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (whackable) {
                    // add points...
                    makeUnWhackable();
                    points.addPoint();
                } else {
                    // lose life...
                    points.loseLife();
                }
            }
        });
    }

    public void makeWhackable() {
        this.whackable = true;
        this.button.setImageResource(R.drawable.javalogo);
    }

    public void makeUnWhackable() {
        this.whackable = false;
        this.button.setImageResource(R.drawable.pythonlogo);
    }

    public Boolean getWhackable() {
        return whackable;
    }

}
