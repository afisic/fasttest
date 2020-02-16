package com.example.fasttest;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;


public class QuizActivity extends AppCompatActivity {

    private Button a_btn, b_btn, c_btn, d_btn;
    private TextView questionTv;
    private int rez = 0;
    private int rMaxQ = 10;
    private int rSelectedQ = 5;
    private DatabaseReference databaseReference;
    private Questions questions;
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTv = (TextView) findViewById(R.id.pitanje_tv);
        a_btn = (Button) findViewById(R.id.a_btn);
        b_btn = (Button) findViewById(R.id.b_btn);
        c_btn = (Button) findViewById(R.id.c_btn);
        d_btn = (Button) findViewById(R.id.d_btn);


        ArrayList<Integer> rmrq = new ArrayList<Integer>();
        final ArrayList<Integer> rsrq = new ArrayList<Integer>();
        for (int i = 1; i < rMaxQ; i++) {
            rmrq.add(i);
        }
        Collections.shuffle(rmrq);

        for (int i = 0; i < rSelectedQ; i++) {
            rsrq.add(rmrq.get(i));
        }

        queryDatabase(rsrq.get(0));

        a_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i>4){
                    checkAnswers("a");
                    Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("rezultat", rez);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }else{
                    checkAnswers("a");
                    queryDatabase(rsrq.get(i++));
                }

            }
        });

        b_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i>4){
                    checkAnswers("b");
                    Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("rezultat", rez);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }else{
                    checkAnswers("b");
                    queryDatabase(rsrq.get(i++));
                }
            }
        });

        c_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i>4){
                    checkAnswers("c");
                    Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("rezultat", rez);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }else{
                    checkAnswers("c");
                    queryDatabase(rsrq.get(i++));
                }
            }
        });

        d_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i>4){
                    checkAnswers("d");
                    Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("rezultat", rez);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }else{
                    checkAnswers("d");
                    queryDatabase(rsrq.get(i++));
                }
            }
        });



    }

    private void checkAnswers(String ans) {
        if (ans.equals(questions.getAns())){
            rez += 1;
            Toast.makeText(this, "Tocan odgovor", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "Netocan odgovor", Toast.LENGTH_SHORT).show();
        }
    }

    private void queryDatabase(int qNum){
        databaseReference = FirebaseDatabase.getInstance().getReference().child(String.valueOf(qNum));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                questions = dataSnapshot.getValue(Questions.class);
                questionTv.setText(questions.getQ());
                a_btn.setText(questions.getA());
                b_btn.setText(questions.getB());
                c_btn.setText(questions.getC());
                d_btn.setText(questions.getD());
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });
    }
}


