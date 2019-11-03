package com.example.flappybird;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    private int canvasWidth;
    private int canvasHeight;
    private static int score;

    private Bitmap bird[]=new Bitmap[2];
    private int birdX;
    private int birdY;
    private int birdHigh;

    private int coinX;
    private int coinY;
    private int coinSpeed;
    private int level;

    //deadBall

    private int deadBallX;
    private int deadBallY;
    private int deadBallSpeed;
    private Paint deadBallPaint = new Paint();

    private Bitmap background;
    private Bitmap coin ;

    private Paint scorePaint = new Paint();
    private Paint levelPaint = new Paint();


    private Bitmap life [] = new Bitmap[2];
    private int lifeCount;

    private boolean onTouchFlag = false;
    private int incrementation;

    public GameView(Context context) {
        super(context);


        bird[0] = BitmapFactory.decodeResource(getResources(), R.drawable.bird1);
        bird[1] = BitmapFactory.decodeResource(getResources(), R.drawable.bird2);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        coin = BitmapFactory.decodeResource(getResources(), R.drawable.coin);

        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(48);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        deadBallPaint.setColor(Color.BLACK);
        deadBallPaint.setAntiAlias(false);


        levelPaint.setColor(Color.DKGRAY);
        levelPaint.setTextSize(48);
        levelPaint.setTypeface(Typeface.DEFAULT_BOLD);
        levelPaint.setTextAlign(Paint.Align.CENTER);
        levelPaint.setAntiAlias(true);

        life[0] = BitmapFactory.decodeResource(getResources(), R.drawable.life);
        life[1] = BitmapFactory.decodeResource(getResources(), R.drawable.empty_life);

       //when bird spawns set defaults

        birdX=10;
        birdY=500;
        score = 0;
        incrementation = score;
        birdHigh=10;
        coinSpeed = 15;
        deadBallSpeed=25;
        lifeCount =3;
        level = 1;

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawBitmap(background, 0, 0, null);

        //bird max height and min height
        int maxBirdY = bird[0].getHeight();
        int minBirdY = canvasHeight - bird[0].getHeight() * 5;

        birdY += birdHigh;

        if (birdY < maxBirdY) birdY = maxBirdY;
        if (birdY > minBirdY) birdY = minBirdY;
        birdHigh += 2; // goes down faster than goes up

        if (onTouchFlag) {
            //flap  bird's wings
            canvas.drawBitmap(bird[1], birdX, birdY, null);
            onTouchFlag = false;
        } else {
            canvas.drawBitmap(bird[0], birdX, birdY, null);
        }

        //::____________________point to collect____________________::
        coinX -= coinSpeed; // make coin fly left

//
//        if (hitCheck(coinX, coinY)) {
//            score++; incrementation++;
//            coinX = -100; // it 'disappears'
//
//        }
//        if (coinX < 0) {
//            coinX = canvasWidth + 20;
//            coinY = (int) Math.floor(Math.random() * (maxBirdY - minBirdY)) + minBirdY;
//        }
//
//        //::______________________level up___________________________::
//        if (incrementation % 5 == 0 && incrementation != 0) {
//
//            ++level;
//            coinSpeed += 2;
//            deadBallSpeed += 5;
//            incrementation= 0;
//        }
//
//            canvas.drawBitmap(coin,coinX, coinY, null);
//
//            //DeadBall draw
//            deadBallX-=deadBallSpeed;
//
//            if(hitCheck(deadBallX, deadBallY)){
//
//                deadBallX= -100; // it 'disappears' -life
//                lifeCount--;
//
//                if (lifeCount==0){
//                   //GAME OVER
//                 tryAgain();
//
//                }
//             }
//             if(deadBallX<0){
//                 deadBallX=canvasWidth +200;
//                 deadBallY = (int) Math.floor(Math.random()*(maxBirdY-minBirdY)) + minBirdY;
//             }
//
//            canvas.drawCircle(deadBallX,deadBallY,40, deadBallPaint);
//
//             //Score
//            canvas.drawText("Score : " + score , 20, 60, scorePaint);
//
//            //Level
//            canvas.drawText("Lv. " + level , canvasWidth / 2, 60, levelPaint);
//
//            //Life
//            for(int i=0;i<3;i++){
//                int x=(int) (800 + life[0].getWidth() * 1.5 * i);
//                        int y =20;
//
//                canvas.drawBitmap( (i < lifeCount )?  life[0]: life[1] ,
//                        x, y, null);
//            }
//
//        }
//
//        public boolean hitCheck(int x, int y){
//            return (birdX<x && x <(birdX + bird[0].getWidth() )&& ( birdY<y && y < (birdY + bird[0].getHeight())));
//        }
//
//    public static int getScore(){
//        return score;
//    }
//
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event){
//        if(event.getAction() == MotionEvent.ACTION_DOWN){
//            onTouchFlag =true;
//            birdHigh= -20; //bird goes up
//        }
//        return true;
//    }
//    public void tryAgain(){
//
//        Intent intent = new Intent(getContext(),ResultActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        getContext().startActivity(intent);
//    }
//

//}

