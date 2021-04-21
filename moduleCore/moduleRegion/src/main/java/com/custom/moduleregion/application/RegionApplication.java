package com.custom.moduleregion.application;

import android.app.Application;

import com.custom.modulebase.application.ApplicationService;
import com.custom.moduleregion.BuildConfig;

public class RegionApplication implements ApplicationService {

    private static final String TAG = "NewsApplication";

    private RegionApplication() {
    }

    private static class RegionApplicationHolder {
        private static final RegionApplication INSTANCE = new RegionApplication();
    }

    public static final RegionApplication getInstance() {
        return RegionApplicationHolder.INSTANCE;
    }

    @Override
    public void init() {
        if (BuildConfig.IS_MODULE) {
            RegionReleaseApplication.getInstance().init();
        } else {
            RegionDebugApplication.getInstance().init();
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.IS_MODULE) {
            return RegionReleaseApplication.getInstance().getApplication();
        } else {
            return RegionDebugApplication.getInstance().getApplication();
        }
    }

}
