package com.custom.modulenews.application;

import android.app.Application;

import com.custom.modulebase.application.ApplicationService;
import com.custom.modulenews.BuildConfig;

public class NewsApplication implements ApplicationService {

    private static final String TAG = "NewsApplication";

    private NewsApplication() {
    }

    private static class NewsApplicationHolder {
        private static final NewsApplication INSTANCE = new NewsApplication();
    }

    public static final NewsApplication getInstance() {
        return NewsApplicationHolder.INSTANCE;
    }

    @Override
    public void loadModuleApplicationService() {
        if (BuildConfig.DEBUG) {
            NewsDebugApplication.getInstance().loadModuleApplicationService();
        } else {
            NewsReleaseApplication.getInstance().loadModuleApplicationService();
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.DEBUG) {
            return NewsDebugApplication.getInstance().getApplication();
        } else {
            return NewsReleaseApplication.getInstance().getApplication();
        }
    }

}
