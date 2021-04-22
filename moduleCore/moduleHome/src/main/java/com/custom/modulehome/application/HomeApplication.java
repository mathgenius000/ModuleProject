package com.custom.modulehome.application;

import android.app.Application;

import com.custom.modulebase.application.ApplicationService;
import com.custom.modulehome.BuildConfig;

public class HomeApplication implements ApplicationService {

    private static final String TAG = "IndexApplication";

    private HomeApplication() {
    }

    private static class HomeApplicationHolder {
        private static final HomeApplication INSTANCE = new HomeApplication();
    }

    public static final HomeApplication getInstance() {
        return HomeApplicationHolder.INSTANCE;
    }

    @Override
    public void init() {
        if (BuildConfig.IS_MODULE) {
            HomeReleaseApplication.getInstance().init();
        } else {
            HomeDebugApplication.getInstance().init();
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.IS_MODULE) {
            return HomeReleaseApplication.getInstance().getApplication();
        } else {
            return HomeDebugApplication.getInstance().getApplication();
        }
    }

}
