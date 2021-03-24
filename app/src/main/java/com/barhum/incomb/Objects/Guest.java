package com.barhum.incomb.Objects;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;

public class Guest extends User{

    private String firstName;
    private String lastName;
    private DatePickerDialog birthday;
    private String gender;
    private Bitmap profilePhoto;

    public Guest(String userName, String password, String firstName, String lastName, DatePickerDialog birthday, String gender) {
        super(userName, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DatePickerDialog getBirthday() {
        return birthday;
    }

    public void setBirthday(DatePickerDialog birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Bitmap getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Bitmap profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}
