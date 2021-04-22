package com.custom.modulenews;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.custom.modulebase.base.BaseFragment;
import com.custom.moduleroute.RouteNewsPath;

@Route(path = RouteNewsPath.HOME_NEWS_FRAGMENT)
public class NewsFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.home_news;
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
