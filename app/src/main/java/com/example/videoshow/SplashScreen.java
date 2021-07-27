package com.example.videoshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SplashScreen extends AppCompatActivity {

    AppCompatImageView bgapp;
    Animation bganime,clovernim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        bgapp=findViewById(R.id.bgapp);

        bganime= AnimationUtils.loadAnimation(this,R.anim.bganim);

        bgapp.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
    }
}