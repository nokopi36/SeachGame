package com.nokopi.seachgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Locate extends View{
    private Paint paint;
    private float X,Y;

    public Locate(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public void Circle(float _X,float _Y){
        X=_X;
        Y=_Y;
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width,height;
        width=canvas.getWidth();
        height=canvas.getHeight();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(0,0,0));
        canvas.drawCircle(-20*Y+width/2,-20*X+height/2,10,paint);
        paint.setColor(Color.rgb(0,0,0));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(-200+width/2,-200+height/2,200+width/2,200+height/2,paint);
    }
}
