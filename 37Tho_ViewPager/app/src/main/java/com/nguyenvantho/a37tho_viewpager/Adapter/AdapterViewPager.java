package com.nguyenvantho.a37tho_viewpager.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class AdapterViewPager extends FragmentStatePagerAdapter {
   List<Fragment> fragments;

    public AdapterViewPager(@NonNull FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments= fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
