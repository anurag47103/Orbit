package com.learningandroid.protradin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    private TextView heading;
    private LottieAnimationView anim;
    private Handler handler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_screen);

        heading = findViewById(R.id.heading);
        heading.setAlpha(0);
        anim = findViewById(R.id.splashAnimation);
        handler = new Handler();

        heading.animate()
                .scaleX(2)
                .scaleY(2)
                .alpha(1)
                .setDuration(1000);

        anim.animate()
                .alpha(0)
                .setDuration(500)
                .setStartDelay(4000);

        handler.postDelayed(() -> {
            heading.animate().alpha(0).setDuration(500);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }, 1000);



    }
}