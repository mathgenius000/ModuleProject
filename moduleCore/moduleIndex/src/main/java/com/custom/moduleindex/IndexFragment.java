package com.custom.moduleindex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.custom.modulebase.base.BaseFragment;
import com.custom.moduleroute.RouteIndexPath;
import com.custom.moduleservice.route.ModuleRouteService;
import com.custom.moduleservice.proxy.core.ModuleServicer;
import com.custom.moduleservice.proxy.stub.LoginServiceStub;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RouteIndexPath.HOME_INDEX_FRAGMENT)
public class IndexFragment extends BaseFragment {

    @BindView(R2.id.btn_current_address)
    Button btnCurrentAddress;

    @BindView(R2.id.btn_login)
    Button btnLogin;

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

    @OnClick({R2.id.btn_current_address, R2.id.btn_login})
    public void onClick(View view) {
        if (view.getId() == R.id.btn_current_address) {
            Toast.makeText(getContext(), ModuleRouteService.getCurrentAddress(), Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btn_login) {
            ModuleServicer.getDefault().create(LoginServiceStub.class).login("DownieM", "asdf1234", new LoginServiceStub.LoginCallback() {
                @Override
                public void onSuccess(LoginServiceStub.LoginData data) {
                    Toast.makeText(getContext(), data.result, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFail(int code, String msg) {
                    Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
