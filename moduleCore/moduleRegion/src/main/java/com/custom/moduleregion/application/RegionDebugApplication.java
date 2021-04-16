package com.custom.moduleregion.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.custom.modulebase.application.ApplicationService;

public class RegionDebugApplication extends Application implements ApplicationService {

    private static final String TAG = "RegionDebugApplication";
    private static RegionDebugApplication INSTANCE = null;

    public static RegionDebugApplication getInstance() {
        Log.d(TAG,"get RegionDebugApplication");
        return INSTANCE;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        INSTANCE = this;
    }

    @Override
    public void loadModuleApplicationService() {
        Log.d(TAG, "load RegionDebugApplication");
    }

    @Override
    public Application getApplication() {
        return getInstance();
    }

}
