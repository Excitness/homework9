package com.askat.cw9_m3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScrinActivity extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScrinActivity.this, MainActivity.class);
                SplashScrinActivity.this.startActivity(mainIntent);
                SplashScrinActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}

