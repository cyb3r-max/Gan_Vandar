package com.fun.ganvandar;

import android.content.Context;
import android.content.SharedPreferences;

public class Preference {
    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static String KEY_IS_LOGIN_MODE = "isLoginMode";

    public Preference(Context context) {
        this.context = context;
        preferences = this.context.getSharedPreferences("myPreference",Context.MODE_PRIVATE);
    }

    public void setToken(String token){
        editor = preferences.edit();
        editor.putBoolean(KEY_IS_LOGIN_MODE,true);
        editor.putString("token",token);
        editor.commit();
    }


    public String getToken(){
        return preferences.getString("token",null);
    }


    public boolean islogin(){
        return preferences.getBoolean(KEY_IS_LOGIN_MODE, false);
    }
}
