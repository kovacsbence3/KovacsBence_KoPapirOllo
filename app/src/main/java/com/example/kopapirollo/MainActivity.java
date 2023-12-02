package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button rockButton;
    private Button paperButton;
    private Button scissorsButton;
    private TextView textResult;
    private int machineWins;
    private int playerWins;
    private int playerChoiseInt;
    private ImageView playerChoise;
    private ImageView machineChoise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        rockButton.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                playerChoise.setImageDrawable(getResources().getDrawable(R.drawable.rock));
                playerChoiseInt = 1;
                Game(playerChoiseInt);
            }});
        paperButton.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                playerChoise.setImageDrawable(getResources().getDrawable(R.drawable.paper));
                playerChoiseInt = 2;
                Game(playerChoiseInt);
            }});
        scissorsButton.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                playerChoise.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                playerChoiseInt = 3;
                Game(playerChoiseInt);
            }});

        };
    public void init(){
        rockButton =findViewById(R.id.rockButton);
        paperButton =findViewById(R.id.paperButton);
        scissorsButton =findViewById(R.id.scissorsButton);
        playerChoise = findViewById(R.id.playerOption);
        machineChoise = findViewById(R.id.machineOptionImage);
        machineWins = 0;
        playerWins = 0;
        textResult.setText("Eredmény: Te: " + playerWins + " Gép: " + machineWins);
    }
    public void Game(int playerChoiseInt){
        Random random = new Random();
        int machineChoiseInt = random.nextInt(1 - 3);
        if (machineChoiseInt == 1){
            machineChoise.setImageDrawable(getResources().getDrawable(R.drawable.rock));
        } else if (machineChoiseInt == 1){
            machineChoise.setImageDrawable(getResources().getDrawable(R.drawable.paper));
        } else if (machineChoiseInt == 3){
            machineChoise.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
        }
        if      ((playerChoiseInt == 1 && machineChoiseInt == 3) ||
                (playerChoiseInt == 2 && machineChoiseInt == 1) ||
                (playerChoiseInt == 3 && machineChoiseInt == 2)) {
                playerWins++;
            Toast.makeText(this, "Nyertél", Toast.LENGTH_SHORT).show();
        } else if   ((playerChoiseInt == 1 && machineChoiseInt == 2) ||
                    (playerChoiseInt == 2 && machineChoiseInt == 3) ||
                    (playerChoiseInt == 3 && machineChoiseInt == 1)) {
            Toast.makeText(this, "Sajnos vesztettél", Toast.LENGTH_SHORT).show();
                machineWins++;
        }

    }
    };


