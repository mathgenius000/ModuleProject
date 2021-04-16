package com.custom.modulenews.application;

import android.app.Application;
import android.util.Log;

import com.custom.modulebase.application.ApplicationService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NewsReleaseApplication implements ApplicationService {
    private static final String TAG = "NewsReleaseApplication";
    private static Application application;

    private NewsReleaseApplication() {
    }

    private static class IndexReleaseApplicationHolder {
        private static final NewsReleaseApplication INSTANCE = new NewsReleaseApplication();
    }

    public static final NewsReleaseApplication getInstance() {
        return IndexReleaseApplicationHolder.INSTANCE;
    }

    /**
     * 反射 获取主App的Application
     *
     * @return
     */
    @Override
    public Application getApplication() {
        Log.d(TAG, "get NewsReleaseApplication");
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
        Log.d(TAG, "load NewsReleaseApplication");
    }
}
