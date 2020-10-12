package com.custom.modulebase.mvp.base;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * Author：DownieM
 * Date：2018.11.16
 *
 * @param <M>
 * @param <V>
 * @param <P>
 */
public abstract class BaseAcitivty<M extends Model, V extends View, P extends BasePresenter> extends BaseMvpActivity<M, V, P> {

    /**
     * 切换当前的fragment
     *
     * @param fromFragment    当前fragment
     * @param targetFragment  要加载的fragment
     * @param containerViewId 布局id
     * @return 要加载的fragment
     */
    protected Fragment switchCurrentFragment(Fragment fromFragment, Fragment targetFragment, @IdRes int containerViewId) {
        FragmentTransaction transaction = getSupportFragmentManager()
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
