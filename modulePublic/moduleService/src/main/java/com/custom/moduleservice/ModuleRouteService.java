package com.custom.moduleservice;

import com.alibaba.android.arouter.launcher.ARouter;

public class ModuleRouteService {

    public static String getCurrentAddress() {
        IRegionModuleService regionModuleService = ARouter.getInstance().navigation(IRegionModuleService.class);
        if (regionModuleService != null) {
            return regionModuleService.getCurrentAddress();
        }
        return "";
    }

}
