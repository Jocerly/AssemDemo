package com.jc.module.sp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jc.common.base.BaseActivity;

@Route(path = "/sp/main")
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sp_activity_main);

        Intent intent = getIntent();
        if (intent.hasExtra("key")) {
            String msg = intent.getStringExtra("key");
            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
