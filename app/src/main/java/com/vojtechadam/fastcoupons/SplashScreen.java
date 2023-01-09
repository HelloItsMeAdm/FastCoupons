package com.vojtechadam.fastcoupons;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class SplashScreen extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("Settings", 0);
        SharedPreferences.Editor editor = pref.edit();
        int language = pref.getInt("Language", -1);
        if (language == -1) {
            editor.putInt("Language", 0);
            editor.apply();
        }

        VideoView videoView = findViewById(R.id.video);
        TextView text1 = findViewById(R.id.title);
        TextView text2 = findViewById(R.id.version);
        TextView text3 = findViewById(R.id.from);
        TextView text4 = findViewById(R.id.name);

        text1.setAlpha(0f);
        text2.setAlpha(0f);
        text3.setAlpha(0f);
        text4.setAlpha(0f);

        new Handler().postDelayed(() -> {
            text1.animate().alpha(100f).setDuration(10000);
            text2.animate().alpha(100f).setDuration(10000);
            text3.animate().alpha(100f).setDuration(10000);
            text4.animate().alpha(100f).setDuration(10000);
        }, 4650);

        //Specify the location of media file
        String path = "android.resource://com.vojtechadam.fastcoupons/" + R.raw.splashanim;
        Uri uri = Uri.parse(path);

        //Setting MediaController and URI, then starting the videoView
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashScreen.this, MainActivity.class));
            finish();
        }, 8500);

        final int[] i = {0};
        Button skip = findViewById(R.id.skip);
        skip.setOnClickListener(v -> {
            i[0]++;
            Handler handler = new Handler();
            Runnable r = () -> i[0] = 0;

            if (i[0] == 1) {
                //Single click
                handler.postDelayed(r, 250);
            } else if (i[0] == 2) {
                //Double click
                i[0] = 0;
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        });
    }
}