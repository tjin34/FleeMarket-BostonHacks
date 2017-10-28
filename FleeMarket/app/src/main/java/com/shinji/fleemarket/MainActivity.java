package com.shinji.fleemarket;

import android.os.Bundle;

import com.shinji.fleemarket.Base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected String getTAG() {
        return "MainActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
