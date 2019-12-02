package com.jc.module.main;

import android.os.Bundle;

import com.jc.common.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_splash);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                skikToNewActivity(LoginActivity.class);
            }
        }, 1500);
    }
}
