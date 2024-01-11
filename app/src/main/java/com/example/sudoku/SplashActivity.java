package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    final int TIME1=200;
    final int TIME2=2400;
    private ImageView t1, t2, t3, t4, t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        t1 = (ImageView) findViewById(R.id.t1);
        t2 = (ImageView) findViewById(R.id.t2);
        t3 = (ImageView) findViewById(R.id.t3);
        t4 = (ImageView) findViewById(R.id.t4);
        t5 = (ImageView) findViewById(R.id.t5);



        //animation of appearing and disappearing of the buttons, like in the game
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t1.setVisibility(View.INVISIBLE);
                t2.setVisibility(View.INVISIBLE);
                t3.setVisibility(View.INVISIBLE);
                t4.setVisibility(View.INVISIBLE);
                t5.setVisibility(View.INVISIBLE);
            }
        }, 0*TIME1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t5.setVisibility(View.VISIBLE);
            }
        }, 1*TIME1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t4.setVisibility(View.VISIBLE);
            }
        }, 2*TIME1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t3.setVisibility(View.VISIBLE);
            }
        }, 3*TIME1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t2.setVisibility(View.VISIBLE);
            }
        }, 4*TIME1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t1.setVisibility(View.VISIBLE);
            }
        }, 5*TIME1);

        //another round of the animation
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t1.setVisibility(View.INVISIBLE);
                t2.setVisibility(View.INVISIBLE);
                t3.setVisibility(View.INVISIBLE);
                t4.setVisibility(View.INVISIBLE);
                t5.setVisibility(View.INVISIBLE);
            }
        }, 6*TIME1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t5.setVisibility(View.VISIBLE);
            }
        }, 7*TIME1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t4.setVisibility(View.VISIBLE);
            }
        }, 8*TIME1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t3.setVisibility(View.VISIBLE);
            }
        }, 9*TIME1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t2.setVisibility(View.VISIBLE);
            }
        }, 10*TIME1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t1.setVisibility(View.VISIBLE);
            }
        }, 11*TIME1);


        // moving to main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),MenuActivity.class);
                finish();//close this activity
                startActivity(i);
            }
        }, TIME2);
    }
}