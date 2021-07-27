package com.example.videoshow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.example.videoshow.MainActivity;
import com.example.videoshow.R;

public class MainSplash extends AppCompatActivity {

    AppCompatTextView textView;
    AppCompatImageView splashImg;
    LottieAnimationView lottieAnimationView;
    private final int SPLASH_DISPLAY_LENGTH =4600;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash);


        textView=findViewById(R.id.appCompatTextView2);
        splashImg=findViewById(R.id.appCompatImageView2);
        lottieAnimationView=findViewById(R.id.lottie);

        splashImg.animate().translationY(-2600).setDuration(1000).setStartDelay(4000);
        textView .animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1600).setDuration(1000).setStartDelay(4000);



        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(MainSplash.this, MainActivity.class);
                MainSplash.this.startActivity(mainIntent);
                MainSplash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}