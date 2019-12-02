package com.jc.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jc.common.base.BaseActivity;
import com.jc.common.base.BaseFragment;
import com.jc.module.main.adapter.MainFragmentPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FMActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    @BindView(R2.id.main_message_viewpage)
    ViewPager mainMessageViewpage;
    @BindView(R2.id.main_tv_deal)
    TextView mainTvDeal;
    @BindView(R2.id.main_tv_sp)
    TextView mainTvSp;
    @BindView(R2.id.main_ll_bottom)
    LinearLayout mainLlBottom;

    ArrayList<BaseFragment> listFragments = new ArrayList<>();
    BaseFragment fragmentDeal, fragmentSp;
    FragmentManager fManager;
    MainFragmentPagerAdapter pagerAdapter;
    int currentPosition = 0;
    long clickBackTime = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_fm);
        ButterKnife.bind(this);

        initFragment();
    }

    private void initFragment() {
        Bundle dealBundle = new Bundle();
        dealBundle.putString("key", "value");
        fManager = getSupportFragmentManager();
        fragmentDeal = (BaseFragment) ARouter.getInstance().build("/deal/list").navigation();
        fragmentSp = (BaseFragment) ARouter.getInstance().build("/sp/list").navigation();
        fragmentDeal.setArguments(dealBundle);

        listFragments.clear();
        listFragments.add(fragmentDeal);
        listFragments.add(fragmentSp);

        pagerAdapter = new MainFragmentPagerAdapter(fManager, listFragments);
        mainMessageViewpage.setAdapter(pagerAdapter);
        mainMessageViewpage.addOnPageChangeListener(this);
        mainMessageViewpage.setCurrentItem(currentPosition);
    }

    @OnClick(R2.id.main_tv_deal)
    public void onMainTvDealClicked() {
        currentPosition = 0;
        mainMessageViewpage.setCurrentItem(currentPosition);
    }

    @OnClick(R2.id.main_tv_sp)
    public void onMainTvSpClicked() {
        currentPosition = 1;
        mainMessageViewpage.setCurrentItem(currentPosition);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentPosition = position;
        showTvWithPosition();
    }

    private void showTvWithPosition() {
        switch (currentPosition) {
            case 1:
                mainTvDeal.setTextColor(getResources().getColor(R.color.colorPrimary));
                mainTvSp.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            default:
                mainTvDeal.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mainTvSp.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BaseFragment fragment = listFragments.get(mainMessageViewpage.getCurrentItem());
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
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
