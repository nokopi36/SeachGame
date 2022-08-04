package com.nokopi.seachgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SampleView1 extends View{
    private Paint paint;
    private int red,green,blue;
    private double X,Y;

    public SampleView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public void changeColor(float _X,float _Y){
        X=(double) _X;
        Y=(double) _Y;
        if (((X>=3.5&&X<=4.5)&&(Y>=5.5&&Y<=6.5))||((X>=2&&X<=3)&&(Y>=4&&Y<=5))){
            red=255;
            green=255;
            blue=0;
        }else if ((X>3&&X<3.5)&&(Y>5&&Y<5.5)){
            red=255;
            green=0;
            blue=0;
        }else {
            red=255;
            green=255;
            blue=255;
        }
        this.invalidate();
    }

    public int result(float _X,float _Y){
        X=(double) _X;
        Y=(double) _Y;
        if ((X>3&&X<3.5)&&(Y>5&&Y<5.5)){
            return 1;
        }
        return 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.rgb(red,green,blue));
    }
}
