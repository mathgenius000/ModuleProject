package com.custom.moduleroute;

import com.alibaba.android.arouter.launcher.ARouter;

public class RouteHome {

    /**
     * home
     */
    public static void lauchHome() {
        ARouter.getInstance().build(RouteHomePath.HOME_ACTIVITY).navigation();
    }

}
