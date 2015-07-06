package com.example.mingwu.myapplication.biz;

import android.content.Context;

/**
 * Created by mingwu on 15/7/4.
 */
public interface ILoginBiz {
    public void login(Context context, String username, String password, ILoginListener loginListener);

    public void clean();
}
