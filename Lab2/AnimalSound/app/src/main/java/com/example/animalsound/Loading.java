package com.example.animalsound;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Loading extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textViewPercentage;
    int progressStatus = 0;
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_loading);

        progressBar = findViewById(R.id.progressbar);
        textViewPercentage = findViewById(R.id.textview);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            textViewPercentage.setText(progressStatus + "%");
                        }
                    });
                    try {
                        Thread.sleep(35);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (progressStatus >= 100) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(Loading.this, Animal.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        }).start();
    }
}
