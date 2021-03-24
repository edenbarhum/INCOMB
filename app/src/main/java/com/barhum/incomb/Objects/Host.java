package com.barhum.incomb.Objects;

import android.app.DatePickerDialog;

public class Host extends Guest {

    private Place place;

    public Host(String userName, String password, String firstName, String lastName, DatePickerDialog birthday, String gender, Place place) {
        super(userName, password, firstName, lastName, birthday, gender);
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
