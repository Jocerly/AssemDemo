package com.jc.common.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    protected Activity mActivity;
    protected Context mContext;
    protected Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mContext = this.getApplicationContext();

        mHandler = new Handler();

    }

    protected void skikToNewActivity(Class<?> newClass) {
        Intent intent = new Intent(mContext, newClass);
        startActivity(intent);
        finish();
    }

    protected void skikToNewActivity(Class<?> newClass, Bundle bundle) {
        Intent intent = new Intent(mContext, newClass);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    protected void skikToNewActivity(Class<?> newClass, int code) {
        Intent intent = new Intent(mContext, newClass);
        startActivityForResult(intent, code);
        finish();
    }

    protected void skikToNewActivity(Class<?> newClass, Bundle bundle, int code) {
        Intent intent = new Intent(mContext, newClass);
        intent.putExtras(bundle);
        startActivityForResult(intent, code);
        finish();
    }
}
