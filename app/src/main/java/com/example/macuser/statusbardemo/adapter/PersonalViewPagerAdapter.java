package com.example.macuser.statusbardemo.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.macuser.statusbardemo.R;
import com.example.macuser.statusbardemo.view.PagerSlidingTabStrip;

import java.util.List;

/**
 * Created by macuser on 16/7/22.
 **/
public class PersonalViewPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {

    private List<Fragment> mFragmentDates;

    public PersonalViewPagerAdapter(FragmentManager fm, List<Fragment> mFragmentDates) {
        super(fm);
        this.mFragmentDates = mFragmentDates;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentDates.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentDates.size();
    }

    @Override
    public int getPageIconResId(int position) {
        return R.drawable.tab_select_dot_small;
    }

    @Override
    public int getUnselectPageIconResId(int position) {
        return R.drawable.tab_unselect_dot_small;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }
}