package com.custom.moduleindex;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.custom.modulebase.base.BaseFragment;
import com.custom.moduleroute.RouteIndexPath;

@Route(path = RouteIndexPath.HOME_INDEX_FRAGMENT)
public class IndexFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.home_index;
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
