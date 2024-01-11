package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;
import java.util.Set;

public class AddUsers extends AppCompatActivity implements View.OnClickListener {

    //String lName;
    boolean easyClicked=false;
    boolean mediumClicked=false;
    boolean hardClicked=false;

    private Button btnEasy,btnMedium,btnHard;
    private Button btnPlay;
    private ImageButton btnGoBack;
    private EditText edName;
    private String name;

    private String sLevel;
    private int level;

    private String strLevel;
    private TextToSpeech textToSpeech;
    private Voice voice;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users);

        btnGoBack = (ImageButton) findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(this);

        btnEasy = (android.widget.Button) findViewById(R.id.btnEasy);
        btnEasy.setOnClickListener(this);

        btnMedium = (android.widget.Button) findViewById(R.id.btnMedium);
        btnMedium.setOnClickListener(this);

        btnHard = (android.widget.Button) findViewById(R.id.btnHard);
        btnHard.setOnClickListener(this);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);

        edName = (EditText) findViewById(R.id.edName);
        edName.setOnClickListener(this);



        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                // if No error is found then only it will run
                if(i!=TextToSpeech.ERROR){
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.UK);
//                    textToSpeech.setPitch(0);
                }
            }
        });

        Toast.makeText(getApplicationContext(), "your level is: "+level, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        Intent intent;


        this.level = 0;
        if (view.getId() == btnGoBack.getId()) {
            finish();
        }

        if (btnEasy.getId() == view.getId()) {
            if (easyClicked) {
                btnEasy.setBackgroundResource(R.drawable.btndefault);
                this.level = 0;
                Toast.makeText(getApplicationContext(), "your level is: " + level, Toast.LENGTH_SHORT).show();
                easyClicked = false;
            } else {
                btnEasy.setBackgroundResource(R.drawable.btnclick);
                btnMedium.setBackgroundResource(R.drawable.btndefault);
                btnHard.setBackgroundResource(R.drawable.btndefault);
                this.level = 1;
                Toast.makeText(getApplicationContext(), "your level is: " + level, Toast.LENGTH_SHORT).show();
                easyClicked = true;
                mediumClicked = false;
                hardClicked = false;
            }
        }
        if (view.getId() == btnMedium.getId()) {
            if (mediumClicked) {
                btnMedium.setBackgroundResource(R.drawable.btndefault);
                this.level = 0;
                Toast.makeText(getApplicationContext(), "your level is: " + level, Toast.LENGTH_SHORT).show();
                mediumClicked = false;
            } else {
                btnMedium.setBackgroundResource(R.drawable.btnclick);
                //btnMedium.setBackgroundColor(0xff880011);
                btnEasy.setBackgroundResource(R.drawable.btndefault);
                btnHard.setBackgroundResource(R.drawable.btndefault);
                this.level = 2;
                easyClicked = false;
                mediumClicked = true;
                hardClicked = false;
                Toast.makeText(getApplicationContext(), "your level is: " + level, Toast.LENGTH_SHORT).show();
            }

        }
        if (view.getId() == btnHard.getId()) {
            if (hardClicked) {
                btnHard.setBackgroundResource(R.drawable.btndefault);
                this.level = 0;
                hardClicked = false;
                Toast.makeText(getApplicationContext(), "your level is: " + level, Toast.LENGTH_SHORT).show();
            } else {
                btnHard.setBackgroundResource(R.drawable.btnclick);
                //btnHard.setBackgroundColor(0xff880011);
                btnEasy.setBackgroundResource(R.drawable.btndefault);
                btnMedium.setBackgroundResource(R.drawable.btndefault);
                this.level = 3;
                Toast.makeText(getApplicationContext(), "your level is: " + level, Toast.LENGTH_SHORT).show();
                easyClicked = false;
                mediumClicked = false;
                hardClicked = true;
            }

        }
        if (view.getId() == edName.getId()) {
            this.name = edName.getText().toString().trim();

            if (this.name.length() == 0)
                new AlertDialog.Builder(this)
                        .setTitle("Error!")
                        .setMessage("Please Enter Player Name")
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }
                        )
                        .setIcon(R.drawable.eroriconlow)
                        .show(); //error icon
            else {
                    if (easyClicked == false && mediumClicked == false && hardClicked == false)
                        new AlertDialog.Builder(this)
                                .setTitle("Error!")
                                .setMessage("Please Pick Level")
                                .setNeutralButton("OK", new DialogInterface.OnClickListener() {

                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        }
                                )
                                .setIcon(R.drawable.eroriconlow)
                                .show(); //error icon

                    else {
                        if (easyClicked) {
                            sLevel = "Easy";
                            strLevel="1";
                        }
                        if (mediumClicked) {
                            sLevel = "Medium";
                            strLevel="2";
                        }
                        if (hardClicked) {
                            sLevel = "Hard";
                            strLevel="3";
                        }

                        textToSpeech.speak(" Enjoy and Good Luck" + " " + name + ".   " + "You  are  playing  in " + " " + sLevel + " " + "level",
                                TextToSpeech.QUEUE_FLUSH, null);


                        intent = new Intent(this, MainActivity.class);
                        intent.putExtra("DATA1", name);
                        intent.putExtra("DATA2", sLevel);
                        intent.putExtra("DATA3", strLevel);

                        startActivity(intent);
                    }

            }
        }
        if (view.getId() == btnPlay.getId()) {
            this.name = edName.getText().toString().trim();

            if (this.name.length() == 0)
                new AlertDialog.Builder(this)
                        .setTitle("Error!")
                        .setMessage("Please Enter Player Name")
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }
                        )
                        .setIcon(R.drawable.eroriconlow)
                        .show(); //error icon
            else{
                if (easyClicked == false && mediumClicked == false && hardClicked == false)
                    new AlertDialog.Builder(this)
                            .setTitle("Error!")
                            .setMessage("Please Pick Level")
                            .setNeutralButton("OK", new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    }
                            )
                            .setIcon(R.drawable.eroriconlow)
                            .show(); //error icon
                else
                {
                    if (easyClicked) {
                        sLevel = "Easy";
                        strLevel="1";
                    }
                    if (mediumClicked) {
                        sLevel = "Medium";
                        strLevel="2";
                    }
                    if (hardClicked) {
                        sLevel = "Hard";
                        strLevel="3";
                    }

                    textToSpeech.speak(" Enjoy and Good Luck" + " " + name + ".   " + "You  are  playing  in " + " " + sLevel + " " + "level",
                            TextToSpeech.QUEUE_FLUSH, null);


                    intent = new Intent(this, MainActivity.class);
                    intent.putExtra("DATA1", name);
                    intent.putExtra("DATA2", sLevel);
                    intent.putExtra("DATA3", strLevel);

                    startActivity(intent);
                }
            }
        }
    }
}