package com.shinji.fleemarket.UI.Profile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shinji.fleemarket.Base.BaseActivity;
import com.shinji.fleemarket.R;

import butterknife.BindView;

/**
 * Created by KimuraShin on 17/10/28.
 */

public class ProfileActivity extends BaseActivity {

    @BindView(R.id.ivBack)
    ImageView ivBack;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @Override
    protected String getTAG() {
        return "ProfileActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_profile;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initResAndListener() {
        tvTitle.setText("Self Profile");
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}