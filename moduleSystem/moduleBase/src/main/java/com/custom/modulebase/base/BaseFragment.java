package com.custom.modulebase.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author：CanneyLin
 * Date：2018.11.16
 */
public abstract class BaseFragment extends Fragment {


    protected Context mContext;
    private Unbinder butterKnifeBind;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), getLayoutId(), null);
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

    protected abstract void initView(View view);

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

}
