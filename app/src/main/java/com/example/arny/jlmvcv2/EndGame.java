package com.example.arny.jlmvcv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by luke on 2016-03-08.
 */
public class EndGame extends AppCompatActivity {
    Button btnReturn;
    TextView tvEndScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_end);
        setTitle("Game Over");
        tvEndScore = (TextView) findViewById(R.id.tvScore);
        tvEndScore.setText("You got  " + MainActivity.nRight + "  out of  " + MainActivity.nTotal +
        " correct!");
        MainActivity.nTotal = 0;
        MainActivity.nRight = 0;
        btnReturn = (Button) findViewById(R.id.btnRst);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StartMenu.class));
            }
        });
    }
}