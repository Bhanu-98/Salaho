package com.devengers.salaho;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesConfiguration {
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPreferencesConfiguration(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);

    }

    public void writeLoginStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status), status);
        editor.commit();

    }
    public boolean readLoginStatus(){
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status),false);
        return status;
    }

    public void writeMobileNumber(String mobile)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getResources().getString(R.string.mobile_number),mobile);
    }
    public String readMobileNumber()
    {
        String mobile=sharedPreferences.getString(context.getResources().getString(R.string.mobile_number),"");
        return mobile;
    }

}
