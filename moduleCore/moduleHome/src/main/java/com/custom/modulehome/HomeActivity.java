package com.custom.modulehome;

import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.custom.modulebase.base.BaseActivity;
import com.custom.moduleroute.RouteHomePath;
import com.custom.moduleroute.RouteUtil;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;

@Route(path = RouteHomePath.HOME_ACTIVITY)
public class HomeActivity extends BaseActivity {

    @BindView(R2.id.ll_main)
    FrameLayout llMain;

    @BindView(R2.id.rg_tab)
    RadioGroup radioGroup;

    @BindView(R2.id.rb_index)
    RadioButton rbIndex;

    @BindView(R2.id.rb_news)
    RadioButton rbNews;

    @BindView(R2.id.rb_region)
    RadioButton rbRegion;

    @BindView(R2.id.rb_user)
    RadioButton rbUser;

    private FragmentManager supportFragmentManager;
    public static final String TAG_FRAGMENT_INDEX="index";
    public static final String TAG_FRAGMENT_NEWS="news";
    public static final String TAG_FRAGMENT_REGION="region";
    public static final String TAG_FRAGMENT_USER="user";
    private Fragment mIndexFragment;
    private Fragment mNewsFragment;
    private Fragment mRegionFragment;
    private Fragment mUserFragment;
    private Fragment curFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        supportFragmentManager = getSupportFragmentManager();
        // 底部tab切换监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switchTab(checkedId);
            }
        });
        switchTab(R.id.rb_index);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    private void switchTab(int checkedId) {
        FragmentTransaction ft = supportFragmentManager.beginTransaction();
        hideAllFragment(ft);
        if (checkedId == R.id.rb_index) {
            mIndexFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_INDEX);
            if (mIndexFragment == null) {
                mIndexFragment = RouteUtil.getHomeIndexFragment();
                if (mIndexFragment != null) {
                    ft.add(R.id.ll_main, mIndexFragment, TAG_FRAGMENT_INDEX);
                }
            }
            curFragment = mIndexFragment;
        } else if (checkedId == R.id.rb_news) {
            mNewsFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_NEWS);
            if (mNewsFragment == null) {
                mNewsFragment = RouteUtil.getHomeNewsFragment();
                if (mNewsFragment != null) {
                    ft.add(R.id.ll_main, mNewsFragment, TAG_FRAGMENT_NEWS);
                }
            }
            curFragment = mNewsFragment;
        } else if (checkedId == R.id.rb_region) {
            mRegionFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_REGION);
            if (mRegionFragment == null) {
                mRegionFragment = RouteUtil.getHomeRegionFragment();
                if (mRegionFragment != null) {
                    ft.add(R.id.ll_main, mRegionFragment, TAG_FRAGMENT_REGION);
                }
            }
            curFragment = mRegionFragment;
        } else if (checkedId == R.id.rb_user) {
            mUserFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_USER);
            if (mUserFragment == null) {
                mUserFragment = RouteUtil.getHomeUserFragment();
                if (mUserFragment != null) {
                    ft.add(R.id.ll_main, mUserFragment, TAG_FRAGMENT_USER);
                }
            }
            curFragment = mUserFragment;
        }
        if (curFragment != null) {
            ft.show(curFragment).commit();
        }
    }

    private void hideAllFragment(FragmentTransaction ft) {
        Fragment fragment;
        fragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_INDEX);
        if (fragment != null) {
            ft.hide(fragment);
        }
        fragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_NEWS);
        if (fragment != null) {
            ft.hide(fragment);
        }
        fragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_REGION);
        if (fragment != null) {
            ft.hide(fragment);
        }
        fragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_USER);
        if (fragment != null) {
            ft.hide(fragment);
        }
    }
}