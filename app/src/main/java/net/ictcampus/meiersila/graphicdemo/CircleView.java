package net.ictcampus.meiersila.graphicdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;

import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by meiersila on 18.05.2017.
 */

public class CircleView extends View implements Runnable{

    private ShapeDrawable rectangle, moveableRect;
    private Paint paint;
    private float currX, currY, touchX, touchY;
    private int width, height;
    private Rect blue;
    private Rect blue1;
    private Rect blue2;
    private Rect blue3;
    private Rect point;
    private int[] colors = new int[]{Color.BLACK, Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW};
    private int random1, random2, random3,random4;


    public CircleView(Context context) {
        super(context);

        currX = 800;
        currY = 530;
        touchX = 50;
        touchY = 50;

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x/2;
        height = size.y/2-50;

        blue = new Rect((int)currX,(int)currY, width, height);
        blue1 = new Rect(width,(height*2-(int)currY), (width*2 - (int)currX),height);
        blue2 = new Rect(width,height*2-(int)currY, (int)currX,height);
        blue3 = new Rect(width, height,width,(int)currY);
        point = new Rect(50,50,50,50);

        paint = new Paint();
        rectangle = new ShapeDrawable(new RectShape());
        moveableRect = new ShapeDrawable(new RectShape());
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                touchY =  event.getY();
                touchX = event.getX();
                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }

        return true;
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        point= new Rect((int)touchX, (int)touchY,50,50);
        rectangle.setBounds(point);
        point = rectangle.getBounds();
        rectangle.draw(canvas);

        rectangle.getPaint().setColor(colors[random1]);
        rectangle.getPaint().setStyle(Paint.Style.STROKE);
        rectangle.getPaint().setStrokeWidth(10);
        blue = new Rect((int)currX, (int)currY, width, height);
        rectangle.setBounds(blue);
        blue = rectangle.getBounds();
        rectangle.draw(canvas);

        rectangle.getPaint().setColor(colors[random2]);
        blue1.set(width,(int)currY, (width*2 -(int)currX),height);
        rectangle.setBounds(blue1);
        blue1 = rectangle.getBounds();
        rectangle.draw(canvas);

        rectangle.getPaint().setColor(colors[random3]);
        blue2.set(width, height,width,(int)currY);
        rectangle.setBounds(blue2);
        blue2 = rectangle.getBounds();
        rectangle.draw(canvas);

        rectangle.getPaint().setColor(colors[random4]);
        blue3.set((int)currX, height,width,(int)currY);
        rectangle.setBounds(blue3);
        blue3 = rectangle.getBounds();
        rectangle.draw(canvas);
    }

    @Override
    public void run(){
        int speed = 12;
        while(true){
            if(currX <10){
                currX = width;
                currY = height;
                speed = 12;
                random1 = (int)(Math.random() * colors.length);
                random2 = (int)(Math.random() * colors.length);
                random3 = (int)(Math.random() * colors.length);
                random4 = (int)(Math.random() * colors.length);
            }
            if(currX < 640){
                speed = 24;
            }else if(currX < 320){
                speed = 32;
            }

            currX = currX - speed;
            currY = currY - (speed - speed/3);

            postInvalidate();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}