package com.barhum.incomb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private ImageView loginBtn;
    private EditText userNameET;
    private EditText passwordET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        loginBtn.setOnClickListener(view -> {
            String userName = userNameET.getText().toString();
            String password = passwordET.getText().toString();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }

    private void init(){
        loginBtn = findViewById(R.id.image_view_login_btn);
        userNameET = findViewById(R.id.edit_text_user_name);
        passwordET = findViewById(R.id.edit_text_password);
    }
}