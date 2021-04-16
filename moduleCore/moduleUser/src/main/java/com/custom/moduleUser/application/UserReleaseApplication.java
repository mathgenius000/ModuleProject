package com.custom.moduleUser.application;

import android.app.Application;
import android.util.Log;

import com.custom.modulebase.application.ApplicationService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserReleaseApplication implements ApplicationService {
    private static final String TAG = "UserReleaseApplication";
    private static Application application;

    private UserReleaseApplication() {
    }

    private static class IndexReleaseApplicationHolder {
        private static final UserReleaseApplication INSTANCE = new UserReleaseApplication();
    }

    public static final UserReleaseApplication getInstance() {
        return IndexReleaseApplicationHolder.INSTANCE;
    }

    /**
     * 反射 获取主App的Application
     *
     * @return
     */
    @Override
    public Application getApplication() {
        Log.d(TAG, "get UserReleaseApplication");
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
    public void loadModuleApplicationService() {
        Log.d(TAG, "load UserReleaseApplication");
    }
}
