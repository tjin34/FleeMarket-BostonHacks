package com.shinji.fleemarket.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Shin on 2017-6-22
 */

public abstract class BaseFragment extends Fragment {
    public abstract int getContentViewId();
    protected Context context;
    protected View mRootView;
    protected abstract String getTAG();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView =inflater.inflate(getContentViewId(),container,false);
        ButterKnife.bind(this,mRootView);//绑定framgent
        this.context = getActivity();
        initAllMembersView(savedInstanceState);
        initResAndListener();

        return mRootView;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    protected abstract void initAllMembersView(Bundle savedInstanceState);

    //空方法 规定子类 初始化监听器 和定义显示资源 的步骤
    protected void initResAndListener() {

    }

    /**
     * 获取statusbar高度
     * @return result
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
