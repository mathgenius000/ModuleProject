package com.custom.moduleUser.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.custom.modulebase.application.ApplicationService;
import com.custom.modulebase.application.BaseApplication;

public class UserDebugApplication extends BaseApplication implements ApplicationService {

    private static final String TAG = "UserDebugApplication";
    private static UserDebugApplication INSTANCE = null;

    public static UserDebugApplication getInstance() {
        Log.d(TAG,"get UserDebugApplication");
        return INSTANCE;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        INSTANCE = this;
    }

    @Override
    public void init() {
        Log.d(TAG, "load UserDebugApplication");
    }

    @Override
    public Application getApplication() {
        return getInstance();
    }

}
