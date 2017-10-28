package com.shinji.fleemarket.UI;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shinji.fleemarket.Base.BaseActivity;
import com.shinji.fleemarket.R;

import butterknife.BindView;

/**
 * Created by KimuraShin on 17/8/13.
 */

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.rootView)
    RelativeLayout rootView;

    @BindView(R.id.iv_back)
    ImageView iv_back;

    @BindView(R.id.welcomeMsg)
    LinearLayout welcomeMsg;

    @BindView(R.id.welcome)
    TextView welcome;

    @BindView(R.id.pressAny)
    TextView pressAny;

    @BindView(R.id.login)
    LinearLayout ll_login;

    private Animation disapper1000, disapper500, loginUp, loginDown, blink, appear;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected String getTAG() {
        return this.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        disapper1000 = AnimationUtils.loadAnimation(mContext, R.anim.alpha_disapper_1000);
        disapper500 = AnimationUtils.loadAnimation(mContext, R.anim.alpha_disapper_500);
        blink = AnimationUtils.loadAnimation(mContext, R.anim.blink);
        loginUp = AnimationUtils.loadAnimation(mContext, R.anim.translate_up_from100p_to0p);
        loginDown = AnimationUtils.loadAnimation(mContext, R.anim.translate_down_from0p_to100p);
        appear = AnimationUtils.loadAnimation(mContext, R.anim.alpha_appear_500);

        setAnimationListeners();

        pressAny.startAnimation(blink);
    }

    @Override
    protected void initResAndListener() {
        setRootViewClick();

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_login.startAnimation(loginDown);
            }
        });
    }


    private void setRootViewClick(){
        rootView.setClickable(true);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcomeMsg.startAnimation(disapper1000);
            }
        });
    }

    private void setAnimationListeners() {
        disapper1000.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                welcomeMsg.setVisibility(View.GONE);
                ll_login.setVisibility(View.VISIBLE);
                ll_login.startAnimation(loginUp);
                iv_back.setVisibility(View.VISIBLE);
                iv_back.startAnimation(appear);
                rootView.setClickable(false);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        loginUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        loginDown.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                iv_back.startAnimation(disapper500);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ll_login.setVisibility(View.GONE);
                welcomeMsg.setVisibility(View.VISIBLE);
                welcomeMsg.startAnimation(appear);
                pressAny.startAnimation(blink);
                setRootViewClick();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        disapper500.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv_back.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
