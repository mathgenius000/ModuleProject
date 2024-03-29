package com.custom.modulebase.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author：DownieM
 * Date：2020.10.14
 *
 * @param <M>
 * @param <V>
 * @param <P>
 */
public abstract class BaseMvpFragment<M extends Model, V extends View, P extends BasePresenter> extends Fragment implements BaseMvp<M, V, P> {


    protected Context mContext;

    private Unbinder butterKnifeBind;

    protected P presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        //创建Presenter
        presenter = createPresenter();
        if (null != presenter) {
            //将Model层注册到Presenter中
            presenter.registerModel(createModel());
            //将View层注册到Presenter中
            presenter.registerView(createView());
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        android.view.View view = android.view.View.inflate(getActivity(), getLayoutId(), null);
        butterKnifeBind = ButterKnife.bind(this, view);
        if (null != savedInstanceState) {
            initBundle(savedInstanceState);
        }
        initView(view);
        initListener();
        initData();
        return view;
    }

    protected abstract void initBundle(Bundle savedInstanceState);

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initView(android.view.View view);

    protected abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (butterKnifeBind != Unbinder.EMPTY) {
            butterKnifeBind.unbind();
            butterKnifeBind = null;
        }
        mContext = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (null != presenter) {
            presenter.destroy();
        }
    }

}
