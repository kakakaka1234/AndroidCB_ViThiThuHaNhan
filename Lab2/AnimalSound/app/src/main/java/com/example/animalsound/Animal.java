package com.example.animalsound;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class Animal extends AppCompatActivity {

    int[] images = {
            R.drawable.bee,
            R.drawable.cat,
            R.drawable.dog,
            R.drawable.crab,
            R.drawable.jellyfish,
            R.drawable.koala,
            R.drawable.monkey,
            R.drawable.mouse,
            R.drawable.turtle
    };

    int[] backgrounds = {
            R.color.black,
            R.color.purple_200,
            R.color.purple_500,
            R.color.purple_700,
            R.color.teal_200,
            R.color.teal_700,
            R.color.white
    };

    ImageView imageView;
    ConstraintLayout constraintLayout;

    private void getViews() {
        imageView = findViewById(R.id.imageView);
        constraintLayout = findViewById(R.id.constraint);

        Random random = new Random();
        int randomImage = images[random.nextInt(images.length)];
        int randomBackground = backgrounds[random.nextInt(backgrounds.length)];

        imageView.setImageResource(randomImage);
        constraintLayout.setBackgroundResource(randomBackground);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        getViews();
    }
}
