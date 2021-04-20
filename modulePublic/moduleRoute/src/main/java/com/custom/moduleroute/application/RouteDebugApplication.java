package com.custom.moduleroute.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.custom.modulebase.application.ApplicationService;

public class RouteDebugApplication extends Application implements ApplicationService {

    private static final String TAG = "RouteDebugApplication";
    private static RouteDebugApplication INSTANCE = null;

    public static RouteDebugApplication getInstance() {
        Log.d(TAG, "get RouteDebugApplication");
        return INSTANCE;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.d(TAG, "get RouteDebugApplication attachBaseContext");
        INSTANCE = this;
    }

    @Override
    public void loadModuleApplicationService() {
        Log.d(TAG, "load RouteDebugApplication");
//        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
//            ARouter.openLog();     // 打印日志
//            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }
//        ARouter.init(getApplication());
    }

    @Override
    public Application getApplication() {
        return getInstance();
    }

}
