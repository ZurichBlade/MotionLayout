package com.example.motionlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {


    MotionLayout motionLayout5, motionLayout3, motionLayout1, motionLayout2;
    ImageView menu, home, bookmark, contacts, setting;
    TextView tvHome, tvBookmark, tvContacts, tvSetting;
    Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //to hide the Action bar.
        Objects.requireNonNull(getSupportActionBar()).hide();

        motionLayout3 = findViewById(R.id.constraintLayout3);
        motionLayout5 = findViewById(R.id.constraintLayout5);
        motionLayout1 = findViewById(R.id.constraintLayout1);
        motionLayout2 = findViewById(R.id.constraintLayout2);
        menu = findViewById(R.id.ivIconMenu);
        home = findViewById(R.id.imageViewIconHome);
        tvHome = findViewById(R.id.textViewHome);
        bookmark = findViewById(R.id.imageViewIconBooking);
        tvBookmark = findViewById(R.id.textViewBooking);
        contacts = findViewById(R.id.ivIconContactus);
        tvContacts = findViewById(R.id.tvContactus);
        setting = findViewById(R.id.ivIconSettings);
        tvSetting = findViewById(R.id.tvSettings);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim_shake);


        shakeMenuIcon();

        BeginTransition();


        home.setOnClickListener(this);
        tvHome.setOnClickListener(this);
        bookmark.setOnClickListener(this);
        tvBookmark.setOnClickListener(this);
        contacts.setOnClickListener(this);
        tvContacts.setOnClickListener(this);
        setting.setOnClickListener(this);
        tvSetting.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.imageViewIconHome || id == R.id.textViewHome) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        } else if (id == R.id.imageViewIconBooking || id == R.id.textViewBooking) {
            Intent i = new Intent(getApplicationContext(), MainActivity4.class);
            startActivity(i);
        } else if (id == R.id.ivIconContactus || id == R.id.tvContactus) {
            Intent i = new Intent(getApplicationContext(), MainActivity3.class);
            startActivity(i);
        } else if (id == R.id.ivIconSettings || id == R.id.tvSettings) {
            Toast.makeText(this, "Coming Soon...", Toast.LENGTH_SHORT).show();
        }

    }


    private void BeginTransition() {

        // to begin the transition on button click.
        menu.setOnClickListener(v -> {
            if (motionLayout1.getProgress() < 0.75) {
                motionLayout3.transitionToEnd();
                motionLayout5.transitionToEnd();
                motionLayout1.transitionToEnd();
                motionLayout2.transitionToEnd();
            } else {
                motionLayout1.transitionToStart();
                motionLayout3.transitionToStart();
                motionLayout5.transitionToStart();
                motionLayout2.transitionToStart();
            }

        });
    }

    private void shakeMenuIcon() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(() -> menu.startAnimation(animation));
            }
        }, 0, 5000);
    }


}