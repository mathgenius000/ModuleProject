package com.custom.modulebase.mvp.base;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * Author：CanneyLin
 * Date：2018.11.20
 *
 * @param <M>
 * @param <V>
 * @param <P>
 */
public abstract class BaseIndexFragment<M extends Model, V extends View, P extends BasePresenter> extends BaseMvpFragment<M, V, P> {

    protected Activity mActivity;

    /**
     * Fragment当前状态是否可见
     */
    protected boolean isVisible;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
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

    /**
     * 切换当前的fragment
     *
     * @param fromFragment    当前fragment
     * @param targetFragment  要加载的fragment
     * @param containerViewId 布局id
     * @return 要加载的fragment
     */
    protected Fragment switchCurrentFragment(Fragment fromFragment, Fragment targetFragment, @IdRes int containerViewId) {
        FragmentTransaction transaction = getChildFragmentManager()
                .beginTransaction();
        if (fromFragment != null) {
            if (targetFragment == null) {
                return fromFragment;
            }
            if (!targetFragment.isAdded()) {
                transaction
                        .hide(fromFragment)
                        .add(containerViewId, targetFragment)
                        .commit();
            } else {
                transaction
                        .hide(fromFragment)
                        .show(targetFragment)
                        .commit();
            }
        } else {
            if (targetFragment == null) {
                return null;
            }
            transaction
                    .add(containerViewId, targetFragment)
                    .commit();
        }
        return targetFragment;
    }

}
