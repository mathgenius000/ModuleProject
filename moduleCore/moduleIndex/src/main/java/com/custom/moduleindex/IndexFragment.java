package com.custom.moduleindex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.custom.modulebase.base.BaseFragment;
import com.custom.moduleroute.RouteIndexPath;
import com.custom.moduleservice.ModuleRouteService;

import butterknife.BindView;

@Route(path = RouteIndexPath.HOME_INDEX_FRAGMENT)
public class IndexFragment extends BaseFragment{

    @BindView(R2.id.btn_current_address)
    Button btnCurrentAddress;

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
        btnCurrentAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCurrentAddress.setText(ModuleRouteService.getCurrentAddress());
            }
        });
    }

    @Override
    protected void initData() {

    }

//    @Override
//    public void onClick(View view) {
//        if (view.getId() == R.id.btn_current_address) {
//            btnCurrentAddress.setText(ModuleRouteService.getCurrentAddress());
//        }
//    }
}
