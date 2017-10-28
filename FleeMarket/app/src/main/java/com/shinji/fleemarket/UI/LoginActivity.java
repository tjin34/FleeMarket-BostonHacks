package com.shinji.fleemarket.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shinji.fleemarket.Base.BaseActivity;
import com.shinji.fleemarket.R;

import butterknife.BindView;

/**
 * Created by KimuraShin on 17/8/13.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.tv_login)
    TextView tv_login;

    @BindView(R.id.ll_wechat)
    LinearLayout ll_wechat;

    @BindView(R.id.ll_qq)
    LinearLayout ll_qq;

    @BindView(R.id.tv_forgot)
    TextView tv_forgot;

    @Override
    protected String getTAG() {
        return this.toString();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initResAndListener() {
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "login", Toast.LENGTH_SHORT).show();
            }
        });

        ll_wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "wechat", Toast.LENGTH_SHORT).show();
            }
        });

        ll_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "qq", Toast.LENGTH_SHORT).show();
            }
        });

        tv_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "forgot", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
