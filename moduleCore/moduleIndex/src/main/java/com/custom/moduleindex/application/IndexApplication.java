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
    public void init() {
        if (BuildConfig.IS_MODULE) {
            IndexReleaseApplication.getInstance().init();
        } else {
            IndexDebugApplication.getInstance().init();
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.IS_MODULE) {
            return IndexReleaseApplication.getInstance().getApplication();
        } else {
            return IndexDebugApplication.getInstance().getApplication();
        }
    }

}
