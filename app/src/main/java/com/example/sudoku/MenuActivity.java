package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSudoku, btnSettings, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnSudoku = (Button) findViewById(R.id.btnSudoku);
        btnSudoku.setOnClickListener(this);

        btnSettings = (Button) findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(this);

        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        if (view.getId()==btnSudoku.getId()){
            intent= new Intent(this, AddUsers.class);
            startActivity(intent);
        } else if (view.getId()==btnSettings.getId()) {
            intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        else if (view.getId()==btnExit.getId()) {
            finish();
        }

    }
}