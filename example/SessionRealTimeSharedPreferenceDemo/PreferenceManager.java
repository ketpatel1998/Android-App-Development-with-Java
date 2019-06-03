package com.example.SessionRealTimeSharedPreferenceDemo;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {

    public static PreferenceManager preferenceManager;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public static PreferenceManager getInstance()
    {
        return preferenceManager;
    }

    public PreferenceManager(Context context)
    {
        preferenceManager = this;
        mSharedPreferences = context.getSharedPreferences(VariableBag.PREF_NAME,Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }
    public String getUserID()
    {
        String u = mSharedPreferences.getString(VariableBag.USER_ID,"");
        return u;
    }
    public String getPasswordID()
    {
        String p = mSharedPreferences.getString(VariableBag.PASSWORD_ID,"");
        return p;
    }
    public void setUserIDandPasswordID(String u,String p)
    {
        mEditor.putString(VariableBag.USER_ID,u);
        mEditor.putString(VariableBag.PASSWORD_ID,p);
        mEditor.commit();
    }

    public boolean getLoginSession()
    {
        boolean login = mSharedPreferences.getBoolean(VariableBag.LOGIN,false);
        return login;
    }
    public void setLoginSession()
    {

        mEditor.putBoolean(VariableBag.LOGIN,true);
        mEditor.commit();
    }
}
