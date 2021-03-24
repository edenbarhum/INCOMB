package com.barhum.incomb;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class GustOnBoarding extends AppCompatActivity {

    private FloatingActionButton createGuestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gust_on_boarding);


        init();

        createGuestBtn.setOnClickListener(view -> {


        });

    }


    private void init(){

        createGuestBtn = findViewById(R.id.floating_action_button);


    }



}