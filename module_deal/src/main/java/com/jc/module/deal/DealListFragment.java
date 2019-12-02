package com.jc.module.deal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String msg = bundle.getString("key");
            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R2.id.deal_button)
    public void onViewClicked() {
        Bundle dealBundle = new Bundle();
        dealBundle.putString("key", "来自deal_DealListFragment");
        ARouter.getInstance().build("/sp/main").with(dealBundle).navigation();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
