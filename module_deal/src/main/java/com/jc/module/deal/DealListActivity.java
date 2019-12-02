package com.jc.module.deal;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.jc.common.base.BaseActivity;
import com.jc.common.base.BaseFragment;

import butterknife.ButterKnife;

public class DealListActivity extends BaseActivity {
    BaseFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deal_activity_deal_list);
        ButterKnife.bind(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = (BaseFragment) fragmentManager.findFragmentById(R.id.deal_fragment_list);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}
