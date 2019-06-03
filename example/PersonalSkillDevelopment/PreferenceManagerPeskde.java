package com.example.PersonalSkillDevelopment;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.SessionRealTimeSharedPreferenceDemo.PreferenceManager;

public class PreferenceManagerPeskde {

    public static PreferenceManagerPeskde preferenceManagerPeskde;
    private SharedPreferences mshaSharedPreferences;
    private SharedPreferences.Editor meditor;

    public PreferenceManagerPeskde(Context context)
    {
        preferenceManagerPeskde = this;
        mshaSharedPreferences = context.getSharedPreferences(VariableBag.PREFNAME,context.MODE_PRIVATE);
        meditor = mshaSharedPreferences.edit();

    }

    public static PreferenceManagerPeskde getInstance()
    {

        return preferenceManagerPeskde;
    }
    public void setLoginSharedPrefrence()
    {
        meditor.putString(VariableBag.LOGIN,"SET");
        meditor.commit();
    }
    public String getLoginSharedPrefrence()
    {
        String login = mshaSharedPreferences.getString(VariableBag.LOGIN,"");
        return login;
    }
    public void setSCINCEQUIZSharedPreference(String sci)
    {
        meditor.putString(VariableBag.SCINCEQUIZ,sci);
        meditor.commit();
    }
    public String getSCINCEQUIZSharedPreference()
    {
        String  jk = mshaSharedPreferences.getString(VariableBag.SCINCEQUIZ,"");
        return jk;
    }

    public void setUsernameAndPasswordSharedPrefrence(String uname,String pass)
    {
        meditor.putString(VariableBag.USERNAME,uname);
        meditor.putString(VariableBag.PASSWORD,pass);
        meditor.commit();
    }
    public String getUsernameSharePrefrence()
    {
        String uname = mshaSharedPreferences.getString(VariableBag.USERNAME,"");
        return uname;
    }
    public String getPasswordSharedPrefrence()
    {
        String pass = mshaSharedPreferences.getString(VariableBag.PASSWORD,"");
        return pass;
    }
    public void setRegisterInfo(String name,String uname,String email,String phone,String pass)
    {
        meditor.putString(VariableBag.NAME,name);
        meditor.putString(VariableBag.EMAIL,email);
        meditor.putString(VariableBag.USERNAME,uname);
        meditor.putString(VariableBag.PHONE,phone);
        meditor.putString(VariableBag.PASSWORD,pass);
        meditor.commit();
    }
    public String getNameSharedPrefrence()
    {
        String name = mshaSharedPreferences.getString(VariableBag.NAME,"");
        return name;

    }
    public String getEmailSharedPrefrence()
    {
        String email = mshaSharedPreferences.getString(VariableBag.EMAIL,"");
        return email;
    }
    public String getPhoneSharedPrefrence()
    {
        String phone = mshaSharedPreferences.getString(VariableBag.PHONE,"");
        return phone;
    }
    public String getUserIDSharedPrefrence()
    {
        String userid = mshaSharedPreferences.getString(VariableBag.USERID,"");
        return userid;
    }
    public void setUserIDSharedPreference(String k)
    {
        meditor.putString(VariableBag.USERID,k);
        meditor.commit();
    }
    public void setLogoutSharedPreference()
    {
        meditor.putString(VariableBag.LOGIN,"unset");
        meditor.putString(VariableBag.LEVEL,"unset");
        meditor.putString(VariableBag.USERID,"unset");
        meditor.putString(VariableBag.NAME,"unset");
        meditor.putString(VariableBag.EMAIL,"unset");
        meditor.putString(VariableBag.USERNAME,"unset");
        meditor.putString(VariableBag.PHONE,"unset");
        meditor.putString(VariableBag.PASSWORD,"unset");
        meditor.commit();
    }
    public void setLevelSharedPreference(String k)
    {
        meditor.putString(VariableBag.LEVEL,k);
        meditor.commit();
    }
    public String getLevelSharedPreference()
    {
        String level = mshaSharedPreferences.getString(VariableBag.LEVEL,"");
        return level;
    }
}
