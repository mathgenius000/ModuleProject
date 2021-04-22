package com.custom.moduleregion;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.custom.modulebase.base.BaseFragment;
import com.custom.moduleroute.RouteRegionPath;

@Route(path = RouteRegionPath.HOME_REGION_FRAGMENT)
public class RegionFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.home_region;
    }

    @Override
    protected void initBundle(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
