package com.custom.modulebase.mvp.base;

/**
 * Author：CanneyLin
 * Date：2018.11.16
 */
public interface View {

//    void showToast(String info);
//
//    void showProgress();
//
//    void showPromptDialog(String msg);

    void loadDataFailed(String msg);

    void loadMoreDataFailed(String msg);

}
