package com.custom.moduleroute.application;

import android.app.Application;
import android.util.Log;

import com.custom.modulebase.application.ApplicationService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RouteReleaseApplication implements ApplicationService {
    private static final String TAG = "RouteReleaseApplication";
    private static Application application;

    private RouteReleaseApplication() {
    }

    private static class IndexReleaseApplicationHolder {
        private static final RouteReleaseApplication INSTANCE = new RouteReleaseApplication();
    }

    public static final RouteReleaseApplication getInstance() {
        return IndexReleaseApplicationHolder.INSTANCE;
    }

    /**
     * 反射 获取主App的Application
     *
     * @return
     */
    @Override
    public Application getApplication() {
        Log.d(TAG, "get RouteReleaseApplication");
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
        Log.d(TAG, "load RouteReleaseApplication");
//        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
//            ARouter.openLog();     // 打印日志
//            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }
//        ARouter.init(getApplication());
    }
}
