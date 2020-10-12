package com.custom.modulebase.mvp.base;


import java.lang.ref.WeakReference;

/**
 * Author：CanneyLin
 * Date：2018.11.16
 *
 * @param <M> model
 * @param <V> view
 */
public abstract class BasePresenter<M extends Model, V extends View> implements Presenter<M, V> {

    /**
     * 使用弱引用防止内存泄露
     */
    private WeakReference<V> wrf;
    protected M model;

    @Override
    public void registerModel(M model) {
        this.model = model;
    }

    @Override
    public void registerView(V view) {
        this.wrf = new WeakReference<V>(view);
    }

    @Override
    public V getView() {
        return wrf == null ? null : wrf.get();
    }

    /**
     * 在Acitivity或Fragment卸载时调用View结束的方法
     */
    @Override
    public void destroy() {
        if (null != wrf) {
            wrf.clear();
            wrf = null;
        }
        onViewDestroy();
    }

    protected abstract void onViewDestroy();
}
