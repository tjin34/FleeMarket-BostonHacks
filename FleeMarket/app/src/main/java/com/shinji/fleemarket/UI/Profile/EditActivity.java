package com.shinji.fleemarket.UI.Profile;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shinji.fleemarket.Base.BaseActivity;
import com.shinji.fleemarket.R;

import butterknife.BindView;

/**
 * Created by KimuraShin on 17/10/28.
 */

public class EditActivity extends BaseActivity {

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.ivBack)
    ImageView ivBack;



    @BindView(R.id.llEditString)
    LinearLayout llEditString;

    @BindView(R.id.etInput)
    EditText etInput;



    @BindView(R.id.llEditPhone)
    LinearLayout llEditPhone;

    @BindView(R.id.etPhone)
    EditText etPhone;




    @BindView(R.id.llEditAddress)
    LinearLayout llEditAddress;

    @BindView(R.id.etAddress1)
    EditText etAddress1;

    @BindView(R.id.etAddress2)
    EditText etAddress2;

    @BindView(R.id.etState)
    EditText etState;

    @BindView(R.id.etPostal)
    EditText etPostal;


    private int editType;

    @Override
    protected String getTAG() {
        return "EditActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_info;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        editType = (int) getIntent().getIntExtra("Type", 0);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initResAndListener() {
        switch (editType) {
            case 0:
                tvTitle.setText(getString(R.string.real_name));
                llEditString.setVisibility(View.VISIBLE);
                etInput.setHint("");
                break;
            case 1:
                tvTitle.setText(getString(R.string.phone));
                llEditPhone.setVisibility(View.VISIBLE);
                etPhone.setText("");
                break;
            case 2:
                tvTitle.setText(getString(R.string.real_name));
                llEditString.setVisibility(View.VISIBLE);
                etInput.setHint("");
                break;
            case 3:
                tvTitle.setText(getString(R.string.my_address));
                llEditAddress.setVisibility(View.VISIBLE);
                etAddress1.setHint("");
                etAddress2.setHint("");
                etState.setHint("");
                etPostal.setHint("");
                break;



        }
    }
}
