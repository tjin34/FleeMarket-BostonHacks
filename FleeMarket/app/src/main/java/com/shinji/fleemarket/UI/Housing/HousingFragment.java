package com.shinji.fleemarket.UI.Housing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shinji.fleemarket.Base.BaseFragment;
import com.shinji.fleemarket.R;

/**
 * Created by KimuraShin on 17/10/28.
 */

public class HousingFragment extends BaseFragment {

    @Override
    protected String getTAG() {
        return "HousingFragment";
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_housing;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }
}
