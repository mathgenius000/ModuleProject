package com.custom.moduleindex.application;

import android.app.Application;

import com.custom.modulebase.application.ApplicationService;
import com.custom.moduleindex.BuildConfig;

public class IndexApplication implements ApplicationService {

    private static final String TAG = "IndexApplication";

    private IndexApplication() {
    }

    private static class IndexApplicationHolder {
        private static final IndexApplication INSTANCE = new IndexApplication();
    }

    public static final IndexApplication getInstance() {
        return IndexApplicationHolder.INSTANCE;
    }

    @Override
    public void loadModuleApplicationService() {
        if (BuildConfig.DEBUG) {
            IndexDebugApplication.getInstance().loadModuleApplicationService();
        } else {
            IndexReleaseApplication.getInstance().loadModuleApplicationService();
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.DEBUG) {
            return IndexDebugApplication.getInstance().getApplication();
        } else {
            return IndexReleaseApplication.getInstance().getApplication();
        }
    }

}
