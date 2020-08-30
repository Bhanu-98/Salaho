package com.devengers.salaho;
import com.google.firebase.firestore.PropertyName;

import java.io.*;

public class UserModel implements Serializable{

    @PropertyName("password")
    private String pass;

    @PropertyName("password")
    public String getPass() {
        return pass;
    }

    @PropertyName("password")
    public void setPass(String pass) {
        this.pass = pass;
    }

    @PropertyName("mobile_number")
    private String mobile;

    @PropertyName("mobile_number")
    public String getMobile() {
        return mobile;
    }

    @PropertyName("mobile_number")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @PropertyName("user_name")
    private String username;

    @PropertyName("user_name")
    public String getUsername() {
        return username;
    }

    @PropertyName("user_name")
    public void setUsername(String username) {
        this.username = username;
    }

    @PropertyName("full_name")
    private String fullname;

    @PropertyName("full_name")
    public String getFullname() {
        return fullname;
    }

    @PropertyName("full_name")
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @PropertyName("emailId")
    private String email;

    @PropertyName("emailId")
    public String getEmail() {
        return email;
    }

    @PropertyName("emailId")
    public void setEmail(String email) {
        this.email = email;
    }




}
