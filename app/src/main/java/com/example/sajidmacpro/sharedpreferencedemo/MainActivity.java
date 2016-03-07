package com.example.sajidmacpro.sharedpreferencedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText userNameET;
    EditText passwordET;
    TextView showResult1;
    TextView showResult2;
    Preference pref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameET=(EditText)findViewById(R.id.userName);
        passwordET=(EditText)findViewById(R.id.password);
        showResult1=(TextView)findViewById(R.id.txtShowResult1);
        showResult2=(TextView)findViewById(R.id.txtShowResult2);
        pref=new Preference(this);

    }
    public void save(View v){
        String inputUserName=userNameET.getText().toString();
        String inputPassword=passwordET.getText().toString();
        User aUser=new User();
        aUser.setUserName(inputUserName);
        aUser.setPassword(inputPassword);
        String name=aUser.getUserName();
        String pw=aUser.getPassword();

        if(inputUserName.length()>0 && inputPassword.length()>0){
            pref.saveUserData(name, pw);

            userNameET.getText().clear();
            passwordET.getText().clear();

        }
        else {
            String err="You must fill user name and password!!";
            showResult1.setText(err);

        }

    }

    public void retrieve(View v){
        Map<String,String> map=pref.retrieveUserData();
        String username=map.get("name");
        String Password=map.get("pw");
        showResult1.setText(username);
        showResult2.setText(Password);

    }

    public void delete(View v){
//        editor.remove("name");
//        editor.remove("pw");
//        editor.commit();
        pref.delete();

    }
}
