package com.example.mingwu.myapplication.biz;

/**
 * Created by mingwu on 15/7/3.
 */
public interface ILoginListener {
    void loginSuccess(String message);

    void loginFail(String fail);
}
