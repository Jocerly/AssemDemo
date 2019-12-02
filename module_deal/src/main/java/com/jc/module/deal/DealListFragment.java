package com.jc.module.deal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jc.common.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

@Route(path = "/deal/list")
public class DealListFragment extends BaseFragment {
    @BindView(R2.id.deal_button)
    Button dealButton;
    @BindView(R2.id.deal_tv_msg)
    TextView dealTvMsg;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.deal_activity_main, container, false);
        unbinder = ButterKnife.bind(this, view);

        dealTvMsg.setText("我是业务组件-折扣-fragment");

        return view;
    }

    @OnClick(R2.id.deal_button)
    public void onViewClicked() {
        ARouter.getInstance().build("/sp/main").navigation();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
