package com.custom.moduleroute.application;

import android.app.Application;

import com.custom.modulebase.application.ApplicationService;
import com.custom.moduleroute.BuildConfig;

public class RouteApplication implements ApplicationService {

    private static final String TAG = "RouteApplication";

    private RouteApplication() {
    }

    private static class RouteApplicationHolder {
        private static final RouteApplication INSTANCE = new RouteApplication();
    }

    public static final RouteApplication getInstance() {
        return RouteApplicationHolder.INSTANCE;
    }

    @Override
    public void loadModuleApplicationService() {
        if (BuildConfig.IS_MODULE) {
            RouteReleaseApplication.getInstance().loadModuleApplicationService();
        } else {
            RouteDebugApplication.getInstance().loadModuleApplicationService();
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.IS_MODULE) {
            return RouteReleaseApplication.getInstance().getApplication();
        } else {
            return RouteDebugApplication.getInstance().getApplication();
        }
    }

}
