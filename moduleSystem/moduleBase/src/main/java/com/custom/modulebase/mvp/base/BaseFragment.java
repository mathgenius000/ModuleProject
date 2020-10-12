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
public abstract class BaseFragment<M extends Model, V extends View, P extends BasePresenter> extends BaseMvpFragment<M, V, P> {


    protected Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

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
