package com.example.motionlayout;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //to hide the Action bar.
        Objects.requireNonNull(getSupportActionBar()).hide();

        ImageView imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(v -> onBackPressed());
    }
}