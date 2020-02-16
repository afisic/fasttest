package com.example.fasttest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminActivity extends AppCompatActivity {



    private DatabaseReference databaseReference;
    private EditText rb_pitanje_et, pitanje_et, odga_et, odgb_et, odgc_et, odgd_et, odgovor_et;
    private Button dodaj_btn;
    private Questions adminQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        rb_pitanje_et = (EditText) findViewById(R.id.rb_pitanje_et);
        pitanje_et = (EditText) findViewById(R.id.pitanje_et);
        odga_et = (EditText) findViewById(R.id.odga_et);
        odgb_et = (EditText) findViewById(R.id.odgb_et);
        odgc_et = (EditText) findViewById(R.id.odgc_et);
        odgd_et = (EditText) findViewById(R.id.odgd_et);
        odgovor_et = (EditText) findViewById(R.id.odgovor_et);
        dodaj_btn = (Button) findViewById(R.id.dodaj_btn);


        dodaj_btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                adminQuestions = new Questions(pitanje_et.getText().toString(), odga_et.getText().toString(), odgb_et.getText().toString(),
                        odgc_et.getText().toString(), odgd_et.getText().toString(), odgovor_et.getText().toString());
                databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference.child(rb_pitanje_et.getText().toString()).setValue(adminQuestions);

                rb_pitanje_et.setText("");
                pitanje_et.setText("");
                odga_et.setText("");
                odgb_et.setText("");
                odgc_et.setText("");
                odgd_et.setText("");
                odgovor_et.setText("");
            }
        });
    }

}


