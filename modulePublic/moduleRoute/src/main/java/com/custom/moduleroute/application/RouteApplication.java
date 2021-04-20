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
        if (BuildConfig.DEBUG) {
            RouteDebugApplication.getInstance().loadModuleApplicationService();
        } else {
            RouteReleaseApplication.getInstance().loadModuleApplicationService();
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.DEBUG) {
            return RouteDebugApplication.getInstance().getApplication();
        } else {
            return RouteReleaseApplication.getInstance().getApplication();
        }
    }

}
