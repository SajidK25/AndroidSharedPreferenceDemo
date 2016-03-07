package com.example.sajidmacpro.sharedpreferencedemo;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by sajidMacPro on 3/7/16.
 */
public class Preference {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    public static  final String PREF_NAME="login";
    public static  final String NAME_KEY="name";
    public static  final String PASS_KEY="pw";

    public Preference(Context context) {
        this.context=context;
        sharedPreferences=context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public void saveUserData(String name,String pw){
        editor.putString(NAME_KEY,name);
        editor.putString(PASS_KEY,pw);
        editor.commit();
    }
    public HashMap<String,String> retrieveUserData(){

        String name=sharedPreferences.getString(NAME_KEY,"Data not found");
        String pw=sharedPreferences.getString(PASS_KEY,"Data not found");
        HashMap<String,String> userHashMap=new HashMap<String,String>();
        userHashMap.put("name",name);
        userHashMap.put("pw",pw);
        return userHashMap;
    }
    public void delete(){
        editor.remove("name");
        editor.remove("pw");
        editor.commit();

    }

}
