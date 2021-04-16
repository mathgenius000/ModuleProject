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
    public void loadModuleApplicationService() {
        if (BuildConfig.DEBUG) {
            RegionDebugApplication.getInstance().loadModuleApplicationService();
        } else {
            RegionReleaseApplication.getInstance().loadModuleApplicationService();
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.DEBUG) {
            return RegionDebugApplication.getInstance().getApplication();
        } else {
            return RegionReleaseApplication.getInstance().getApplication();
        }
    }

}
