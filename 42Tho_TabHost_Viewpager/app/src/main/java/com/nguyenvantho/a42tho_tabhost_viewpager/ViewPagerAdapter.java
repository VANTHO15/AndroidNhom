package com.nguyenvantho.a42tho_tabhost_viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nguyenvantho.a42tho_tabhost_viewpager.Fragment.Fragment1;
import com.nguyenvantho.a42tho_tabhost_viewpager.Fragment.Fragment2;
import com.nguyenvantho.a42tho_tabhost_viewpager.Fragment.Fragment3;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
            {
                Fragment1 fragment1= new Fragment1();
                return fragment1;
            }
            case 1:
            {
                Fragment2 fragment2= new Fragment2();
                return fragment2;
            }
            case 2:
            {
                Fragment3 fragment3= new Fragment3();
                return fragment3;
            }
            default: return  null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
