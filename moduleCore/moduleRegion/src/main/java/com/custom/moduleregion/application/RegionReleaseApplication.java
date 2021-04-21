package com.custom.moduleregion.application;

import android.app.Application;
import android.util.Log;

import com.custom.modulebase.application.ApplicationService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RegionReleaseApplication implements ApplicationService {
    private static final String TAG = "RegionReleaseApplication";
    private static Application application;

    private RegionReleaseApplication() {
    }

    private static class IndexReleaseApplicationHolder {
        private static final RegionReleaseApplication INSTANCE = new RegionReleaseApplication();
    }

    public static RegionReleaseApplication getInstance() {
        return IndexReleaseApplicationHolder.INSTANCE;
    }

    /**
     * 反射 获取主App的Application
     *
     * @return
     */
    @Override
    public Application getApplication() {
        Log.d(TAG, "get RegionReleaseApplication");
        if (null == application) {
            try {
                Class clazz = Class.forName("com.custom.moduleproject.App");
                Method method = clazz.getMethod("getInstance");
                application = (Application) method.invoke(null);
                return application;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return application;
    }

    @Override
    public void init() {
        Log.d(TAG, "load RegionReleaseApplication");
    }
}
