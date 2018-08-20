package com.moregood.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.moregood.animation.action.Action;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
//        Action.runMove(imageView,5000,new Point(200,200));
//        Action.runAlpha(imageView,5000,1);
//        Action.runRotate(imageView,5000,360);
        Action.runScale(imageView,1200,0.8f,1);
    }
}
