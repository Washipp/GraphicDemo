package net.ictcampus.meiersila.graphicdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Main_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main_);

        Button buttonStart = (Button)findViewById(R.id.buttonStart);
        MyTouchListener myTouchListener = new MyTouchListener();
        buttonStart.setOnTouchListener(myTouchListener);
    }

    private class MyTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch(event.getAction()) {
                case MotionEvent.ACTION_UP:
                    Intent intent = new Intent(getApplicationContext(), Game_Activity.class);
                    startActivity(intent);
                    return true;
            }
            return true;
        }

    }
}

