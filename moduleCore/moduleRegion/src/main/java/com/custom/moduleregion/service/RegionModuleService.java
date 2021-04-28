package com.custom.moduleregion.service;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.custom.moduleroute.RouteRegionPath;
import com.custom.moduleservice.route.IRegionModuleService;

@Route(path = RouteRegionPath.REGION_MODULE_SERVICE)
public class RegionModuleService implements IRegionModuleService {

    private static final String TAG = "RegionModuleService";

    @Override
    public String getCurrentAddress() {
        return RegionService.getCurrentAddress();
    }

    @Override
    public void init(Context context) {
        Log.d(TAG, "RegionModuleService --- init()");
    }
}
