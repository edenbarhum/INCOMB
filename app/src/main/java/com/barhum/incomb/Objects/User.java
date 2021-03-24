package com.barhum.incomb.Objects;

import android.text.TextUtils;
import android.util.Patterns;

public class User {

    private String userName;
    private String password;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public boolean isValidEmail(String userName) {
        return (!TextUtils.isEmpty(userName) && Patterns.EMAIL_ADDRESS.matcher(userName).matches());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
