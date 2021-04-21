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
        if (BuildConfig.IS_MODULE) {
            UserReleaseApplication.getInstance().loadModuleApplicationService();
        } else {
            UserDebugApplication.getInstance().loadModuleApplicationService();
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.IS_MODULE) {
            return UserReleaseApplication.getInstance().getApplication();
        } else {
            return UserDebugApplication.getInstance().getApplication();
        }
    }

}
