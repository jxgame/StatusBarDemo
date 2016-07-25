package com.example.macuser.statusbardemo.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.macuser.statusbardemo.R;
import com.example.macuser.statusbardemo.adapter.PersonalSongListAdapter;
import com.example.macuser.statusbardemo.adapter.PersonalViewPagerAdapter;
import com.example.macuser.statusbardemo.fragment.FragmentPersonalA;
import com.example.macuser.statusbardemo.fragment.FragmentPersonalB;
import com.example.macuser.statusbardemo.model.SongListModel;
import com.example.macuser.statusbardemo.view.ListViewInScrollView;
import com.example.macuser.statusbardemo.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    private List<Fragment> mFragmentDates;
    private FragmentPersonalA fragmentPersonalA;
    private FragmentPersonalB fragmentPersonalB;

    private PersonalViewPagerAdapter personalViewPagerAdapter;
    private PersonalSongListAdapter personalSongListAdapter;
    private ArrayList<SongListModel> listData;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_personal);
        ButterKnife.bind(this);
        initViews();
        initData();
    }

    private void initViews() {
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