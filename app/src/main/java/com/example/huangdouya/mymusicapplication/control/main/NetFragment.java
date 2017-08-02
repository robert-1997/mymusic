package com.example.huangdouya.mymusicapplication.control.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TableLayout;

import com.example.huangdouya.mymusicapplication.R;
import com.example.huangdouya.mymusicapplication.adapter.NetFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjb on 2017/8/2.
 */

public class NetFragment extends Fragment {

    private List<Fragment>list;
    private ViewPager viewPager;
    private TabLayout tab;
    private NetFragmentAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_net,null);

        viewPager = (ViewPager) view.findViewById(R.id.vpager_net);
        list = new ArrayList<>();

        adapter = new NetFragmentAdapter(getActivity().getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        tab = (TabLayout)view.findViewById(R.id.net_tab);
        tab.setupWithViewPager(viewPager);
        tab.setTabMode(TabLayout.MODE_FIXED);
        return view;
    }
}
