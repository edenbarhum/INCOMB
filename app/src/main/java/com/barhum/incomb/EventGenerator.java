package com.barhum.incomb;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EventGenerator extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    private Activity mActivity;

    private TextView calculatePriceTv;
    private TextView recommendedPriceTv;

    private Button originalPriceBtn;
    private Button recommendedPriceBtn;
    private Button newPriceBtn;

    private LinearLayout newPriceLl;

    private EditText newPriceGuest;
    private EditText newPriceHour;
    private Button calculateAgainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_generator);

        Intent intent = getIntent();
        double price = intent.getDoubleExtra("calculatePrice", 0);
        int pricePerGuest = intent.getIntExtra("pricePerGuest", 0);
        int pricePerHour = intent.getIntExtra("pricePerHour", 0);
        int numberOfParticipants = intent.getIntExtra("numberOfParticipants", 0);
        double time = intent.getDoubleExtra("time", 0);

        init();

        calculatePriceTv.setText(price + "₪");

        newPriceGuest.setText(pricePerGuest + "");

        newPriceHour.setText(pricePerHour + "");

        newPriceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newPriceLl.setVisibility(View.VISIBLE);
            }
        });

        calculateAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    calculatePriceTv.setText(calculatePrice(Integer.parseInt(newPriceGuest.getText().toString()), numberOfParticipants, Integer.parseInt(newPriceHour.getText().toString()), time) + "₪");

                } catch (Exception e) {
                    Toast.makeText(mActivity, "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

        originalPriceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanData();
                Intent intent1 = new Intent(mActivity, MainActivity.class);
                startActivity(intent1);
            }
        });

    }

    private double calculatePrice(int pricePerGuest, int numberOfParticipants, int pricePerHour, double time) {
        return (pricePerGuest * numberOfParticipants + (pricePerHour * time) * 1.2) / numberOfParticipants;
    }

    public void init() {

        mActivity = this;

        calculatePriceTv = findViewById(R.id.text_view_calculate_price);
        recommendedPriceTv = findViewById(R.id.text_view_recommended_price);
        originalPriceBtn = findViewById(R.id.btn_original_price);
        recommendedPriceBtn = findViewById(R.id.btn_recommended_price);
        newPriceBtn = findViewById(R.id.btn_new_price);

        newPriceLl = findViewById(R.id.linear_layout_new_price);

        newPriceGuest = findViewById(R.id.edit_text_new_price_per_guest);
        newPriceHour = findViewById(R.id.edit_text_new_price_per_hour);

        calculateAgainBtn = findViewById(R.id.btn_calculate_again);

    }

    private void cleanData(){

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();

    }



}