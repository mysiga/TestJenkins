package com.example.mingwu.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mingwu.myapplication.presenter.LoginPresenter;
import com.example.mingwu.myapplication.view.ILoginView;


public class MainActivity extends Activity implements ILoginView {

    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;
    private TextView tv_versionName,tv_versionCode;

    private LoginPresenter mUserLoginPresenter = new LoginPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mEtUsername = (EditText) findViewById(R.id.id_et_username);
        mEtPassword = (EditText) findViewById(R.id.id_et_password);

        mBtnClear = (Button) findViewById(R.id.id_btn_clear);
        mBtnLogin = (Button) findViewById(R.id.id_btn_login);

        tv_versionName = (TextView) findViewById(R.id.tv_versionName);
        tv_versionCode = (TextView) findViewById(R.id.tv_versionCode);

        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.regeter();
            }
        });
        mUserLoginPresenter.initVersionMessage();
    }


    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassWord() {
        return mEtPassword.getText().toString();

    }

    @Override
    public void toMainActivity(String message, int Code) {
        switch (Code) {
            case 1:
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Intent intent = new Intent(this, RegeterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void showFailError(String fail) {
        Toast.makeText(this, fail, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void setVersionName(String versionName) {
        tv_versionName.setText(versionName);
    }

    @Override
    public void setVersionCode(String versionCode) {
        tv_versionCode.setText(versionCode);
    }
}
