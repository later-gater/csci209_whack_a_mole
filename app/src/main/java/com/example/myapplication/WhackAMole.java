package com.example.myapplication;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class WhackAMole {
    private ArrayList<Mole> moles;

    public Points points;



    public WhackAMole(ArrayList<ImageButton> buttons, TextView headerTextView) {
        this.points = new Points(headerTextView);
        this.moles = new ArrayList<>();
        for (ImageButton button : buttons) {
            this.moles.add(new Mole(button, this.points));
        }
    }

    public void makeRandomWhackable() {
        ArrayList<Mole> whackables = new ArrayList<>();
        for (Mole mole : this.moles) {
            if (!mole.getWhackable()) {
                whackables.add(mole);
            }
        }
        if (!whackables.isEmpty()) {
            whackables.get(new Random().nextInt(whackables.size())).makeWhackable();
        }
    }






    public void makeUnRandomWhackable() {
        ArrayList<Mole> unWhackables = new ArrayList<>();
        for (Mole mole : this.moles) {
            if (mole.getWhackable()) {
                unWhackables.add(mole);
            }
        }
        if (!unWhackables.isEmpty()) {
            unWhackables.get(new Random().nextInt(unWhackables.size())).makeWhackable();
        }
    }

    public void makeWhackable(int pos) {
        this.moles.get(pos).makeWhackable();
    }

    public void makeUnWhackable(int pos) {
        this.moles.get(pos).makeUnWhackable();
    }

    public void makeAllUnWhackable(){
        for(Mole mole: this.moles){
            mole.makeUnWhackable();
        }
    }

}

