package com.custom.modulenews.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.custom.modulebase.application.ApplicationService;

public class NewsDebugApplication extends Application implements ApplicationService {

    private static final String TAG = "NewsDebugApplication";
    private static NewsDebugApplication INSTANCE = null;

    public static NewsDebugApplication getInstance() {
        Log.d(TAG,"get NewsDebugApplication");
        return INSTANCE;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        INSTANCE = this;
    }

    @Override
    public void loadModuleApplicationService() {
        Log.d(TAG, "load NewsDebugApplication");
    }

    @Override
    public Application getApplication() {
        return getInstance();
    }

}
