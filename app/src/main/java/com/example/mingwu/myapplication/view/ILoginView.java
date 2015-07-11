package com.example.mingwu.myapplication.view;

import android.content.Context;

/**
 * Created by mingwu on 15/7/3.
 */
public interface ILoginView {
    public String getUserName();

    public String getPassWord();

    void toMainActivity(String message, int Code);

    void showFailError(String fail);

    void showLoading();

    void hideLoading();
    public Context getContext();
    public void setVersionName(String versionName);
    public void setVersionCode(String versionCode);

}
