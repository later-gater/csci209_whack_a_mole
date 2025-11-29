package com.example.myapplication;

import android.view.View;
import android.widget.Button;

public class Mole {
    private Button button;
    private Boolean whackable;
    private Points points;
    // add image that pops up

    public Mole(Button button, Points points) {
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
                    // lose points...
                    points.losePoint();
                }
            }
        });
    }

    public void makeWhackable() {
        this.whackable = true;
        this.button.setText(R.string.whack_me);
    }

    public void makeUnWhackable() {
        this.whackable = false;
        this.button.setText(R.string.no_whack);
    }

    public Boolean getWhackable() {
        return whackable;
    }

}
