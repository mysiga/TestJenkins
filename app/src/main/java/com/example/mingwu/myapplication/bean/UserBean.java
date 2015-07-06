package com.example.mingwu.myapplication.bean;


/**
 *
 */
public class UserBean {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    /**
     * @param username
     * @return
     */
    public UserBean setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {

        return password;
    }

    public UserBean setPassword(String password) {
        this.password = password;
        return this;
    }
}
