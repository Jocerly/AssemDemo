package com.jc.module.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.jc.common.base.BaseActivity;
import com.jc.common.uitl.UserHelp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R2.id.main_edittext)
    EditText edittext;
    @BindView(R2.id.main_edittext2)
    EditText edittext2;
    @BindView(R2.id.main_button)
    Button mainButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_login);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        String name = UserHelp.getUserName();
        String pwd = UserHelp.getUserPwd();

        edittext.setText(name);
        edittext2.setText(pwd);
    }

    @OnClick(R2.id.main_button)
    public void onViewClicked() {
        String name = edittext.getText().toString();
        String pwd = edittext2.getText().toString();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(mContext, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
        } else {
            UserHelp.setUserInfo(name, pwd);
            skikToNewActivity(FMActivity.class);
//            skikToNewActivity(MainActivity.class);
        }
    }
}
