package com.shinji.fleemarket;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shinji.fleemarket.Base.BaseActivity;
import com.shinji.fleemarket.UI.Chat.ChatFragment;
import com.shinji.fleemarket.UI.Housing.HousingFragment;
import com.shinji.fleemarket.UI.Market.MarketFragment;
import com.shinji.fleemarket.UI.Profile.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.frameContent)
    FrameLayout frameContent;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    /* LinearLayouts "Buttons" */

    @BindView(R.id.llHousing)
    LinearLayout llHousing;

    @BindView(R.id.llMarket)
    LinearLayout llMarket;

    @BindView(R.id.llChat)
    LinearLayout llChat;

    @BindView(R.id.llProfile)
    LinearLayout llProfile;

    /* ImageViews */

    @BindView(R.id.ivHousing)
    ImageView ivHousing;

    @BindView(R.id.ivMarket)
    ImageView ivMarket;

    @BindView(R.id.ivChat)
    ImageView ivChat;

    @BindView(R.id.ivProfile)
    ImageView ivProfile;



    private List<Fragment> fragmentContent;
    private MarketFragment marketFragment;
    private HousingFragment housingFragment;
    private ChatFragment chatFragment;
    private ProfileFragment profileFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment currentContent = new Fragment();

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

        initFragment();
        initTabLayout();
    }

    @Override
    protected void initResAndListener() {

    }

    private void initFragment() {
        fragmentContent = new ArrayList<>();
        marketFragment = new MarketFragment();
        housingFragment = new HousingFragment();
        chatFragment = new ChatFragment();
        profileFragment = new ProfileFragment();
        fragmentContent.add(marketFragment);
        fragmentContent.add(housingFragment);
        fragmentContent.add(chatFragment);
        fragmentContent.add(profileFragment);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, fragmentContent.get(0));
        currentContent = fragmentContent.get(0);
        tvTitle.setText(getString(R.string.market));
        fragmentTransaction.commit();
    }

    private void initTabLayout() {
        /** 底部导航栏的ImageView集合 **/
        final ImageView[] arrImageView = {ivMarket, ivHousing, ivChat, ivProfile};

        List<View> tapBar = new ArrayList<>();
        tapBar.add(llMarket);
        tapBar.add(llHousing);
        tapBar.add(llChat);
        tapBar.add(llProfile);

        for (int i = 0; i < 4; i++) {
            tapBar.get(i).setTag(i);
            tapBar.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    switch (position) {
                        case 0: //首页
                            switchContent(currentContent, fragmentContent.get(position));
                            tvTitle.setText(getString(R.string.market));
                            break;
                        case 1: //消息
                            switchContent(currentContent, fragmentContent.get(position));
                            tvTitle.setText(getString(R.string.housing));
                            break;
                        case 2: //发现
                            switchContent(currentContent, fragmentContent.get(position));
                            tvTitle.setText(getString(R.string.chat));
                            break;
                        case 3: //我的
                            switchContent(currentContent, fragmentContent.get(position));
                            tvTitle.setText(getString(R.string.profile));
                            break;
                    }
                    for (int j = 0; j < 4; j++) {
                        arrImageView[j].setEnabled(true);
                    }
                    arrImageView[position].setEnabled(false);
                }
            });
        }
        arrImageView[0].setEnabled(false);
    }

    /**
     * Switch Fragment
     *
     * @param from
     * @param to
     */
    public void switchContent(Fragment from, Fragment to) {
        if (currentContent != to) {
            currentContent = to;
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (!to.isAdded()) {
                transaction.hide(from).add(R.id.frameContent, to).commit();
            } else {
                transaction.hide(from).show(to).commit();
            }
        }
        currentContent = to;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        fragmentManager = null;
        fragmentTransaction = null;
    }
}
