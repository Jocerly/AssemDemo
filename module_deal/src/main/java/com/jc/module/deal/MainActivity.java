package com.jc.module.deal;

import android.os.Bundle;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jc.common.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// 在支持路由的页面上添加注解(必选)
// 这里的路径需要注意的是至少需要有两级，/xx/xx
@Route(path = "/deal/main")
public class MainActivity extends BaseActivity {

    @BindView(R2.id.deal_button)
    Button dealButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deal_activity_main);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

    }

    @OnClick(R2.id.deal_button)
    public void onViewClicked() {
        ARouter.getInstance().build("/sp/main").navigation();
    }
}
