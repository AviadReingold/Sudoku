package com.example.sudoku;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class SudManager
{
    private MainActivity mActivity;
    private Handler handler = new Handler();
    int rNum;


    public int [][][][][] easyBoards;
    public int [][][][][] mediumBoards;
    public int [][][][][] hardBoards;
    public int [][][][] gameBoard;


    private int[][][][] easy0;
    private int[][][][] easy1;
    private int[][][][] easy2;

    private int[][][][] medium0;
    private int[][][][] medium1;
    private int[][][][] medium2;

    private int[][][][] hard0;
    private int[][][][] hard1;
    private int[][][][] hard2;



//    private int[][][][] matx;
//    private int[][] matx00;
//    private int[][] matx01;
//    private int[][] matx02;
//    private int[][] matx10;
//    private int[][] matx11;
//    private int[][] matx12;
//    private int[][] matx20;
//    private int[][] matx21;
//    private int[][] matx22;
//



    public SudManager()
    {


//    this.matx= new int[3][3][3][3];
//    this.matx00= new int[3][3];
//    this.matx01= new int[3][3];
//    this.matx02= new int[3][3];
//    this.matx10= new int[3][3];
//    this.matx11= new int[3][3];
//    this.matx12= new int[3][3];
//    this.matx20= new int[3][3];
//    this.matx21= new int[3][3];
//    this.matx22= new int[3][3];
//
//        this.matx[0][0]=this.matx00;
//        this.matx[0][1]=this.matx01;
//        this.matx[0][2]=this.matx02;
//        this.matx[1][0]=this.matx10;
//        this.matx[1][1]=this.matx11;
//        this.matx[1][2]=this.matx12;
//        this.matx[2][0]=this.matx20;
//        this.matx[2][1]=this.matx21;
//        this.matx[2][2]=this.matx22;
//        this.ipusMat(matx);

        this.gameBoard=new int[3][3][3][3];
        this.easyBoards=new int[3][3][3][3][3];
        this.mediumBoards=new int[3][3][3][3][3];
        this.hardBoards=new int[3][3][3][3][3];


        this.easy0=new int[3][3][3][3];
        this.ipusMat(easy0);
        this.easy0[0][0][0][1]=2;
        this.easy0[0][0][2][0]=3;
        this.easy0[0][1][0][0]=9;
        this.easy0[0][1][0][2]=7;
        this.easy0[0][1][1][0]=4;
        this.easy0[0][1][1][1]=6;
        this.easy0[0][2][0][1]=8;
        this.easy0[0][2][1][0]=1;
        this.easy0[0][2][1][1]=2;
        this.easy0[0][2][2][0]=6;
        this.easy0[1][0][0][1]=6;
        this.easy0[1][0][0][2]=7;
        this.easy0[1][0][1][0]=8;
        this.easy0[1][0][1][2]=3;
        this.easy0[1][1][1][0]=1;
        this.easy0[1][1][1][2]=6;
        this.easy0[1][1][2][1]=7;
        this.easy0[1][2][0][0]=8;
        this.easy0[1][2][2][1]=9;
        this.easy0[2][0][0][1]=4;
        this.easy0[2][0][0][2]=6;
        this.easy0[2][0][1][0]=1;
        this.easy0[2][0][2][0]=9;
        this.easy0[2][0][2][1]=3;
        this.easy0[2][0][2][2]=2;
        this.easy0[2][1][0][0]=5;
        this.easy0[2][1][0][1]=1;
        this.easy0[2][1][0][2]=9;
        this.easy0[2][1][2][0]=6;
        this.easy0[2][1][2][1]=8;
        this.easy0[2][2][0][0]=2;
        this.easy0[2][2][0][2]=8;
        this.easy0[2][2][1][0]=9;
        this.easy0[2][2][1][2]=4;
        this.easy0[2][2][2][0]=5;
        this.easy0[2][2][2][2]=7;
        this.easyBoards[0]=this.easy0;

        this.easy1= new int[3][3][3][3];
        this.ipusMat(easy1);
        this.easy1[0][0][1][0]=6;
        this.easy1[0][0][1][1]=8;
        this.easy1[0][0][2][0]=1;
        this.easy1[0][0][2][1]=9;
        this.easy1[0][1][0][0]=2;
        this.easy1[0][1][0][1]=6;
        this.easy1[0][1][1][1]=7;
        this.easy1[0][1][2][2]=4;
        this.easy1[0][2][0][0]=7;
        this.easy1[0][2][0][2]=1;
        this.easy1[0][2][1][1]=9;
        this.easy1[0][2][2][0]=5;
        this.easy1[1][0][0][0]=8;
        this.easy1[1][0][0][1]=2;
        this.easy1[1][0][1][2]=4;
        this.easy1[1][0][2][1]=5;
        this.easy1[1][1][0][0]=1;
        this.easy1[1][1][1][0]=6;
        this.easy1[1][1][1][2]=2;
        this.easy1[1][1][2][2]=3;
        this.easy1[1][2][0][1]=4;
        this.easy1[1][2][1][0]=9;
        this.easy1[1][2][2][1]=2;
        this.easy1[1][2][2][2]=8;
        this.easy1[2][0][0][2]=9;
        this.easy1[2][0][1][1]=4;
        this.easy1[2][0][2][0]=7;
        this.easy1[2][0][2][2]=3;
        this.easy1[2][1][0][0]=3;
        this.easy1[2][1][1][1]=5;
        this.easy1[2][1][2][1]=1;
        this.easy1[2][1][2][2]=8;
        this.easy1[2][2][0][1]=7;
        this.easy1[2][2][0][2]=4;
        this.easy1[2][2][1][1]=3;
        this.easy1[2][2][1][2]=6;
        this.easyBoards[1]=this.easy1;

        this.easy2=new int[3][3][3][3];
        this.ipusMat(easy2);
        this.easy2[0][0][0][1]=4;
        this.easy2[0][0][0][2]=8;
        this.easy2[0][0][1][2]=5;
        this.easy2[0][1][1][0]=3;
        this.easy2[0][1][1][1]=8;
        this.easy2[0][1][1][2]=1;
        this.easy2[0][1][2][1]=5;
        this.easy2[0][2][0][0]=5;
        this.easy2[0][2][1][1]=4;
        this.easy2[0][2][1][2]=9;
        this.easy2[1][0][0][0]=8;
        this.easy2[1][0][0][2]=3;
        this.easy2[1][0][1][0]=1;
        this.easy2[1][0][1][1]=6;
        this.easy2[1][0][1][2]=9;
        this.easy2[1][0][2][1]=5;
        this.easy2[1][0][2][2]=4;
        this.easy2[1][1][0][0]=5;
        this.easy2[1][1][0][1]=1;
        this.easy2[1][1][0][2]=7;
        this.easy2[1][1][1][1]=2;
        this.easy2[1][1][2][0]=9;
        this.easy2[1][2][0][0]=4;
        this.easy2[1][2][1][0]=7;
        this.easy2[2][0][0][0]=5;
        this.easy2[2][0][0][1]=1;
        this.easy2[2][0][0][2]=6;
        this.easy2[2][0][1][0]=4;
        this.easy2[2][0][1][2]=2;
        this.easy2[2][1][0][0]=2;
        this.easy2[2][1][0][1]=9;
        this.easy2[2][1][1][0]=6;
        this.easy2[2][1][2][1]=4;
        this.easy2[2][1][2][2]=5;
        this.easy2[2][2][0][2]=4;
        this.easy2[2][2][1][0]=1;
        this.easy2[2][2][1][2]=5;
        this.easy2[2][2][2][0]=9;
        this.easyBoards[2]=this.easy2;

        this.medium0=new int[3][3][3][3];
        this.ipusMat(medium0);
        this.medium0[0][0][0][1]=1;
        this.medium0[0][0][0][2]=3;
        this.medium0[0][0][1][1]=2;
        this.medium0[0][1][0][0]=9;
        this.medium0[0][1][1][2]=5;
        this.medium0[0][1][2][0]=7;
        this.medium0[0][2][0][1]=7;
        this.medium0[0][2][0][2]=5;
        this.medium0[0][2][1][0]=9;
        this.medium0[0][2][2][2]=1;
        this.medium0[1][0][1][0]=3;
        this.medium0[1][0][1][1]=6;
        this.medium0[1][1][1][1]=1;
        this.medium0[1][1][2][2]=7;
        this.medium0[1][2][0][0]=8;
        this.medium0[1][2][2][2]=9;
        this.medium0[2][0][0][0]=4;
        this.medium0[2][0][0][2]=1;
        this.medium0[2][0][1][0]=7;
        this.medium0[2][0][2][2]=2;
        this.medium0[2][1][0][1]=6;
        this.medium0[2][1][1][0]=5;
        this.medium0[2][1][1][1]=8;
        this.medium0[2][1][2][0]=4;
        this.medium0[2][1][2][1]=7;
        this.medium0[2][1][2][2]=3;
        this.medium0[2][2][0][0]=3;
        this.medium0[2][2][1][2]=2;
        this.medium0[2][2][2][0]=5;
        this.medium0[2][2][2][2]=6;
        this.mediumBoards[0]=this.medium0;

        this.medium1=new int[3][3][3][3];
        this.ipusMat(medium1);
        this.medium1[0][0][0][1]=6;
        this.medium1[0][0][0][2]=1;
        this.medium1[0][0][1][0]=5;
        this.medium1[0][0][1][2]=8;
        this.medium1[0][0][2][1]=7;
        this.medium1[0][1][0][1]=8;
        this.medium1[0][1][1][0]=6;
        this.medium1[0][1][1][2]=4;
        this.medium1[0][2][0][1]=3;
        this.medium1[0][2][1][0]=2;
        this.medium1[0][2][2][0]=8;
        this.medium1[1][0][0][1]=4;
        this.medium1[1][0][0][2]=7;
        this.medium1[1][0][1][0]=6;
        this.medium1[1][0][1][1]=9;
        this.medium1[1][1][0][1]=6;
        this.medium1[1][1][0][2]=9;
        this.medium1[1][1][2][0]=4;
        this.medium1[1][1][2][1]=3;
        this.medium1[1][2][1][0]=4;
        this.medium1[1][2][1][1]=1;
        this.medium1[1][2][2][0]=6;
        this.medium1[2][0][0][0]=3;
        this.medium1[2][0][0][1]=8;
        this.medium1[2][0][0][2]=2;
        this.medium1[2][1][0][0]=9;
        this.medium1[2][1][0][1]=1;
        this.medium1[2][1][0][2]=6;
        this.medium1[2][1][1][2]=8;
        this.medium1[2][1][2][2]=3;
        this.medium1[2][2][2][1]=8;
        this.medium1[2][2][2][2]=2;
        this.mediumBoards[1]=this.medium1;

        this.medium2=new int[3][3][3][3];
        this.ipusMat(medium2);
        this.medium2[0][0][0][0]=9;
        this.medium2[0][0][0][2]=6;
        this.medium2[0][0][2][0]=4;
        this.medium2[0][1][0][0]=8;
        this.medium2[0][1][0][2]=1;
        this.medium2[0][1][1][0]=3;
        this.medium2[0][1][1][2]=9;
        this.medium2[0][1][2][2]=6;
        this.medium2[0][2][0][1]=4;
        this.medium2[1][0][1][0]=7;
        this.medium2[1][0][1][1]=3;
        this.medium2[1][0][1][2]=4;
        this.medium2[1][0][2][0]=6;
        this.medium2[1][1][1][0]=5;
        this.medium2[1][2][0][2]=8;
        this.medium2[1][2][1][2]=2;
        this.medium2[2][0][0][0]=5;
        this.medium2[2][0][2][0]=1;
        this.medium2[2][0][2][1]=9;
        this.medium2[2][0][2][2]=7;
        this.medium2[2][1][0][0]=4;
        this.medium2[2][1][0][2]=7;
        this.medium2[2][1][1][0]=9;
        this.medium2[2][1][1][1]=1;
        this.medium2[2][1][1][2]=5;
        this.medium2[2][2][0][1]=1;
        this.medium2[2][2][0][2]=3;
        this.medium2[2][2][1][0]=6;
        this.medium2[2][2][2][0]=2;
        this.mediumBoards[2]=this.medium2;

        this.hard0=new int[3][3][3][3];
        this.ipusMat(hard0);
        this.hard0[0][0][0][0]=3;
        this.hard0[0][0][1][0]=9;
        this.hard0[0][1][0][0]=7;
        this.hard0[0][1][1][2]=2;
        this.hard0[0][1][2][1]=1;
        this.hard0[0][1][2][2]=6;
        this.hard0[0][2][0][2]=2;
        this.hard0[0][2][1][1]=1;
        this.hard0[1][0][0][2]=9;
        this.hard0[1][0][2][0]=8;
        this.hard0[1][1][0][0]=2;
        this.hard0[1][1][2][0]=5;
        this.hard0[1][2][0][0]=4;
        this.hard0[1][2][2][2]=7;
        this.hard0[2][0][0][2]=5;
        this.hard0[2][0][1][2]=4;
        this.hard0[2][0][2][2]=6;
        this.hard0[2][1][0][0]=9;
        this.hard0[2][1][1][0]=6;
        this.hard0[2][1][1][1]=5;
        this.hard0[2][2][0][2]=8;
        this.hard0[2][2][1][1]=7;
        this.hard0[2][2][2][2]=1;
        this.hardBoards[0]=this.hard0;

        this.hard1=new int[3][3][3][3];
        this.ipusMat(hard1);
        this.hard1[0][0][1][2]=6;
        this.hard1[0][0][2][2]=9;
        this.hard1[0][1][1][2]=4;
        this.hard1[0][1][2][0]=3;
        this.hard1[0][2][0][1]=4;
        this.hard1[0][2][0][2]=5;
        this.hard1[0][2][1][2]=3;
        this.hard1[0][2][2][0]=1;
        this.hard1[1][0][0][0]=6;
        this.hard1[1][0][1][2]=8;
        this.hard1[1][1][0][1]=2;
        this.hard1[1][1][1][0]=1;
        this.hard1[1][2][0][0]=3;
        this.hard1[1][2][1][0]=7;
        this.hard1[2][0][0][0]=7;
        this.hard1[2][0][1][0]=2;
        this.hard1[2][0][2][0]=5;
        this.hard1[2][1][0][0]=8;
        this.hard1[2][1][1][2]=1;
        this.hard1[2][1][2][0]=4;
        this.hard1[2][2][0][0]=6;
        this.hard1[2][2][1][0]=5;
        this.hard1[2][2][1][1]=7;
        this.hardBoards[1]=this.hard1;

        this.hard2=new int[3][3][3][3];
        this.ipusMat(hard2);
        this.hard2[0][0][0][0]=4;
        this.hard2[0][0][2][1]=3;
        this.hard2[0][1][1][0]=7;
        this.hard2[0][1][1][2]=5;
        this.hard2[0][2][0][0]=7;
        this.hard2[0][2][0][2]=1;
        this.hard2[0][2][2][0]=4;
        this.hard2[1][0][0][0]=9;
        this.hard2[1][0][0][1]=2;
        this.hard2[1][0][1][0]=1;
        this.hard2[1][0][2][1]=4;
        this.hard2[1][0][2][2]=7;
        this.hard2[1][1][1][1]=2;
        this.hard2[1][1][2][0]=0;
        this.hard2[2][0][0][2]=3;
        this.hard2[2][1][0][0]=9;
        this.hard2[2][1][0][2]=4;
        this.hard2[2][1][1][1]=5;
        this.hard2[2][1][2][1]=1;
        this.hard2[2][2][0][0]=2;
        this.hard2[2][2][0][1]=7;
        this.hard2[2][2][0][2]=6;
        this.hard2[2][2][1][1]=3;
        this.hard2[2][2][2][0]=9;
        this.hard2[2][2][2][1]=4;

        this.hardBoards[2]=this.hard2;


    }
    public void ipusMat(int[][][][]matix)
    {
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                for (int k=0; k<3; k++){
                    for (int l=0; l<3; l++){
                        matix[i][j][k][l]=0;
                    }
                }
            }
        }
    }

    public void restartBoard(android.widget.Button[][][][]mat,int levelNum)
    {

        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        {
                            if((gameBoard[i][j][k][l])>0)
                            {
                                mat[i][j][k][l].setClickable(false);
                                mat[i][j][k][l].setText(Integer.toString(gameBoard[i][j][k][l]));
                                mat[i][j][k][l].setTextColor(0xff000000);
                                Log.d("!!!!!!!!", mat[i][j][k][l].getText() + "");

                            }
                            if(gameBoard[i][j][k][l]==0)
                            {
                                mat[i][j][k][l].setText("");
                                mat[i][j][k][l].setClickable(true);
                                mat[i][j][k][l].setTextColor(0xff018786);
                                Log.d("*******", mat[i][j][k][l].getText() + "");
                            }

                            if(levelNum==1)
                            {
                                easyBoards[rNum][i][j][k][l]=gameBoard[i][j][k][l];
                            }
                            if(levelNum==2)
                            {
                                mediumBoards[rNum][i][j][k][l]=gameBoard[i][j][k][l];
                            }
                            if(levelNum==3)
                            {
                                hardBoards[rNum][i][j][k][l]=gameBoard[i][j][k][l];
                            }
                        }
                    }
                }
            }
        }
    }
    public void setEasy(android.widget.Button[][][][]mat)
    {
       int max=2;
       int min=0;
       int random = new Random().nextInt((max - min) + 1) + min;
       rNum=random;
        Log.d("%%%%%%%%", "random number is: "+rNum);
        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        gameBoard[i][j][k][l]=easyBoards[rNum][i][j][k][l];
                        {
                            if((easyBoards[rNum][i][j][k][l])>0)
                            {
                                mat[i][j][k][l].setClickable(false);
                                mat[i][j][k][l].setText(Integer.toString(easyBoards[rNum][i][j][k][l]));
                                mat[i][j][k][l].setTextColor(0xff000000);
                                Log.d("!!!!!!!!", mat[i][j][k][l].getText() + "");

                            }
                            if(easyBoards[rNum][i][j][k][l]==0)
                            {
                                mat[i][j][k][l].setClickable(true);
                                mat[i][j][k][l].setTextColor(0xff018786);
                                Log.d("*******", mat[i][j][k][l].getText() + "");
                            }
                        }
                    }
                }
            }
        }
    }

    public void setMedium(android.widget.Button[][][][]mat)
    {
        int max=2;
        int min=0;
        int random = new Random().nextInt((max - min) + 1) + min;
        rNum=random;
        Log.d("%%%%%%%%", rNum + "");

        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        gameBoard[i][j][k][l]=mediumBoards[rNum][i][j][k][l];

                        {
                            if((mediumBoards[rNum][i][j][k][l])>0)
                            {

                                mat[i][j][k][l].setClickable(false);
                                mat[i][j][k][l].setText(Integer.toString(mediumBoards[rNum][i][j][k][l]));
                                mat[i][j][k][l].setTextColor(0xff000000);
                                Log.d("!!!!!!!", mat[i][j][k][l].getText() + "");
                            }
                            if(mediumBoards[rNum][i][j][k][l]==0)
                            {
                                mat[i][j][k][l].setClickable(true);
                                mat[i][j][k][l].setTextColor(0xff018786);
                                Log.d("********", mat[i][j][k][l].getText() + "");
                            }

                        }
                    }
                }
            }
        }
    }
    public void setHard(android.widget.Button[][][][]mat)
    {
        int max=2;
        int min=0;
        int random = new Random().nextInt((max - min) + 1) + min;
        rNum=random;
        Log.d("%%%%%%%%", rNum + "");

        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        gameBoard[i][j][k][l]=hardBoards[rNum][i][j][k][l];

                        {
                            if((hardBoards[rNum][i][j][k][l])>0)
                            {

                                mat[i][j][k][l].setClickable(false);
                                mat[i][j][k][l].setText(Integer.toString(hardBoards[rNum][i][j][k][l]));
                                mat[i][j][k][l].setTextColor(0xff000000);
                                Log.d("!!!!!!!", mat[i][j][k][l].getText() + "");
                            }
                            if(hardBoards[rNum][i][j][k][l]==0)
                            {
                                mat[i][j][k][l].setClickable(true);
                                mat[i][j][k][l].setTextColor(0xff018786);
                                Log.d("********", mat[i][j][k][l].getText() + "");
                            }

                        }
                    }
                }
            }
        }
    }
    public Button btnByNum(int num,Button btn0,Button btn1,Button btn2,Button btn3,Button btn4,Button btn5
            ,Button btn6,Button btn7,Button btn8,Button btn9)
    {
        if(num==0)
        {
            return btn0;
        }
        if(num==1)
        {
            return btn1;
        }
        if(num==2)
        {
            return btn2;
        }
        if(num==3)
        {
            return btn3;
        }
        if(num==4)
        {
            return btn4;
        }
        if(num==5)
        {
            return btn5;
        }
        if(num==6)
        {
            return btn6;
        }
        if(num==7)
        {
            return btn7;
        }
        if(num==8)
        {
            return btn8;
        }
        return btn9;
    }
    public void pauseGame(android.widget.Button[][][][]mat,Button btn0,Button btn1,Button btn2,Button btn3,Button btn4,Button btn5,Button btn6
            ,Button btn7,Button btn8,Button btn9,Button btnRestart,Button btnLeader)
    {
        btn0.setVisibility(View.INVISIBLE);
        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);
        btn5.setVisibility(View.INVISIBLE);
        btn6.setVisibility(View.INVISIBLE);
        btn7.setVisibility(View.INVISIBLE);
        btn8.setVisibility(View.INVISIBLE);
        btn9.setVisibility(View.INVISIBLE);
        btnRestart.setVisibility(View.INVISIBLE);
        btnLeader.setVisibility(View.INVISIBLE);
        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        mat[i][j][k][l].setVisibility(View.INVISIBLE);
                    }
                }
            }
        }
    }
    public void resumeGame(android.widget.Button[][][][]mat,Button btn0,Button btn1,Button btn2,Button btn3,Button btn4,Button btn5,Button btn6
            ,Button btn7,Button btn8,Button btn9,Button btnRestart,Button btnLeader)
    {
        btn0.setVisibility(View.VISIBLE);
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
        btn6.setVisibility(View.VISIBLE);
        btn7.setVisibility(View.VISIBLE);
        btn8.setVisibility(View.VISIBLE);
        btn9.setVisibility(View.VISIBLE);
        btnRestart.setVisibility(View.VISIBLE);
        btnLeader.setVisibility(View.VISIBLE);
        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        mat[i][j][k][l].setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }


    public String showBoardEasy()
    {
        String str = "";
        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        str += easyBoards[rNum][i][j][k][l] + " ";
                    }
                    str += "\n";
                }
                str += "\n";
            }
            str += "\n";
        }
            return str;
    }

    public String showBoardMedium()
    {
        String str = "";
        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        str += mediumBoards[rNum][i][j][k][l] + " ";
                    }
                    str += "\n";
                }
                str += "\n";
            }
            str += "\n";
        }
        return str;
    }

    public String showBoardHard()
    {
        String str = "";
        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        str += hardBoards[rNum][i][j][k][l] + " ";
                    }
                    str += "\n";
                }
                str += "\n";
            }
            str += "\n";
        }
        return str;
    }
    public boolean  boardValid(int levelNum)
    {
        Log.d("=========",  "got into boardValid");
        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        if(levelNum==1)
                        {
                            if (easyBoards[rNum][i][j][k][l]==0)
                            {
                                Log.d("=========",  "sent from boardValid to easyBoards[rNum][i][j][k][l]");
                                return false;
                            }
                        }
                        if(levelNum==2)
                        {
                            if (mediumBoards[rNum][i][j][k][l]==0)
                            {
                                return false;
                            }
                        }
                        if(levelNum==3)
                        {
                            if (hardBoards[rNum][i][j][k][l]==0)
                            {
                                return false;
                            }
                        }
                    }

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
                        if(!isValid(i, j, k, l, levelNum))
                        {
                            Log.d("=========",  "sent from boardValid to isValid and false");
                            return false;
                        }
                    }
                }
            }
        }
        Log.d("=========",  "boardValid us returning true");
        return true;
    }
    public boolean isFinished(int lives,int levelNum) //todo: NEED TO ADD OPTION OF WHEN FINISHED BUT WRONG.
    {
        if(lives==0)
        {
            return true;
        }
        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        if(levelNum==1)
                        {
                            if (easyBoards[rNum][i][j][k][l]==0)
                            {
                                return false;
                            }
                        }
                        if(levelNum==2)
                        {
                            if (mediumBoards[rNum][i][j][k][l]==0)
                            {
                                return false;
                            }
                        }
                        if(levelNum==3)
                        {
                            if (hardBoards[rNum][i][j][k][l]==0)
                            {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isValid(int i,int j, int k, int l, int levelNum)
    {
        Log.d("=========",  "got to isValid");
        for(int t=0; t<3; t++) //CHECKING IF IN MAT.
        {
            for(int q=0; q<3; q++)
            {
                if(t!=k||q!=l)
                {
                    if(levelNum==1)
                    {
                        if (easyBoards[rNum][i][j][t][q] != 0)
                        {
                            if (easyBoards[rNum][i][j][k][l] == easyBoards[rNum][i][j][t][q])
                            {
                                return false;
                            }
                        }
                    }
                    if(levelNum==2)
                    {
                        if (mediumBoards[rNum][i][j][t][q] != 0)
                        {
                            if (mediumBoards[rNum][i][j][k][l] == mediumBoards[rNum][i][j][t][q])
                            {
                                return false;
                            }
                        }
                    }
                    if(levelNum==3)
                    {
                        if (hardBoards[rNum][i][j][t][q] != 0)
                        {
                            if (hardBoards[rNum][i][j][k][l] == hardBoards[rNum][i][j][t][q])
                            {
                                return false;
                            }
                        }
                    }
                }

            }
        }
        for(int t=0; t<3; t++) //CHECKING FOR ROW.
        {
            for(int q=0; q<3; q++)
            {
                if(t!=j||q!=l)
                {
                    if(levelNum==1)
                    {
                        if (easyBoards[rNum][i][t][k][q] != 0)
                        {
                            if (easyBoards[rNum][i][t][k][q] == easyBoards[rNum][i][j][k][l])
                            {
                                return false;
                            }
                        }
                    }
                    if(levelNum==2)
                    {
                        if (mediumBoards[rNum][i][t][k][q] != 0)
                        {
                            if (mediumBoards[rNum][i][t][k][q] == mediumBoards[rNum][i][j][k][l])
                            {
                                return false;
                            }
                        }
                    }
                    if(levelNum==3)
                    {
                        if (hardBoards[rNum][i][t][k][q] != 0)
                        {
                            if (hardBoards[rNum][i][t][k][q] == hardBoards[rNum][i][j][k][l])
                            {
                                return false;
                            }
                        }
                    }
                }

            }
        }
        for(int t=0; t<3; t++) //CHECKING FOR LINE.
        {
            for(int q=0; q<3; q++)
            {
                if(t!=i||q!=k)
                {
                    if(levelNum==1)
                    {
                        if (easyBoards[rNum][t][j][q][l] != 0)
                        {
                            if (easyBoards[rNum][t][j][q][l] == easyBoards[rNum][i][j][k][l])
                            {
                                return false;
                            }
                        }
                    }
                    if(levelNum==2)
                    {
                        if (mediumBoards[rNum][t][j][q][l] != 0)
                        {
                            if (mediumBoards[rNum][t][j][q][l] == mediumBoards[rNum][i][j][k][l])
                            {
                                return false;
                            }
                        }
                    }
                    if(levelNum==3)
                    {
                        if (hardBoards[rNum][t][j][q][l] != 0)
                        {
                            if (hardBoards[rNum][t][j][q][l] == hardBoards[rNum][i][j][k][l])
                            {
                                return false;
                            }
                        }
                    }
                }

            }
        }
        return true;
    }


    public int numText(Button btn)
    {
        String str;
        int num;
        str= btn.getText().toString();
        num=Integer.parseInt(str);
        return num;
    }

    public void BackgroundClick(Button btn)
    {
        btn.setBackgroundColor(0xff880011);
    }
    public void backgroundFix(Button btn1,Button btn2, Button btn3,Button btn4,
                              Button btn5,Button btn6, Button btn7,Button btn8)
    {
     btn1.setBackgroundResource(R.drawable.back);
     btn2.setBackgroundResource(R.drawable.back);
     btn3.setBackgroundResource(R.drawable.back);
     btn4.setBackgroundResource(R.drawable.back);
     btn5.setBackgroundResource(R.drawable.back);
     btn6.setBackgroundResource(R.drawable.back);
     btn7.setBackgroundResource(R.drawable.back);
     btn8.setBackgroundResource(R.drawable.back);
    }


    public void solveBoard(android.widget.Button[][][][]mat,int levelNum)
    {
        if(levelNum==1)
        {
            if(rNum==0)
            {
                mat[0][0][0][0].setText("6");
                mat[0][0][0][2].setText("1");
                mat[0][0][1][0].setText("5");
                mat[0][0][1][1].setText("7");
                mat[0][0][1][2].setText("9");
                mat[0][0][2][1].setText("8");
                mat[0][0][2][2].setText("4");
                mat[0][1][0][1].setText("3");
                mat[0][1][1][2].setText("8");
                mat[0][1][2][0].setText("2");
                mat[0][1][2][1].setText("5");
                mat[0][1][2][2].setText("1");
                mat[0][2][0][0].setText("4");
                mat[0][2][0][2].setText("5");
                mat[0][2][1][2].setText("3");
                mat[0][2][2][1].setText("7");
                mat[0][2][2][2].setText("9");
                mat[1][0][0][0].setText("2");
                mat[1][0][1][1].setText("9");
                mat[1][0][2][0].setText("4");
                mat[1][0][2][1].setText("1");
                mat[1][0][2][2].setText("5");
                mat[1][1][0][0].setText("3");
                mat[1][1][0][1].setText("9");
                mat[1][1][0][2].setText("5");
                mat[1][1][1][1].setText("4");
                mat[1][1][2][0].setText("8");
                mat[1][1][2][2].setText("2");
                mat[1][2][0][1].setText("4");
                mat[1][2][0][2].setText("1");
                mat[1][2][1][0].setText("7");
                mat[1][2][1][1].setText("5");
                mat[1][2][1][2].setText("2");
                mat[1][2][2][0].setText("3");
                mat[1][2][2][2].setText("6");
                mat[2][0][0][0].setText("7");
                mat[2][0][1][1].setText("5");
                mat[2][0][1][2].setText("8");
                mat[2][1][1][0].setText("7");
                mat[2][1][1][1].setText("2");
                mat[2][1][1][2].setText("3");
                mat[2][1][2][2].setText("4");
                mat[2][2][0][1].setText("3");
                mat[2][2][1][1].setText("6");
                mat[2][2][2][1].setText("1");

                for (int i=0; i<3; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        for (int k = 0; k < 3; k++)
                        {
                            for (int l = 0; l < 3; l++)
                            {
                                if(easyBoards[0][i][j][k][l]==0)
                                {
                                    mat[i][j][k][l].setTextColor(0xff00ff00);
                                }
                                else
                                {
                                    if(isValid(i,j,k,l,levelNum))
                                    {
                                        if(!mat[i][j][k][l].getText().toString().equals(Integer.toString(easyBoards[0][i][j][k][l])))
                                        {
                                            mat[i][j][k][l].setTextColor(0xffffff00);

                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }
    public void reBoard(android.widget.Button[][][][]mat,int levelNum)
    {
        for (int i=0; i<3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 3; l++)
                    {
                        if (levelNum == 1)
                        {
                            if (rNum == 0)
                            {
                                if(easyBoards[0][i][j][k][l]==0)
                                {
                                    mat[i][j][k][l].setText("");
                                }
                                else
                                {
                                    if(isValid(i,j,k,l,levelNum))
                                    {
                                        if(!mat[i][j][k][l].getText().toString().equals(Integer.toString(easyBoards[0][i][j][k][l])))
                                        {
                                            mat[i][j][k][l].setTextColor(0xff018786);
                                            Log.d("```````","Got to set colour back");

                                        }
                                    }
                                    mat[i][j][k][l].setText(easyBoards[rNum][i][j][k][l] + "");


                                }
                            }
                        }
                    }
                }
            }
        }
    }

}





