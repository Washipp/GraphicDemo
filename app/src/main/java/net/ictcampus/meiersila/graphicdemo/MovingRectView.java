package net.ictcampus.meiersila.graphicdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by meiersila on 18.05.2017.
 */

public class MovingRectView extends View implements Runnable{

    private ShapeDrawable rectangle;
    private Paint paint;
    private float touchX, touchY;
    private Rect point;

    public MovingRectView(Context context) {
        super(context );
        touchX = 50;
        touchY = 50;

        point = new Rect(50,50,50,50);

        paint = new Paint();
        rectangle = new ShapeDrawable(new RectShape());
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
        rectangle.getPaint().setStyle(Paint.Style.STROKE);
        rectangle.getPaint().setStrokeWidth(10);

        point.set((int)touchX, (int)touchY,50,50);
        rectangle.setBounds(point);
        point = rectangle.getBounds();
        rectangle.draw(canvas);
    }

    @Override
    public void run(){
        while(true){

            postInvalidate();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}