package com.barhum.incomb;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;


public class DetailHostFragment extends Fragment {

    private Activity activity;
    private Spinner locationSpinner;
    private String[] location;
    private EditText pricePerHourEt;
    private onHost callback;
    private SharedPreferences sharedPreferences;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public interface onHost{
        void onRowListener(String tag, String value);
    }


    public DetailHostFragment(Activity activity){
        location = new String[]{"Afula","Akko","Arad","Ariel","Ashdod","Ashkelon","Baqa al-Gharbiyye","Bat Yam","Beer Sheva","Beit Shean","Beit Shemesh","Betar Illit","Bnei Berak","Dimona","Eilat","Elad","Givatayim","Hadera","Haifa","Harish","Herzliya","Hod HaSharon","Holon","Jerusalem","Karmiel","Kfar Sava","Kiryat Ata","Kiryat Bialik","Kiryat Gat","Kiryat Malachi","Kiryat Motzkin","Kiryat Ono","Kiryat Shemone","Kiryat Yam","Lod","Maale Adumim","Maalot Tarshiha","Migdal HaEmek","Modiin","Nahariya","Nazareth","Nes Ziona","Nesher","Netanya","Netivot","Nof Hagalil","Ofakim","Or Akiva","Or Yehuda","Petah Tikva","Qalansawe","Raanana","Rahat","Ramat Hasharon","Ramat-Gan","Ramla","Rehovot","Rishon Lezion","Rosh Ha'ayin","Sakhnin","Sderot","Shefaram","Taibeh","Tamra","Tel Aviv","Tiberias","Tira","Tirat Carmel","Tsfat (Safed)","Umm al-Fahm","Yavne","Yehud-Monosson","Yokneam"};
        this.activity = activity;
        sharedPreferences  = activity.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        callback = (onHost)activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail_host, container, false);

        init(view);

        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                callback.onRowListener("location", locationSpinner.getSelectedItem().toString());
                callback.onRowListener("locationId", String.valueOf(position));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        pricePerHourEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                callback.onRowListener("pricePerHour", charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        return view;
    }

    private void init(View view){
        locationSpinner = view.findViewById(R.id.spinner_location);
        pricePerHourEt = view.findViewById(R.id.edit_text_price_per_hour);


        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,location);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        locationSpinner.setAdapter(adapter);

        setPreferences();

    }

    private void setPreferences() {

        int position;
        try {
            position = Integer.parseInt(sharedPreferences.getString("typeId","0"));
        }catch (Exception e){
            position = 0;
        }
        locationSpinner.setSelection(position);
        pricePerHourEt.setText(sharedPreferences.getString("pricePerHour", ""));
    }

}