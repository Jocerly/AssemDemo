package com.jc.module.main;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jc.common.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R2.id.main_deal)
    Button deal;
    @BindView(R2.id.main_sp)
    Button sp;
    @BindView(R2.id.main_button4)
    Button button4;

    private long clickBackTime = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.main_deal)
    public void onViewClickedDeal() {
        ARouter.getInstance().build("/deal/main").navigation();
    }

    @OnClick(R2.id.main_sp)
    public void onViewClickedSp() {
        ARouter.getInstance().build("/sp/main").navigation();
    }

    @OnClick(R2.id.main_button4)
    public void onViewClickedBtn4() {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return quit();
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean quit() {
        if (clickBackTime == 0 || (System.currentTimeMillis() - clickBackTime) > 2000) {
            clickBackTime = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_LONG).show();
            return true;
        } else {
            finish();
            return false;
        }
    }


}
