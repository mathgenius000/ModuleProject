package com.custom.modulebase.mvp.base;

/**
 * Author：CanneyLin
 * Date：2018.11.16
 * @param <M> model
 * @param <V> view
 */
public interface Presenter<M extends Model, V extends View> {

    /**
     * 注册Model层
     *
     * @param model
     */
    void registerModel(M model);

    /**
     * 注册View层
     *
     * @param view
     */
    void registerView(V view);

    /**
     * 获取View
     *
     * @return
     */
    V getView();

    /**
     * 销毁动作（如Acitivity、Fragment的卸载）
     */
    void destroy();
}
