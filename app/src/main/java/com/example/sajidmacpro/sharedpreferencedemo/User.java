package com.example.sajidmacpro.sharedpreferencedemo;

/**
 * Created by sajidMacPro on 3/7/16.
 */
public class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        setUserName(userName);
        setPassword(password);
    }

    public User(){

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
