package com.jc.common.uitl;

import android.app.Application;
import android.content.Context;

import com.jc.common.base.BaseApplication;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hl on 17/9/28.
 */

public class ContextHolder {

    /**
     * 获取APP上下文:
     * 用于明确仅可使用Context作为上下文的方法，
     * 如果是要求Activity作为上下文，则不应该使用当前方法的上下文
     */
    public static Context getApplicationContext() {
        Context context = getApplicationContextV1();
        if (context == null) {
            context = getApplicationContextV2();
        }

        // add by hl on 2018.04.16
        if (context == null) {
            context = BaseApplication.getInstance().getApplicationContext();
        }

        return context;
    }

    /**
     * 通过反射主线程的参数，获得当前App的上下文
     */
    private static Context getApplicationContextV1() {
        try {
            Application application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null, (Object[]) null);
            return application.getApplicationContext();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过反射主线程的参数，获得当前App的上下文
     */
    private static Context getApplicationContextV2() {
        Application application = null;
        Class<?> activityThreadClass;
        try {
            activityThreadClass = Class.forName("android.app.ActivityThread");
            Field appField = activityThreadClass
                    .getDeclaredField("mInitialApplication");
            // Object object = activityThreadClass.newInstance();
            final Method method = activityThreadClass.getMethod(
                    "currentActivityThread", new Class[0]);
            // 得到当前的ActivityThread对象
            Object localObject = method.invoke(null, (Object[]) null);
            appField.setAccessible(true);
            application = (Application) appField.get(localObject);
            return application.getApplicationContext();
            // appField.
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
