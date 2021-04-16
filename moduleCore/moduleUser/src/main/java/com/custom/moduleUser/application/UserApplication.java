package com.custom.moduleUser.application;

import android.app.Application;

import com.custom.moduleUser.BuildConfig;
import com.custom.modulebase.application.ApplicationService;

public class UserApplication implements ApplicationService {

    private static final String TAG = "UserApplication";

    private UserApplication() {
    }

    private static class UserApplicationHolder {
        private static final UserApplication INSTANCE = new UserApplication();
    }

    public static final UserApplication getInstance() {
        return UserApplicationHolder.INSTANCE;
    }

    @Override
    public void loadModuleApplicationService() {
        if (BuildConfig.DEBUG) {
            UserDebugApplication.getInstance().loadModuleApplicationService();
        } else {
            UserReleaseApplication.getInstance().loadModuleApplicationService();
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.DEBUG) {
            return UserDebugApplication.getInstance().getApplication();
        } else {
            return UserReleaseApplication.getInstance().getApplication();
        }
    }

}
