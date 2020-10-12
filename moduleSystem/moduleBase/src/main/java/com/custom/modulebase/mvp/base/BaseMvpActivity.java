package com.custom.modulebase.mvp.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Author：CanneyLin
 * Date：2018.11.16
 *
 * @param <M>
 * @param <V>
 * @param <P>
 */
public abstract class BaseMvpActivity<M extends Model, V extends View, P extends BasePresenter> extends AppCompatActivity implements BaseMvp<M, V, P> {

    protected P presenter;
    private MyBaseActiviy_Broad oBaseActiviy_Broad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 使通知栏透明化
//        Eyes.translucentStatusBar(this, true);
        //创建Presenter
        presenter = createPresenter();
        if (null != presenter) {
            //将Model层注册到Presenter中
            presenter.registerModel(createModel());
            //将View层注册到Presenter中
            presenter.registerView(createView());
        }
//        //动态注册广播
//        oBaseActiviy_Broad = new MyBaseActiviy_Broad();
//        IntentFilter intentFilter = new IntentFilter("com.sharedtalent.openhr.mvp.base.BaseMvpActivity");
//        registerReceiver(oBaseActiviy_Broad, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(oBaseActiviy_Broad);//注销广播
        //注销消息接收
//        JMessageClient.unRegisterEventReceiver(this);
        if (null != presenter) {
            //Acitivity销毁时调用，让具体实现BasePresenter中onViewDestroy方法做出决定
            presenter.destroy();
        }
    }

    //定义一个广播
    public class MyBaseActiviy_Broad extends BroadcastReceiver {

        public void onReceive(Context arg0, Intent intent) {
            //接收发送过来的广播内容
            int closeAll = intent.getIntExtra("closeAll", 0);
            if (closeAll == 1) {
                finish();//销毁BaseActivity
            }
        }

    }

    //设置字体为默认大小，不随系统字体大小改而改变
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale != 1)//非默认值
            getResources();
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (res.getConfiguration().fontScale != 1) {//非默认值
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();//设置默认
            res.updateConfiguration(newConfig, res.getDisplayMetrics());
        }
        return res;
    }

    /**
     * 设置界面不可重复点击
     *
     * @param intent
     * @param requestCode
     * @param options
     */
    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        if (checkDoubleClick(intent)) {
            super.startActivityForResult(intent, requestCode, options);
        }
    }

    private String mActivityJumpTag;        //activity跳转tag
    private long mClickTime;                //activity跳转时间

    /**
     * 检查是否重复跳转，不需要则重写方法并返回true
     */
    protected boolean checkDoubleClick(Intent intent) {
        // 默认检查通过
        boolean result = true;
        // 标记对象
        String tag;
        if (intent.getComponent() != null) { // 显式跳转
            tag = intent.getComponent().getClassName();
        } else if (intent.getAction() != null) { // 隐式跳转
            tag = intent.getAction();
        } else {
            return true;
        }

        if (tag.equals(mActivityJumpTag) && mClickTime >= SystemClock.uptimeMillis() - 500) {
            // 检查不通过
            result = false;
        }

        // 记录启动标记和时间
        mActivityJumpTag = tag;
        mClickTime = SystemClock.uptimeMillis();
        return result;
    }

}
