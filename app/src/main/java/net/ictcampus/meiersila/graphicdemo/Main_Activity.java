package net.ictcampus.meiersila.graphicdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;

public class Main_Activity extends Activity {
    CircleView ourView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        draw();
        setContentView(ourView);
    }

    public void draw() {
        ourView = new CircleView(this);
        ourView.setBackgroundColor(Color.GRAY);
    }
}

