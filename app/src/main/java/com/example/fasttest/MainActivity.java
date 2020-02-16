package com.example.fasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button login_btn;
    private EditText studentIdEt, studentPwEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentIdEt = (EditText) findViewById(R.id.id_student);
        studentPwEt = (EditText) findViewById(R.id.pw_student);
        login_btn = (Button) findViewById(R.id.login_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (studentIdEt.getText().toString().equals("student") && studentPwEt.getText().toString().equals("student")) {
                    startActivity(new Intent(MainActivity.this, QuizActivity.class));
                } else if (studentIdEt.getText().toString().equals("admin") && studentPwEt.getText().toString().equals("admin")) {
                    startActivity(new Intent(MainActivity.this, AdminActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Pogresni korisnicki podaci", Toast.LENGTH_LONG).show();
                }
                studentIdEt.setText("");
                studentPwEt.setText("");
            }
        });
    }
}
