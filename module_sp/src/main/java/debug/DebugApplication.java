package debug;

import com.jc.common.base.BaseApplication;

public class DebugApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        //初始化 日之类，crash收集，推送设置等等...

    }
}
