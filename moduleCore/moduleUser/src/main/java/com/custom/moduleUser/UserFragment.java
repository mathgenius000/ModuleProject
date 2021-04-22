package com.custom.moduleUser;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.custom.modulebase.base.BaseFragment;
import com.custom.moduleroute.RouteUserPath;

@Route(path = RouteUserPath.HOME_USER_FRAGMENT)
public class UserFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.home_user;
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
