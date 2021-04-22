package com.custom.modulehome.application;

import android.app.Application;
import android.util.Log;

import com.custom.modulebase.application.ApplicationService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HomeReleaseApplication implements ApplicationService {
    private static final String TAG = "HomeReleaseApplication";
    private static Application application;

    private HomeReleaseApplication() {
    }

    private static class HomeReleaseApplicationHolder {
        private static final HomeReleaseApplication INSTANCE = new HomeReleaseApplication();
    }

    public static HomeReleaseApplication getInstance() {
        return HomeReleaseApplicationHolder.INSTANCE;
    }

    /**
     * 反射 获取主App的Application
     *
     * @return
     */
    @Override
    public Application getApplication() {
        Log.d(TAG, "get HomeReleaseApplication");
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
        Log.d(TAG, "load HomeReleaseApplication");
    }
}
