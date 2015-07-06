package com.example.mingwu.myapplication.presenter;

import android.content.Context;

import com.example.mingwu.myapplication.biz.ILoginBiz;
import com.example.mingwu.myapplication.biz.ILoginListener;
import com.example.mingwu.myapplication.biz.LoginBiz;
import com.example.mingwu.myapplication.view.ILoginView;

/**
 * Created by mingwu on 15/7/3.
 */
public class LoginPresenter {
    private ILoginView loginView;
    private ILoginBiz loginBiz;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        loginBiz=new LoginBiz();
    }

    public void login() {
        loginView.showLoading();
        final Context context=loginView.getContext();
        loginBiz.login(loginView.getContext(),loginView.getUserName(), loginView.getPassWord(), new ILoginListener() {
            @Override
            public void loginSuccess(String message) {
                loginView.hideLoading();
                loginView.toMainActivity(message,1);
            }

            @Override
            public void loginFail(String fail) {
                loginView.hideLoading();
                loginView.showFailError(fail);


            }
        });
    }

    public void regeter() {
        loginView.showLoading();
        loginView.hideLoading();
        loginView.toMainActivity(null,2);
    }
}
