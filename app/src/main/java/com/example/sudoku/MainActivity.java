package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private SudManager sManager;
    public android.widget.Button[][][][]mat;
    TextView timerText;
    TextView playTime;

    TextView level;
    boolean blank=false;
    private ImageButton btnGoBack,btnPause;
    public Button btnLeader,btnRestart,btnShow;


    TextView tvName;
    Timer timer;
    public Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    private Handler handler = new Handler();
    private boolean timePause=false;
    ImageView life1,life2,life3;

    TimerTask timerTask;
    Double time = 0.0;

    int levelNum;
    String sLevel;
    String str;
    String name;
    int num=0;
    int lives=3;
    boolean pauseClicked=false;
    int resId;
    boolean btn0Clicked=false,btn1Clicked=false,btn2Clicked=false,btn3Clicked=false,btn4Clicked=false,btn5Clicked=false,
            btn6Clicked=false,btn7Clicked=false,btn8Clicked=false,btn9Clicked=false;
    boolean showClicked=false;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sManager= new SudManager();


        life1= (ImageView) findViewById(R.id.life1);
        life2= (ImageView) findViewById(R.id.life2);
        life3= (ImageView) findViewById(R.id.life3);

        btnGoBack = (ImageButton) findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(this);

        btnPause = (ImageButton) findViewById(R.id.btnPause);
        btnPause.setOnClickListener(this);

        btnLeader = (android.widget.Button) findViewById(R.id.btnLeader);
        btnLeader.setOnClickListener(this);

        btnRestart = (android.widget.Button) findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(this);

        btnShow = (android.widget.Button) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);

        btn0 = (android.widget.Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(this);

        btn1 = (android.widget.Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2 = (android.widget.Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3 = (android.widget.Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4 = (android.widget.Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn5 = (android.widget.Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn6 = (android.widget.Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        btn7 = (android.widget.Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);

        btn8 = (android.widget.Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);

        btn9 = (android.widget.Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

        playTime = (TextView) findViewById(R.id.tvPlayTime);
        tvName = (TextView) findViewById(R.id.tvPlayer);
        level = (TextView) findViewById(R.id.level);

        btnShow.setVisibility(View.INVISIBLE);

        Intent in = getIntent();
        if (in != null && in.getExtras() != null)
        {
            Bundle xtras = in.getExtras();
            name = xtras.getString("DATA1");
            sLevel = xtras.getString("DATA2");
            str= xtras.getString("DATA3");
            Log.d("^^^^^^^^", str + "");



        }
        tvName.setText(name);
        level.setText(sLevel);
        levelNum=Integer.parseInt(str);
        Log.d("@@@@@@@@", "level is: "+levelNum);

        if(name.equals("admin"))
        {
            btnShow.setVisibility(View.VISIBLE);
        }

        this.mat = new android.widget.Button[3][3][3][3];

        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        str = "img" + i + j + k + l;
                        resId = getResources().getIdentifier(str, "id", getPackageName());
                        this.mat[i][j][k][l] = (android.widget.Button) findViewById(resId);
                        this.mat[i][j][k][l].setOnClickListener(this);
                    }
                }
            }
        }
        if(levelNum==1)
        {
            sManager.setEasy(this.mat);
        }
        if(levelNum==2)
        {
            sManager.setMedium(this.mat);
        }
        if(levelNum==3)
        {
            sManager.setHard(this.mat);
        }

        if(levelNum==1)
        {
            Toast.makeText(getApplicationContext(), this.sManager.showBoardEasy(), Toast.LENGTH_LONG).show();
        }
        if(levelNum==2)
        {
            Toast.makeText(getApplicationContext(), this.sManager.showBoardMedium(), Toast.LENGTH_LONG).show();
        }
        if(levelNum==3)
        {
            Toast.makeText(getApplicationContext(), this.sManager.showBoardHard(), Toast.LENGTH_LONG).show();
        }

        timerText = (TextView) findViewById(R.id.timer);
        timer = new Timer();

        startTimer();


    }
    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_pop_up, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
    private void startTimer()
    {
        timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if(!timePause)
                        {
                        time++;
                        timerText.setText(getTimerText());
                        }
                        else
                        {
                            playTime.setVisibility(View.INVISIBLE);
                            timerText.setVisibility(View.INVISIBLE);
                            handler.postDelayed((Runnable) () ->
                            {
                                playTime.setVisibility(View.VISIBLE);
                                timerText.setVisibility(View.VISIBLE);
                            }, 500);
                        }
                    }
                });
            }

        };
        timer.scheduleAtFixedRate(timerTask, 0 ,1000);
    }


    private String getTimerText()
    {
        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);

        return formatTime(seconds, minutes, hours);
    }

    private String formatTime(int seconds, int minutes, int hours)
    {
        return String.format("%02d",hours) + " : " + String.format("%02d",minutes) + " : " + String.format("%02d",seconds);
    }
    public void lostAlert()
    {
        new AlertDialog.Builder(this)
                .setTitle("Game Over!")
                .setMessage("YOU HAVE NO MORE LIVES" + "\n"+"\n" +"TRY AGAIN!")
                .setNeutralButton("OK",new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                })
                .setIcon(R.drawable.loser)
                .show(); //loser icon
    }
    public void winAlert()
    {
        String sTime=this.getTimerText();
        new AlertDialog.Builder(this)
                .setTitle("       "+"GAME OVER!")
                .setMessage("         YOU FINISHED THE GAME!" + "\n"+"\n" +"         You Completed "+ sLevel +" Level"
                        +"\n"+"                      "+"In "+ sTime)
                .setNeutralButton("                         OK",new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                })
                .setIcon(R.drawable.winnericon)
                .show(); //winner icon
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId()== btnLeader.getId())
        {
            this.onButtonShowPopupWindowClick(view);
        }


        if(view.getId() == btnShow.getId())
        {
            if(!showClicked)
            {
            sManager.solveBoard(this.mat,this.levelNum);
            showClicked=true;
            }
            else
            {
                sManager.reBoard(this.mat,this.levelNum);
                showClicked=false;
            }
        }

        Intent intent;
        if (view.getId() == btnGoBack.getId())
        {
            intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
        if(view.getId()==btnPause.getId())
        {
            if(!pauseClicked)
            {
                timePause=true;
                playTime.setText("Pause Time:");
                playTime.setTextColor(0xff880011);
                timerText.setTextColor(0xff880011);
                pauseClicked=true;
                sManager.pauseGame(this.mat,this.btn0,this.btn1,this.btn2,this.btn3,this.btn4,this.btn5,this.btn6
                        ,this.btn7,this.btn8,this.btn9,this.btnRestart,this.btnLeader);
                btnPause.setBackgroundResource(R.drawable.ic_play);
            }
            else
            {
                timePause=false;
                playTime.setText("Play Time:");
                playTime.setTextColor(0xff018786);
                timerText.setTextColor(0xff018786);
                pauseClicked=false;
                sManager.resumeGame(this.mat,this.btn0,this.btn1,this.btn2,this.btn3,this.btn4,this.btn5,this.btn6
                        ,this.btn7,this.btn8,this.btn9,this.btnRestart,this.btnLeader);
                btnPause.setBackgroundResource(R.drawable.ic_pause);

            }
        }
        if(view.getId()==btnRestart.getId())
        {
            playTime.setText("Play Time:");
            playTime.setTextColor(0xff018786);
            timerText.setTextColor(0xff018786);
            timePause=false;
            this.time=0.0;
            sManager.backgroundFix(btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
            btn1.setBackgroundResource(R.drawable.back);
            btn0.setBackgroundResource(R.drawable.ic_action_trash);
            num = 0;
            sManager.restartBoard(this.mat,this.levelNum);
            this.lives=3;
            this.life1.setVisibility(View.VISIBLE);
            this.life2.setVisibility(View.VISIBLE);
            this.life3.setVisibility(View.VISIBLE);
        }


        if(!sManager.isFinished(lives,levelNum))
        {
            if(btn0.getId()==view.getId())
            {
                if(!btn0Clicked)
                {
                    btn0.setBackgroundResource(R.drawable.ic_click_trash);
                    sManager.backgroundFix(btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9);
                    btn1.setBackgroundResource(R.drawable.back);
                    blank=true;
                    num=0;
                    btn0Clicked=true;
                    btn1Clicked=false;
                    btn2Clicked=false;
                    btn3Clicked=false;
                    btn4Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                    Log.d(">>>>>>>>>>","btn0Clicked at false"+btn0Clicked);
                }
                else
                {
                    btn0.setBackgroundResource(R.drawable.ic_action_trash);
                    blank=false;
                    btn0Clicked=false;
                    btn1Clicked=false;
                    btn2Clicked=false;
                    btn3Clicked=false;
                    btn4Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                    Log.d(">>>>>>>>>>","btn0Clicked at true"+btn0Clicked);


                }
            }
            if(btn1.getId()==view.getId())
            {
                if(btn1Clicked)
                {
                    btn1.setBackgroundResource(R.drawable.back);
                    num=0;
                    btn1Clicked=false;
                    btn0Clicked=false;
                    btn2Clicked=false;
                    btn3Clicked=false;
                    btn4Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                }
                else
                {
                    sManager.BackgroundClick(btn1);
                    sManager.backgroundFix(btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                    btn0.setBackgroundResource(R.drawable.ic_action_trash);
                    num = sManager.numText(btn1);
                    blank = false;
                    btn1Clicked=true;
                    btn0Clicked=false;
                    btn2Clicked=false;
                    btn3Clicked=false;
                    btn4Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                    Log.d("&&&&&&&&&", num + "");
                }

            }
            if(btn2.getId()==view.getId())
            {
                if(btn2Clicked)
                {
                    btn2.setBackgroundResource(R.drawable.back);
                    num=0;
                    btn2Clicked=false;
                    btn1Clicked=false;
                    btn0Clicked=false;
                    btn3Clicked=false;
                    btn4Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                }
                else
                {
                    sManager.BackgroundClick(btn2);
                    sManager.backgroundFix(btn1,btn3,btn4,btn5,btn6,btn7,btn8,btn9);
                    btn0.setBackgroundResource(R.drawable.ic_action_trash);
                    num=sManager.numText(btn2);
                    blank=false;
                    btn2Clicked=true;
                    btn1Clicked=false;
                    btn0Clicked=false;
                    btn3Clicked=false;
                    btn4Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                    Log.d("&&&&&&&&&",num+"");
                }
            }
            if(btn3.getId()==view.getId())
            {
                if(btn3Clicked)
                {
                    btn3.setBackgroundResource(R.drawable.back);
                    num=0;
                    btn3Clicked=false;
                    btn1Clicked=false;
                    btn2Clicked=false;
                    btn0Clicked=false;
                    btn4Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                }
                else
                {
                    sManager.BackgroundClick(btn3);
                    sManager.backgroundFix(btn2,btn1,btn4,btn5,btn6,btn7,btn8,btn9);
                    btn0.setBackgroundResource(R.drawable.ic_action_trash);
                    num=sManager.numText(btn3);
                    blank=false;
                    btn3Clicked=true;
                    btn1Clicked=false;
                    btn2Clicked=false;
                    btn0Clicked=false;
                    btn4Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                    Log.d("&&&&&&&&&",num+"");
                }

            }
            if(btn4.getId()==view.getId())
            {
                if(btn4Clicked)
                {
                    btn4.setBackgroundResource(R.drawable.back);
                    num=0;
                    btn4Clicked=false;
                    btn1Clicked=false;
                    btn2Clicked=false;
                    btn3Clicked=false;
                    btn0Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                }
                else
                {
                    sManager.BackgroundClick(btn4);
                    sManager.backgroundFix(btn2,btn3,btn1,btn5,btn6,btn7,btn8,btn9);
                    btn0.setBackgroundResource(R.drawable.ic_action_trash);
                    num=sManager.numText(btn4);
                    blank=false;
                    btn4Clicked=true;
                    btn1Clicked=false;
                    btn2Clicked=false;
                    btn3Clicked=false;
                    btn0Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                    Log.d("&&&&&&&&&",num+"");
                }

            }
            if(btn5.getId()==view.getId())
            {
               if(btn5Clicked)
               {
                   btn5.setBackgroundResource(R.drawable.back);
                   num=0;
                   btn5Clicked=false;
                   btn1Clicked=false;
                   btn2Clicked=false;
                   btn3Clicked=false;
                   btn4Clicked=false;
                   btn0Clicked=false;
                   btn6Clicked=false;
                   btn7Clicked=false;
                   btn8Clicked=false;
                   btn9Clicked=false;
               }
                else
                {
                    sManager.BackgroundClick(btn5);
                    sManager.backgroundFix(btn2,btn3,btn4,btn1,btn6,btn7,btn8,btn9);
                    btn0.setBackgroundResource(R.drawable.ic_action_trash);
                    num=sManager.numText(btn5);
                    blank=false;
                    btn5Clicked=true;
                    btn1Clicked=false;
                    btn2Clicked=false;
                    btn3Clicked=false;
                    btn4Clicked=false;
                    btn0Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                    Log.d("&&&&&&&&&",num+"");
                }

            }
            if(btn6.getId()==view.getId())
            {
                if(btn6Clicked)
                {
                    btn6.setBackgroundResource(R.drawable.back);
                    num=0;
                    btn6Clicked=false;
                    btn1Clicked=false;
                    btn2Clicked=false;
                    btn3Clicked=false;
                    btn4Clicked=false;
                    btn5Clicked=false;
                    btn0Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                }
                else
                {
                sManager.BackgroundClick(btn6);
                sManager.backgroundFix(btn2,btn3,btn4,btn5,btn1,btn7,btn8,btn9);
                btn0.setBackgroundResource(R.drawable.ic_action_trash);
                num=sManager.numText(btn6);
                blank=false;
                btn6Clicked=true;
                btn1Clicked=false;
                btn2Clicked=false;
                btn3Clicked=false;
                btn4Clicked=false;
                btn5Clicked=false;
                btn0Clicked=false;
                btn7Clicked=false;
                btn8Clicked=false;
                btn9Clicked=false;
                Log.d("&&&&&&&&&",num+"");
                }

            }
            if(btn7.getId()==view.getId())
            {
                if(btn7Clicked)
                {
                    btn7.setBackgroundResource(R.drawable.back);
                    num=0;
                    btn7Clicked=false;
                    btn1Clicked=false;
                    btn2Clicked=false;
                    btn3Clicked=false;
                    btn4Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn0Clicked=false;
                    btn8Clicked=false;
                    btn9Clicked=false;
                }
                else
                {
                sManager.BackgroundClick(btn7);
                sManager.backgroundFix(btn2,btn3,btn4,btn5,btn6,btn1,btn8,btn9);
                btn0.setBackgroundResource(R.drawable.ic_action_trash);
                num=sManager.numText(btn7);
                blank=false;
                btn7Clicked=true;
                btn1Clicked=false;
                btn2Clicked=false;
                btn3Clicked=false;
                btn4Clicked=false;
                btn5Clicked=false;
                btn6Clicked=false;
                btn0Clicked=false;
                btn8Clicked=false;
                btn9Clicked=false;
                Log.d("&&&&&&&&&",num+"");
                }
            }
            if(btn8.getId()==view.getId())
            {
                if(btn8Clicked)
                {
                    btn8.setBackgroundResource(R.drawable.back);
                    num=0;
                    btn8Clicked=false;
                    btn1Clicked=false;
                    btn2Clicked=false;
                    btn3Clicked=false;
                    btn4Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn0Clicked=false;
                    btn9Clicked=false;
                }
                else
                {
                sManager.BackgroundClick(btn8);
                sManager.backgroundFix(btn2,btn3,btn4,btn5,btn6,btn7,btn1,btn9);
                btn0.setBackgroundResource(R.drawable.ic_action_trash);
                num=sManager.numText(btn8);
                blank=false;
                btn8Clicked=true;
                btn1Clicked=false;
                btn2Clicked=false;
                btn3Clicked=false;
                btn4Clicked=false;
                btn5Clicked=false;
                btn6Clicked=false;
                btn7Clicked=false;
                btn0Clicked=false;
                btn9Clicked=false;
                Log.d("&&&&&&&&&",num+"");
                }
            }
            if(btn9.getId()==view.getId())
            {
                if(btn9Clicked)
                {
                    btn9.setBackgroundResource(R.drawable.back);
                    num=0;
                    btn9Clicked=false;
                    btn1Clicked=false;
                    btn2Clicked=false;
                    btn3Clicked=false;
                    btn4Clicked=false;
                    btn5Clicked=false;
                    btn6Clicked=false;
                    btn7Clicked=false;
                    btn8Clicked=false;
                    btn0Clicked=false;
                }
                else
                {
                sManager.BackgroundClick(btn9);
                sManager.backgroundFix(btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn1);
                btn0.setBackgroundResource(R.drawable.ic_action_trash);
                num=sManager.numText(btn9);
                blank=false;
                btn9Clicked=true;
                btn1Clicked=false;
                btn2Clicked=false;
                btn3Clicked=false;
                btn4Clicked=false;
                btn5Clicked=false;
                btn6Clicked=false;
                btn7Clicked=false;
                btn8Clicked=false;
                btn0Clicked=false;

                Log.d("&&&&&&&&&",num+"");
                }
            }

        }

        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        if(this.mat[i][j][k][l].getId()==view.getId())
                        {
                            btn1Clicked=false;
                            btn2Clicked=false;
                            btn3Clicked=false;
                            btn4Clicked=false;
                            btn5Clicked=false;
                            btn6Clicked=false;
                            btn7Clicked=false;
                            btn8Clicked=false;
                            btn0Clicked=false;
                            btn9Clicked=false;
                            sManager.backgroundFix(btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn1);
                            btn0.setBackgroundResource(R.drawable.ic_action_trash);

                            if(num>0)
                            {
                                this.mat[i][j][k][l].setText(Integer.toString(num));

                                if(levelNum==1)
                                {
                                    sManager.easyBoards[sManager.rNum][i][j][k][l] = num;
                                    Log.d("----------", sManager.showBoardEasy() + "");
                                }
                                if(levelNum==2)
                                {
                                    sManager.mediumBoards[sManager.rNum][i][j][k][l] = num;
                                    Log.d("----------", sManager.showBoardMedium() + "");
                                }
                                if(levelNum==3)
                                {
                                    sManager.hardBoards[sManager.rNum][i][j][k][l] = num;
                                    Log.d("----------", sManager.showBoardHard() + "");
                                }

                                if (!sManager.isValid(i, j, k, l, levelNum))
                                {
                                    this.mat[i][j][k][l].setTextColor(0xffff0000);
                                    handler.postDelayed((Runnable) () ->
                                    {

                                        if(this.lives==3)
                                        {
                                            this.lives--;
                                            this.life3.setVisibility(View.INVISIBLE);
                                            Toast.makeText(getApplicationContext(),"wrong!"+"\n"+"YOU HAVE 2 LIVES LEFT", Toast.LENGTH_LONG).show();

                                        }
                                        else
                                        {
                                            if(this.lives==2)
                                            {
                                                this.lives--;
                                                this.life2.setVisibility(View.INVISIBLE);
                                                Toast.makeText(getApplicationContext(),"wrong!"+"\n"+"YOU HAVE 1 LIFE LEFT", Toast.LENGTH_LONG).show();

                                            }
                                            else
                                            {
                                                if(this.lives==1)
                                                {
                                                    this.lives--;
                                                    this.life1.setVisibility(View.INVISIBLE);
                                                    sManager.backgroundFix(this.btn1,this.btn2,this.btn3,this.btn4,this.btn5
                                                            ,this.btn6,this.btn7,this.btn8);
                                                    btn0.setBackgroundResource(R.drawable.ic_action_trash);
                                                    btn9.setBackgroundResource(R.drawable.back);
                                                    this.num=0;

                                                    timePause=true;

                                                    handler.postDelayed((Runnable) () -> {
                                                        this.lostAlert();
                                                    }, 500);

                                                }
                                            }
                                        }
                                    }, 1000);
                                } else
                                {
                                    this.mat[i][j][k][l].setTextColor(0xff018786);
                                    sManager.backgroundFix(btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                                    btn1.setBackgroundResource(R.drawable.back);
                                    btn0.setBackgroundResource(R.drawable.ic_action_trash);
                                    num = 0;
                                }
                            }
                            if(blank)
                            {
                                this.mat[i][j][k][l].setText("");

                                if(levelNum==1)
                                {
                                    sManager.easyBoards[sManager.rNum][i][j][k][l] = 0;
                                    Log.d("----------", sManager.showBoardEasy() + "");
                                }
                                if(levelNum==2)
                                {
                                    sManager.mediumBoards[sManager.rNum][i][j][k][l] = 0;
                                    Log.d("----------", sManager.showBoardMedium() + "");
                                }
                                if(levelNum==3)
                                {
                                    sManager.hardBoards[sManager.rNum][i][j][k][l] = 0;
                                    Log.d("----------", sManager.showBoardHard() + "");
                                }
                                this.mat[i][j][k][l].setTextColor(0xff018786);
                                sManager.backgroundFix(btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
                                btn1.setBackgroundResource(R.drawable.back);
                                btn0.setBackgroundResource(R.drawable.ic_action_trash);
                                num = 0;

                            }
                        }

                    }
                }
            }
        }
        if(sManager.boardValid(levelNum))
        {
            Log.d("=========",  "boardValid is true");
            this.winAlert();
            timePause=true;
            playTime.setText("Finish Time:");
            playTime.setTextColor(0xff00ff00);
            timerText.setTextColor(0xff00ff00);
        }

    }

}
