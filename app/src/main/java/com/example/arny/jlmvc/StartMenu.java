package com.example.arny.jlmvc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.arny.jlmvc.R;


//https://youtu.be/rREw23TgHJ8?list=PLvnXjBkwUhDEfjK1pqT8LsGWPyFuzO5Zu
public class StartMenu extends AppCompatActivity {
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_start);
        setTitle("Main Menu");
        btnStart = (Button) findViewById(R.id.btn1);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}