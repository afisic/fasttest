package com.example.fasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    private TextView rezultatTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Bundle bundle = getIntent().getExtras();
        int rez = bundle.getInt("rezultat");


        rezultatTV  = (TextView) findViewById(R.id.rezultat_tv);
        if (rez >= 3)
        {
            rezultatTV.setText("Rezultat je: " + rez +  " \n  PROLAZ! :) ");
        }else
        {
            rezultatTV.setText("Rezultat je: " + rez +  " \n  PAD! :(  ");
        }
    }
}



