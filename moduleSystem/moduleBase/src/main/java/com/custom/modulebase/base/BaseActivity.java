package com.custom.modulebase.base;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author：DownieM
 * Date：2020.10.14
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder butterKnifeBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        butterKnifeBind = ButterKnife.bind(this);
        initView();
        initListener();
        initData();
    }

    protected abstract void initData();//加载数据

    protected abstract void initListener();//加载监听器


    protected abstract void initView();//加载控件

    protected abstract int getLayoutId();//加载布局

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        if (butterKnifeBind != Unbinder.EMPTY) {
            butterKnifeBind.unbind();
            butterKnifeBind = null;
        }
    }

    /**
     * 沉浸式导航栏
     */
    protected void hideNavigationBar() {
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().setAttributes(params);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
}
