package com.example.arny.jlmvcv3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arny.jlmvcv2.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int nPicID, nSndID, nRan, nRan2, nView;
    public static int nRight, nTotal;
    ImageButton imbA1, imbA2, imbA3, imbA4;
    Button btnSnd;
    String[] arsAnml = {"chicken", "cow", "dog", "goose", "lion", "snake", "tiger"};
    String[] arsKeep;
    ArrayList<String> listAnml;
    Toast tCor, tBad;
    MediaPlayer mNoise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Animal Fun");

        arsKeep = new String[4];

        btnSnd = (Button) findViewById(R.id.btn2);
        btnSnd.setOnClickListener(Sound);

        imbA1 = (ImageButton) findViewById(R.id.imgBtn1);
        imbA1.setOnClickListener(imgClk);

        imbA2 = (ImageButton) findViewById(R.id.imgBtn2);
        imbA2.setOnClickListener(imgClk);

        imbA3 = (ImageButton) findViewById(R.id.imgBtn3);
        imbA3.setOnClickListener(imgClk);

        imbA4 = (ImageButton) findViewById(R.id.imgBtn4);
        imbA4.setOnClickListener(imgClk);

        tCor = Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT);
        tBad = Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT);

        Refresh();
        btnSnd.performClick();
    }

    public void Refresh() {
        listAnml = new ArrayList(Arrays.asList(arsAnml));
        nRan2 = (int) Math.floor(Math.random() * 4);
        imbA1.setBackgroundResource(getRes(0));
        imbA2.setBackgroundResource(getRes(1));
        imbA3.setBackgroundResource(getRes(2));
        imbA4.setBackgroundResource(getRes(3));
    }

    public int getRes(int nPic) {
        //http://stackoverflow.com/questions/3538649/accessing-contents-of-r-string-using-a-variable-to-represent-the-resource-name
        nRan = (int) Math.floor(Math.random() * listAnml.size());
        nPicID = getResources().getIdentifier(listAnml.get(nRan), "drawable", getPackageName());
        arsKeep[nPic] = listAnml.get(nRan);
        listAnml.remove(nRan);
        return nPicID;
    }

    public void playSound() {
        //http://stackoverflow.com/questions/12266502/android-mediaplayer-stop-and-play
        nSndID = getResources().getIdentifier(arsKeep[nRan2], "raw", getPackageName());
        mNoise = MediaPlayer.create(getApplicationContext(), nSndID);
        mNoise.start();
    }

    View.OnClickListener Sound = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            playSound();
        }
    };

    View.OnClickListener imgClk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (nTotal < 10) {
                if (v == imbA1) {
                    nView = 0;
                } else if (v == imbA2) {
                    nView = 1;
                } else if (v == imbA3) {
                    nView = 2;
                } else {
                    nView = 3;
                }
                if (nView == nRan2) {
                    nRight++;
                    tCor.show();
                    mNoise.stop();
                    mNoise.release();
                    Refresh();
                    btnSnd.performClick();
                } else {
                    tBad.show();
                    mNoise.stop();
                    mNoise.release();
                    Refresh();
                    btnSnd.performClick();
                }
                nTotal++;
            } else {
                mNoise.stop();
                mNoise.release();
                startActivity(new Intent(getApplicationContext(), EndGame.class));
            }
        }
    };
}

