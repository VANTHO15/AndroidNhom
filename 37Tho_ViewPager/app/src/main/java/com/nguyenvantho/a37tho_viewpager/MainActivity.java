package com.nguyenvantho.a37tho_viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.nguyenvantho.a37tho_viewpager.Adapter.AdapterViewPager;
import com.nguyenvantho.a37tho_viewpager.Fragment.Fragment1;
import com.nguyenvantho.a37tho_viewpager.Fragment.Fragment2;
import com.nguyenvantho.a37tho_viewpager.Fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager= this.<ViewPager>findViewById(R.id.viewpager);

        fragments= new ArrayList<Fragment>();
        Fragment1 fragment1= new Fragment1();
        Fragment2 fragment2= new Fragment2();
        Fragment3 fragment3= new Fragment3();

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        AdapterViewPager adapterViewPager= new AdapterViewPager(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapterViewPager);
    }
}