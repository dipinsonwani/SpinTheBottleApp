package com.example.spinthebottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bottle;
    private int lastDir;
    private Random random= new Random();
    private boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle= findViewById(R.id.bottle);
    }

    public void spinBottle(View v){
        if(!spinning) {
            int newDir = random.nextInt(1800);
            float pivotX = bottle.getWidth() / 2;
            float pivotY = bottle.getHeight() / 2;
            RotateAnimation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            rotate.setFillAfter(true);
            rotate.setDuration(2500);
            lastDir = newDir;
            bottle.startAnimation(rotate);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning=true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning=false;

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }

    }
}
