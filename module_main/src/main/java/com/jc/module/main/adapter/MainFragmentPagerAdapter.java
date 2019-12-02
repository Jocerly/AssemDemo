package com.jc.module.main.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jc.common.base.BaseFragment;

import java.util.ArrayList;

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    ArrayList<BaseFragment> listFragments = new ArrayList<>();

    public MainFragmentPagerAdapter(@NonNull FragmentManager fm, ArrayList<BaseFragment> listFragments) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.listFragments  =listFragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }
}
