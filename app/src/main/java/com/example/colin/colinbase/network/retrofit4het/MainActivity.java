package com.example.colin.colinbase.network.retrofit4het;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.colin.colinbase.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                LoginApi.login("18820243175","123456");
                break;
            case R.id.button2:
//                LoginApi.getAuthModel("18820243175", "123456");
                break;
            case R.id.button3:
//                UserApi.getUserModel();
//                BaseNetwork.getInstance().getUserInfo();
                break;
            case R.id.button4:
                break;
            case R.id.button5:

                break;
        }
    }
}
