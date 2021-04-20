package com.custom.moduleproject;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.custom.moduleUser.application.UserApplication;
import com.custom.moduleUser.application.UserDebugApplication;
import com.custom.modulebase.application.ApplicationService;
import com.custom.moduleindex.application.IndexApplication;
import com.custom.modulenews.application.NewsApplication;
import com.custom.modulenews.application.NewsDebugApplication;
import com.custom.moduleregion.application.RegionApplication;
import com.custom.moduleroute.RouteActivity;
import com.custom.moduleroute.application.RouteApplication;

public class App extends Application implements ApplicationService {
    private static App INSTANCE = null;
    private static final String TAG = "App";

    public static App getInstance() {
        Log.d(TAG, "get application");
        return INSTANCE;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        INSTANCE = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        loadModuleApplicationService();//加载每个module的Application，使其完成初始化工作
//        registerRouter();
    }

//    private void registerRouter(){
//        //RouterGuider.inject(this);
//        initRouterByAnnotation();// 注册Activity 路由
//        // OR
//        // initRouterByDynamic(); // 注册Activity 路由
//        loadModuleApplicationService(); //加载每个module的Application，使其完成初始化工作
//        RouterServiceManager.getInstance().init(this);// 注册组件之间服务路由
//    }

//    private void initRouterByAnnotation() {
//        //参数为module name
//        RouterInject.registerModule("shop");
//        RouterInject.registerModule("user");
////		RouterInject.inject("com.joybar.moduleuser.MainActivity");
////		RouterInject.inject("com.joybar.moduleshop.MainActivity");
////		RouterInject.inject("com.joybar.moduleshop.ReceiveParamActivity");
////		RouterInject.inject("com.joybar.moduleshop.FinishWithResultActivity");
////		RouterInject.inject("com.joybar.moduleshop.PostModuleDataActivity");
//    }

//    private void initRouterByDynamic() {
//        //需要把每个注册的页面添加到路由表里面，不推荐
//        Router.registerRouters(new Router.RouterTable() {
//            @Override
//            public List<Rule> buildRuleList() {
//                List<Rule> ruleList = new ArrayList<>();
//                ruleList.add(new Rule("user", "main", com.joybar.moduleuser.MainActivity.class));
//                ruleList.add(new Rule("shop", "main", com.joybar.moduleshop.MainActivity.class));
//                ruleList.add(new Rule("shop", "receive_param", com.joybar.moduleshop.ReceiveParamActivity.class));
//                ruleList.add(new Rule("shop", "finish_with_result", com.joybar.moduleshop.FinishWithResultActivity.class));
//                return ruleList;
//            }
//        });
//    }

    @Override
    public void loadModuleApplicationService() {
        RouteApplication.getInstance().loadModuleApplicationService();
        IndexApplication.getInstance().loadModuleApplicationService();
        NewsApplication.getInstance().loadModuleApplicationService();
        RegionApplication.getInstance().loadModuleApplicationService();
        UserApplication.getInstance().loadModuleApplicationService();
    }

    @Override
    public Application getApplication() {
        return getInstance();
    }
}
