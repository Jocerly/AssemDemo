package com.jc.module.sp;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jc.common.base.BaseActivity;

@Route(path = "/sp/main")
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sp_activity_main);
        ARouter.getInstance().inject(this);

    }
}
