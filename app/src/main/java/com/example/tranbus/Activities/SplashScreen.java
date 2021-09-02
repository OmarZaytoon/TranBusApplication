package com.example.tranbus.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tranbus.R;
import com.example.tranbus.Util.Statics;

import java.util.Locale;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here

        }
        if(Locale.getDefault().getLanguage().compareTo("ar")==0){
            Statics.language=false;
        }else Statics.language=true;

        mProgress = (ProgressBar) findViewById(R.id.simpleProgressBar);

        new Thread(new Runnable() {
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();

    }
    private void doWork() {

        for (int progress=0; progress<100; progress+=40) {
            try {
                Thread.sleep(1000);
                mProgress.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
    }
}