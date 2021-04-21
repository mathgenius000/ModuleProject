package com.custom.moduleindex.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.custom.modulebase.application.ApplicationService;
import com.custom.modulebase.application.BaseApplication;
import com.custom.modulebase.base.BaseActivity;

public class IndexDebugApplication extends BaseApplication implements ApplicationService {

    private static final String TAG = "IndexDebugApplication";
    private static IndexDebugApplication INSTANCE = null;

    public static IndexDebugApplication getInstance() {
        Log.d(TAG,"get IndexDebugApplication");
        return INSTANCE;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        INSTANCE = this;
    }

    @Override
    public void init() {
        Log.d(TAG, "load IndexDebugApplication");
    }

    @Override
    public Application getApplication() {
        return getInstance();
    }

}
