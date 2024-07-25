package com.example.motionlayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    ClickListener listener;
    ImageView imgBack;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to hide the Action bar.
        Objects.requireNonNull(getSupportActionBar()).hide();

        ArrayList<ModelClass> list;
        list = getData();
        recyclerView = findViewById(R.id.rv);
        imgBack = findViewById(R.id.imgBack);


        listener = new ClickListener() {
            public void click(int index) {
                Toast.makeText(MainActivity.this, "clicked item index is " + index, Toast.LENGTH_LONG).show();
            }
        };
        adapter = new MyAdapter(this, list, listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        imgBack.setOnClickListener(v -> onBackPressed());


    }

    // Adding data to Arraylist
    private ArrayList<ModelClass> getData() {
        ArrayList<ModelClass> list = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                list.add(new ModelClass(R.drawable.car, this.getString(R.string.demoText)));
            } else {
                list.add(new ModelClass(R.drawable.img4, this.getString(R.string.demoText)));
            }
        }

        return list;
    }


}