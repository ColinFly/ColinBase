package com.example.colin.mvp_sunny.view;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.colin.mvp_hongyang.R;

/**
 * Created by colin on 16-3-10.
 */
public class LoginView extends AbsView {

    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin;
    private ProgressBar mPbLoading;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public View getRootView() {
        return super.getRootView();
    }

    @Override
    public void initWidget() {
        mEtUsername = (EditText) getRootView().findViewById(R.id.id_et_username);
        mEtPassword = (EditText) getRootView().findViewById(R.id.id_et_password);
        mBtnLogin = (Button) getRootView().findViewById(R.id.id_btn_login);
        mPbLoading = (ProgressBar)getRootView(). findViewById(R.id.id_pb_loading);


        setClickView(mBtnLogin);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.id_btn_login) {
            String account = mEtUsername.getText().toString();
            String password = mEtPassword.getText().toString();

            Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
        }
    }
}
