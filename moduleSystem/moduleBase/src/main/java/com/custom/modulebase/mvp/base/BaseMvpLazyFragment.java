package com.custom.modulebase.mvp.base;

import android.content.Context;

/**
 * Author：CanneyLin
 * Date：2018.11.20
 * Description: 懒加载模式BaseFragment
 *
 * @param <M>
 * @param <V>
 * @param <P>
 */
public abstract class BaseMvpLazyFragment<M extends Model, V extends View, P extends BasePresenter> extends BaseMvpFragment<M, V, P> {

    /**
     * Fragment当前状态是否可见
     */
    protected boolean isVisible;


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    //先于oncreatview执行的方法
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 可见
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * 不可见
     */
    protected void onInvisible() {
    }

    /**
     * 延迟加载
     * 子类必须重写此方法
     */
    protected abstract void lazyLoad();

}
