package com.barhum.incomb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements DetailHostFragment.onHost, DetailFestFragment.onFest {

    private Button newFestBtn;
    private Button newHostBtn;
    private DetailFestFragment detailFestFragment;
    private DetailHostFragment detailHostFragment;

    private SharedPreferences sharedPreferences;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    private FloatingActionButton crateEventBtn;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        newFestBtn.setOnClickListener(view -> {
            replaceFragment(detailFestFragment);
        });

        newHostBtn.setOnClickListener(view -> {
            replaceFragment(detailHostFragment);
        });

        crateEventBtn.setOnClickListener(view -> {
            if (checkVaildation()){
                Intent intent = new Intent(MainActivity.this, EventGenerator.class);
                double time = 0;
                int pricePerGuest = Integer.parseInt(sharedPreferences.getString("pricePerGuest", ""));
                int numberOfParticipants =  Integer.parseInt(sharedPreferences.getString("numberOfParticipants", ""));
                int pricePerHour = Integer.parseInt(sharedPreferences.getString("pricePerHour", ""));
                try {
           //         time = testCla(sharedPreferences.getString("startTime", ""), sharedPreferences.getString("endTime", ""));
                    time = 3;
                }catch (Exception e){
                    e.getMessage();
                }

                intent.putExtra("calculatePrice", calculatePrice(pricePerGuest, numberOfParticipants, pricePerHour, time));
                intent.putExtra("time", time);
                intent.putExtra("pricePerGuest", pricePerGuest);
                intent.putExtra("pricePerHour", pricePerHour);
                intent.putExtra("numberOfParticipants", numberOfParticipants);

 //               removeAllPreferences();
                startActivity(intent);
            }else{
                Toast.makeText(this,"something not work", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void removeAllPreferences() {

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

        Map<String, String> map = (Map<String, String>) sharedPreferences.getAll();
        for(Map.Entry<String, String> e :map.entrySet()){
            editor.putString(e.getKey(),"");
            editor.apply();
        }
    }

    private boolean checkVaildation() {

       Map<String, String> map = (Map<String, String>) sharedPreferences.getAll();
       for(Map.Entry<String, String> e :map.entrySet()){
           if(e.getValue().equals(""))
               return false;
       }
        return true;
    }

    private void init(){
        newFestBtn = findViewById(R.id.btn_start_fest);
        newHostBtn = findViewById(R.id.btn_start_host);
        crateEventBtn = findViewById(R.id.floating_action_button);

         detailFestFragment = new DetailFestFragment(this);
         detailHostFragment = new DetailHostFragment(this);

         sharedPreferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

    }

    private void replaceFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, fragment)
                    .commit();
        }
    }


    @Override
    public void onRowListener(String tag, String value) {
        saveDetailIntoSharedPreferences(tag, value);
    }

    private void saveDetailIntoSharedPreferences(String tag, String value){
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(tag, value);
        editor.apply();
    }

    private double calculatePrice(int pricePerGuest, int numberOfParticipants, int pricePerHour, double time){
        return (pricePerGuest*numberOfParticipants+(pricePerHour * time) * 1.2)/numberOfParticipants;
    }

    private double testCla(String time1, String time2) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        Date date1 = simpleDateFormat.parse(time1);
        Date date2 = simpleDateFormat.parse(time2);

        long difference = date2.getTime() - date1.getTime();
        double days = (double) (difference / (1000*60*60*24));
        double hours = (double) ((difference - (1000*60*60*24*days)) / (1000*60*60));
        double min = (double) (difference - (1000*60*60*24*days) - (1000*60*60*hours)) / (1000*60);
        hours = (hours < 0 ? -hours : hours);
        return hours + (min/60);
    }

}