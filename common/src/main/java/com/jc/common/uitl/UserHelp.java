package com.jc.common.uitl;

import android.content.Context;
import android.content.SharedPreferences;

public class UserHelp {
    private static final String M_USER_KEY = "assem_cache_user_key";
    private static final String M_USER_KEY_NAME = "assem_cache_user_key_name";
    private static final String M_USER_KEY_PWD = "assem_cache_user_key_pwd";

    public static SharedPreferences getSharePreferences() {
        Context context = ContextHolder.getApplicationContext();
        return context.getSharedPreferences(M_USER_KEY, Context.MODE_PRIVATE);
    }

    public static void setUserInfo(String name, String pwd) {
        SharedPreferences.Editor aEditor = getSharePreferences().edit();

        aEditor.putString(M_USER_KEY_NAME, name);
        aEditor.putString(M_USER_KEY_PWD, pwd);

        aEditor.apply();
    }

    public static String getUserName() {
        return getSharePreferences().getString(M_USER_KEY_NAME, null);
    }

    public static String getUserPwd() {
        return getSharePreferences().getString(M_USER_KEY_PWD, null);
    }
}
