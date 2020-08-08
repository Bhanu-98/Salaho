package com.devengers.salaho;
import com.google.firebase.firestore.PropertyName;

import java.io.*;

public class LoginModel implements Serializable{

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

}
