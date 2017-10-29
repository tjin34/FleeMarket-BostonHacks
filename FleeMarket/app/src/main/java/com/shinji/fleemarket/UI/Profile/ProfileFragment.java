package com.shinji.fleemarket.UI.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import com.shinji.fleemarket.Base.BaseFragment;
import com.shinji.fleemarket.R;

import butterknife.BindView;

/**
 * Created by KimuraShin on 17/10/28.
 */

public class ProfileFragment extends BaseFragment {

    @BindView(R.id.rlProfile)
    RelativeLayout rlProfile;

    @Override
    protected String getTAG() {
        return "ProfileFragment";
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_profile;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        rlProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
