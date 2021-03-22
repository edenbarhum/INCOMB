package com.barhum.incomb;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import androidx.fragment.app.Fragment;

public class DetailFestFragment extends Fragment {

    private Activity activity;
    private TextView datePickerTv;
    private Calendar dateSelected;
    private DatePickerDialog datePickerDialog;
    private Spinner typeSpinner;
    private String[] type;
    private TextView startTimeTv;
    private TextView endTimeTv;
    private EditText numberOfParticipantsEt;
    private EditText pricePerGuestEt;
    private onFest callback;
    private SharedPreferences sharedPreferences;
    public static final String MY_PREFS_NAME = "MyPrefsFile";


    public interface onFest{
        void onRowListener(String tag, String value);
    }


    public DetailFestFragment(Activity activity) {
        // Required empty public constructor
        dateSelected = Calendar.getInstance();
        type = new String[]{"Yoga", "Lecture", "Cooking work shop", "Watch a movie sport show" , "Meditation", " Paint Lession" , "Fashion Sale", "MindFulness lession"};
        this.activity = activity;
        sharedPreferences  = activity.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        callback = (onFest)activity;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail_fest, container, false);

        init(view);

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                callback.onRowListener("type", typeSpinner.getSelectedItem().toString());
                callback.onRowListener("typeId", String.valueOf(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        datePickerTv.setOnClickListener(view1 -> {
            setDateTimeField();
        });

        startTimeTv.setOnClickListener(view1 -> {
            setDateTime(startTimeTv, "startTime");
        });

        endTimeTv.setOnClickListener(view1 -> {
            setDateTime(endTimeTv, "endTime");
        });

        numberOfParticipantsEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                callback.onRowListener("numberOfParticipants", charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        pricePerGuestEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                callback.onRowListener("pricePerGuest", charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }

    private void init(View view){

        typeSpinner = view.findViewById(R.id.spinner_type);
        datePickerTv = view.findViewById(R.id.text_view_select_date);
        startTimeTv = view.findViewById(R.id.text_view_select_start_time);
        endTimeTv = view.findViewById(R.id.text_view_select_end_time);
        numberOfParticipantsEt = view.findViewById(R.id.edit_text_number_of_participants);
        pricePerGuestEt = view.findViewById(R.id.edit_text_price_per_guest);


        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        typeSpinner.setAdapter(adapter);

        setPreferences();

    }

    private void setDateTimeField() {
        Calendar newCalendar = dateSelected;
        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateSelected.set(year, monthOfYear, dayOfMonth, 0, 0);
                setDateSelected(dateSelected);
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void setDateSelected(Calendar dateSelected){
        datePickerTv.setText(dateSelected.getTime().toString());
        callback.onRowListener("date", dateSelected.getTime().toString());
    }

    private void setDateTime(TextView textView, String tag){

        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        textView.setText(hourOfDay + ":" + minute);
                        callback.onRowListener(tag, textView.getText().toString());
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void setPreferences() {
        int position;
        try {
             position = Integer.parseInt(sharedPreferences.getString("typeId","0"));
        }catch (Exception e){
            position = 0;
        }

        typeSpinner.setSelection(position);
        datePickerTv.setText(sharedPreferences.getString("date", ""));
        startTimeTv.setText(sharedPreferences.getString("startTime", ""));
        endTimeTv.setText(sharedPreferences.getString("endTime", ""));
        numberOfParticipantsEt.setText(sharedPreferences.getString("numberOfParticipants", ""));
        pricePerGuestEt.setText(sharedPreferences.getString("pricePerGuest", ""));
    }

}