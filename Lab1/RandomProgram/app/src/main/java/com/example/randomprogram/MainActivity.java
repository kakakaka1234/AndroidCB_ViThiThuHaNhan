package com.example.randomprogram;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.View;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] diceImage = new int[]{R.drawable.pic_1, R.drawable.pic_2, R.drawable.pic_3, R.drawable.pic_4, R.drawable.pic_5, R.drawable.pic_6};
    Button rollButton;
    ImageView di;
    int delayTime = 50;
    int rollAnimation = 20;
    Random random = new Random();
    LinearLayout diceContainer;
    Handler handler = new Handler(Looper.getMainLooper());

    private void rollDice() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < rollAnimation; i++) {
                    final int diceNumber = random.nextInt(6);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            di.setImageResource(diceImage[diceNumber]);
                        }
                    });
                    try {
                        Thread.sleep(delayTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int finalDiceNumber = random.nextInt(6);
                        di.setImageResource(diceImage[finalDiceNumber]);
                    }
                });
            }
        };
        new Thread(runnable).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollButton = findViewById(R.id.roll_button);
        di = findViewById(R.id.di);
        diceContainer = findViewById(R.id.diceContainer);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    rollDice();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.diceContainer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
