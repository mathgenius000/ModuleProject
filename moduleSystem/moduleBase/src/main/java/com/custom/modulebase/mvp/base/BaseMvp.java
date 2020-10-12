package com.custom.modulebase.mvp.base;

/**
 * Author：CanneyLin
 * Date：2018.11.16
 *
 * @param <M>
 * @param <V>
 * @param <P>
 */
public interface BaseMvp<M extends Model, V extends View, P extends BasePresenter> {

    M createModel();

    V createView();

    P createPresenter();
}
