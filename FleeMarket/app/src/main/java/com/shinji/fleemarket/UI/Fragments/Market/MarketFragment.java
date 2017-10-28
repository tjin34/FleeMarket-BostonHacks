package com.shinji.fleemarket.UI.Fragments.Market;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.shinji.fleemarket.Base.BaseFragment;
import com.shinji.fleemarket.R;
import com.shinji.fleemarket.UI.Fragments.Market.Adapter.ViewPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * Created by KimuraShin on 17/10/28.
 */

public class MarketFragment extends BaseFragment {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.RadioGroup)
    RadioGroup radioGroup;

    @BindView(R.id.llBuy)
    LinearLayout llBuy;

    @BindView(R.id.llSell)
    LinearLayout llSell;

    @BindView(R.id.llPost)
    LinearLayout llPost;

    private List<View> views;
    private ViewPagerAdapter viewPagerAdapter;
    private RadioButton radioButton;
    private int currentItem; // 当前页面
    private ScheduledExecutorService scheduledExecutorService;

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            // 设置当前页面
            viewPager.setCurrentItem(currentItem);
        };
    };

    private static final int[] pics = { R.drawable.selector_bg_wechat_button, R.drawable.selector_bg_wechat_button,
            R.drawable.selector_bg_wechat_button, R.drawable.selector_bg_wechat_button, R.drawable.selector_bg_wechat_button };

    private static final String[] picPath = { "http://imgsrc.baidu.com/forum/w%3D580/sign=71713a8b0e7b02080cc93fe952d8f25f/dc75c62a2834349b1c4c7cabcdea15ce36d3be2a.jpg",
            "http://imgsrc.baidu.com/forum/w%3D580/sign=6d5e7578d4160924dc25a213e406359b/cf22c8b44aed2e73507794028301a18b86d6fadf.jpg",
            "http://imgsrc.baidu.com/forum/w%3D580/sign=a50d5a1008f3d7ca0cf63f7ec21fbe3c/29fa1ef431adcbef4b266328a8af2edda3cc9f62.jpg",
            "http://imgsrc.baidu.com/forum/w%3D580/sign=b64b0730bd389b5038ffe05ab534e5f1/04475334970a304ea585bdd4d5c8a786c8175cd5.jpg",
            "http://imgsrc.baidu.com/forum/w%3D580/sign=bad2ae38cbfc1e17fdbf8c397a91f67c/f1a2433d269759eec41679e5b6fb43166d22df37.jpg"};

    @Override
    protected String getTAG() {
        return "MarketFragment";
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_market;
    }

    @Override
    public void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 每隔2秒钟切换一张图片
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPagerTask(), 10, 10, TimeUnit.SECONDS);
        // scheduleAtFixedRate(command, initialDelay, period, unit);
        // command：执行线程 initialDelay：初始化延时 period：前一次执行结束到下一次执行开始的间隔时间（间隔执行延迟时间）
        // unit：计时单位
    }

    // 切换图片
    private class ViewPagerTask implements Runnable {
        @Override
        public void run() {
            currentItem = (currentItem + 1) % pics.length;
            // 更新界面
            handler.obtainMessage().sendToTarget();
            // message对象sendToTarget()，handler对象sendMessage();
        }
    }

    RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkId) {
            switch (checkId) {
                case R.id.radio1:
                    viewPager.setCurrentItem(0);
                    currentItem = 0;
                    break;
                case R.id.radio2:
                    viewPager.setCurrentItem(1);
                    currentItem = 1;
                    break;
                case R.id.radio3:
                    viewPager.setCurrentItem(2);
                    currentItem = 2;
                    break;
                case R.id.radio4:
                    viewPager.setCurrentItem(3);
                    currentItem = 3;
                    break;
                case R.id.radio5:
                    viewPager.setCurrentItem(4);
                    currentItem = 4;
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

        radioGroup.setOnCheckedChangeListener(listener);
        views = new ArrayList<View>();

        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < picPath.length; i++) {
            ImageView iv = new ImageView(context);
            iv.setLayoutParams(mParams);
            Picasso.with(context).load(picPath[i]).error(pics[i]).into(iv);
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            views.add(iv);
        }

        viewPagerAdapter = new ViewPagerAdapter(views);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                radioButton = (RadioButton) radioGroup.getChildAt(position);
                radioButton.setChecked(true);
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });


        llBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        llSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        llPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}

