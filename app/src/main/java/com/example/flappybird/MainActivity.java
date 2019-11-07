package com.example.flappybird;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private GameView gameView;
    private Handler handler = new Handler();
    private final  static long TIMER_INTERVAL = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){

           gameView = new GameView(this);
            setContentView(gameView);

            Timer timer = new Timer();
           timer.schedule(new TimerTask() {
               @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() { gameView.invalidate();

                        }
                    });
                }
            },0,TIMER_INTERVAL);

        }
        return true;
   }
}
