package com.example.fluffybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GameView extends View {
    private Bird bird;
    private android.os.Handler handler;
    private Runnable r;
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bird = new Bird();
        bird.setWidth(100*Constants.SCREEN_WIDTH/1080);
        bird.setHeight(100*Constants.SCREEN_HEIGHT/1920);
        bird.setX(100*Constants.SCREEN_WIDTH/1080);
        bird.setY(Constants.SCREEN_HEIGHT/2-bird.getHeight()/2);
        ArrayList<Bitmap> arrBms = new ArrayList<>();
        arrBms.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.bird1));
        arrBms.add(BitmapFactory.decodeResource(this.getResources(),R.drawable.bird2));
        bird.setArrBms(arrBms);
        handler = new Handler();
        r = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };

    }
    public void draw(Canvas canvas){
        super.draw(canvas);
        bird.draw(canvas);
        handler.postDelayed(r, 10);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            bird.setDrop(-15);
        }
        return true;
    }
}
