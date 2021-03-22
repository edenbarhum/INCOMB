package com.barhum.customview;

import android.os.Bundle;

import com.barhum.customview.view.CustomView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCustomView = findViewById(R.id.custom_view);

        findViewById(R.id.btn_swap_color).setOnClickListener(view -> {
            mCustomView.swapColor();
        });



    }
}