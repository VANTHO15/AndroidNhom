package com.nguyenvantho.a35tho_fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnChange;
    int i=0;
    FragmentManager fragmentManager;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChange= this.<Button>findViewById(R.id.btnChange);
        btnChange.setOnClickListener(this);;
//        FragmentManager fragmentManager= getFragmentManager();
//        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
//        DemoFragment1 demoFragment1= new DemoFragment1();
//        fragmentTransaction.add(R.id.lnActivity, demoFragment1);
//        fragmentTransaction.commit();
         fragmentManager= getFragmentManager();
    }
    @Override
    public void onClick(View v) {
        i++;
        if (i%2==0)
            fragment= new DemoFragment1();
        else
            fragment= new DemoFragment2();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.lnActivity, fragment);
        fragmentTransaction.commit();
    }
}