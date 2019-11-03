package com.example.flappybird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//
//
//        TextView scoreLabel = (TextView) findViewById(R.id.scoreLabel);
//        TextView highScoreLabel = (TextView) findViewById(R.id.highScoreLabel);
//        Button tryAgainButton = (Button) findViewById(R.id.buttonTryAgain);
//
//        int score = getIntent().getIntExtra("SCORE", GameView.getScore());
//        scoreLabel.setText(score + "");
//
//        SharedPreferences settings= getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
//        int highScore = settings.getInt("HIGH_SCORE", 0);
//
//        if(score > highScore) {
//            highScoreLabel.setText("High Score: "  + score);
//
//            SharedPreferences.Editor editor  = settings.edit();
//            editor.putInt("HIGH_SCORE", score);
//            editor.apply();
//
//        }
//        else{
//            highScoreLabel.setText("High Score: "  + highScore);
//        }
//
//
//
//
//        tryAgainButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), GameView.class);
//                startActivity(intent);
//            }
//
//        });
//    }
//}
