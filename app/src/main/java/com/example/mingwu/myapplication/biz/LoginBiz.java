package com.example.mingwu.myapplication.biz;

import android.content.Context;

/**
 * Created by mingwu on 15/7/3.
 */
public class LoginBiz implements ILoginBiz {

    @Override
    public void login(Context context, String username, String password, ILoginListener loginListener) {

        if (username == null || username.equals("")) {
            loginListener.loginFail("username is null");
        } else if (password == null || password.equals("")) {
            loginListener.loginFail("password is null");
        } else {
            if (username.equals("123") && password.equals("123")) {
                loginListener.loginSuccess("login success");
            } else {
                loginListener.loginFail("username is error or password is error");
            }
        }
    }

    @Override
    public void clean() {

    }
}
