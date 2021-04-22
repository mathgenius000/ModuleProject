package com.custom.modulehome.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.custom.modulebase.application.ApplicationService;
import com.custom.modulebase.application.BaseApplication;

public class HomeDebugApplication extends BaseApplication implements ApplicationService {

    private static final String TAG = "HomeDebugApplication";
    private static HomeDebugApplication INSTANCE = null;

    public static HomeDebugApplication getInstance() {
        Log.d(TAG,"get HomeDebugApplication");
        return INSTANCE;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        INSTANCE = this;
    }

    @Override
    public void init() {
        Log.d(TAG, "load HomeDebugApplication");
    }

    @Override
    public Application getApplication() {
        return getInstance();
    }

}
