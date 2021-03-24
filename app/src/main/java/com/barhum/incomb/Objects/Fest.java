package com.barhum.incomb.Objects;

import android.app.DatePickerDialog;

import java.util.List;

public class Fest extends Guest {

    private String generalDescription;
    private List<String> interest;
    private String city;
    private List<Post> postsList;

    public Fest(String userName, String password, String firstName, String lastName, DatePickerDialog birthday, String gender, String generalDescription, List<String> interest, String city) {
        super(userName, password, firstName, lastName, birthday, gender);
        this.generalDescription = generalDescription;
        this.interest = interest;
        this.city = city;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Post> getPostsList() {
        return postsList;
    }

    public void setPostsList(List<Post> postsList) {
        this.postsList = postsList;
    }
}
