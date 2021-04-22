package com.custom.moduleroute;

import com.alibaba.android.arouter.launcher.ARouter;

import androidx.fragment.app.Fragment;

public class RouteUtil {

    public static Fragment getHomeIndexFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteIndexPath.HOME_INDEX_FRAGMENT).navigation();
        return fragment;
    }

    public static Fragment getHomeNewsFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteNewsPath.HOME_NEWS_FRAGMENT).navigation();
        return fragment;
    }

    public static Fragment getHomeRegionFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteRegionPath.HOME_REGION_FRAGMENT).navigation();
        return fragment;
    }

    public static Fragment getHomeUserFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteUserPath.HOME_USER_FRAGMENT).navigation();
        return fragment;
    }

}