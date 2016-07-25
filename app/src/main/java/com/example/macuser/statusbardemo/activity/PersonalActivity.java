package com.example.macuser.statusbardemo.activity;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.macuser.statusbardemo.R;
import com.example.macuser.statusbardemo.adapter.PersonalSongListAdapter;
import com.example.macuser.statusbardemo.adapter.PersonalViewPagerAdapter;
import com.example.macuser.statusbardemo.fragment.FragmentPersonalA;
import com.example.macuser.statusbardemo.fragment.FragmentPersonalB;
import com.example.macuser.statusbardemo.model.SongListModel;
import com.example.macuser.statusbardemo.view.AlphaTitleScrollView;
import com.example.macuser.statusbardemo.view.ListViewInScrollView;
import com.example.macuser.statusbardemo.view.PagerSlidingTabStrip;
import com.example.macuser.statusbardemo.view.StatusBarCompat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

;

/**
 * Created by macuser on 16/7/22.
 **/
public class PersonalActivity extends AppCompatActivity {


    @BindView(R.id.activity_personal_vp_background)
    ImageView activityPersonalVpBackground;
    @BindView(R.id.activity_personal_vp)
    ViewPager activityPersonalVp;
    @BindView(R.id.activity_personal_psts)
    PagerSlidingTabStrip activityPersonalPsts;
    @BindView(R.id.activity_personal_lv)
    ListViewInScrollView activityPersonalLv;
    @BindView(R.id.activity_personal_alpha_scroll)
    AlphaTitleScrollView activityPersonalAlphaScroll;
    @BindView(R.id.activity_personal_head)
    RelativeLayout activityPersonalHead;
    private List<Fragment> mFragmentDates;
    private FragmentPersonalA fragmentPersonalA;
    private FragmentPersonalB fragmentPersonalB;

    private PersonalViewPagerAdapter personalViewPagerAdapter;
    private PersonalSongListAdapter personalSongListAdapter;
    private ArrayList<SongListModel> listData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        ButterKnife.bind(this);
        StatusBarCompat.initStatus(this);
        initViews();
        initData();
        setlisteners();
    }

    private void setlisteners() {
        activityPersonalAlphaScroll.setOnAlphaTitleScrollChangedListener(new AlphaTitleScrollView.OnAlphaTitleScrollChangedListener() {
            @Override
            public void onAlphaTitleScroll(int alpha, float alphaPercent) {

            }
        });
        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        activityPersonalVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position % 2 == 0) {
                    activityPersonalVp.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, 0,
                            getResources().getColor(R.color.viewpager_background)));
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initViews() {
        activityPersonalAlphaScroll.setTitleAndHead(activityPersonalHead, activityPersonalVpBackground);
        activityPersonalHead.getBackground().setAlpha(0);
        mFragmentDates = new ArrayList<>();
        fragmentPersonalA = new FragmentPersonalA();
        fragmentPersonalB = new FragmentPersonalB();
        mFragmentDates.add(fragmentPersonalA);
        mFragmentDates.add(fragmentPersonalB);
        personalViewPagerAdapter = new PersonalViewPagerAdapter(getSupportFragmentManager(), mFragmentDates);
        activityPersonalVp.setAdapter(personalViewPagerAdapter);
        activityPersonalPsts.setShouldExpand(true);
        activityPersonalPsts.setViewPager(activityPersonalVp);
        activityPersonalVp.setCurrentItem(0, false);
        listData = new ArrayList<>();
        personalSongListAdapter = new PersonalSongListAdapter(PersonalActivity.this, listData);
        activityPersonalLv.setAdapter(personalSongListAdapter);
        activityPersonalAlphaScroll.smoothScrollTo(0, 0);
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            SongListModel model = new SongListModel();
            model.setImgurl("");
            model.setListname("k-pop" + i);
            model.setPlaycount("歌单" + i);
            listData.add(model);

        }
        personalSongListAdapter.notifyDataSetChanged();
    }

}