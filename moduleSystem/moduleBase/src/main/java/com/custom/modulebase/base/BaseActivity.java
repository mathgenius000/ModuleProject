package com.custom.modulebase.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.custom.modulebase.base.action.BundleAction;
import com.custom.modulebase.base.action.HandlerAction;
import com.custom.modulebase.base.action.KeyboardAction;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author：DownieM
 * Date：2020.10.14
 */
public abstract class BaseActivity extends AppCompatActivity implements HandlerAction, BundleAction, KeyboardAction {

    private Unbinder butterKnifeBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        super.onCreate(savedInstanceState);
        initLayout();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        butterKnifeBind = ButterKnife.bind(this);
        initView();
        initListener();
        initData();
    }

    protected abstract int getLayoutId();//加载布局

    protected abstract void initView();//加载控件

    protected abstract void initListener();//加载监听器

    protected abstract void initData();//加载数据

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent event) {

    }

    /**
     * 初始化布局
     */
    protected void initLayout() {
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            initSoftKeyboard();
        }
    }

    /**
     * 初始化软键盘
     */
    protected void initSoftKeyboard() {
        // 点击外部隐藏软键盘，提升用户体验
        getContentView().setOnClickListener(v -> {
            // 隐藏软键，避免内存泄漏
            hideKeyboard(getCurrentFocus());
        });
    }

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

    @Override
    public void finish() {
        // 隐藏软键，避免内存泄漏
        hideKeyboard(getCurrentFocus());
        super.finish();
    }

    /**
     * 如果当前的 Activity（singleTop 启动模式） 被复用时会回调
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // 设置为当前的 Intent，避免 Activity 被杀死后重启 Intent 还是最原先的那个
        setIntent(intent);
    }


    @Override
    public Bundle getBundle() {
        return getIntent().getExtras();
    }

    /**
     * 和 setContentView 对应的方法
     */
    public ViewGroup getContentView() {
        return findViewById(Window.ID_ANDROID_CONTENT);
    }

}
