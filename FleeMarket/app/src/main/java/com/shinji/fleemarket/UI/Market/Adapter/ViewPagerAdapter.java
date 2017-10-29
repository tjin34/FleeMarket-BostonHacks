package com.shinji.fleemarket.UI.Market.Adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by KimuraShin on 17/6/21.
 */

public class ViewPagerAdapter extends PagerAdapter {

    //界面列表
    private List<View> views;

    public ViewPagerAdapter(List<View> views){
        this.views = views;
    }

    @Override
    public int getCount() {
        return views==null?0:views.size();
    }

    @Override
    public void destroyItem(View container, int position, Object arg2) {
        ((ViewPager)container).removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(views.get(position), 0);
        return views.get(position);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        /**
         * 设置具体需要填充的View对象
         */
        int i = position % views.size();
        container.addView(views.get(i));
        return views.get(i);
    }
}