package com.example.huangdouya.mymusicapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.example.huangdouya.mymusicapplication.control.main.NetFragment;

import java.util.List;

/**
 * Created by huangdouya on 2017/8/2.
 */

public class NetFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment>fragments;

    public NetFragmentAdapter(FragmentManager fm,List<Fragment>fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
}
