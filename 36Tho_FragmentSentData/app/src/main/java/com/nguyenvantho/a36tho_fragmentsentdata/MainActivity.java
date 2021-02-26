package com.nguyenvantho.a36tho_fragmentsentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fragmentManager;
    Button btnSentDataToFragment;
    EditText edtActivity;
    FragmentTho fragmentTho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSentDataToFragment= this.<Button>findViewById(R.id.btnSentDataToFragment);
        edtActivity= this.<EditText>findViewById(R.id.edtActivity);
        btnSentDataToFragment.setOnClickListener(this);
        
        fragmentManager= getFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTho= new FragmentTho();
        Bundle bundle= new Bundle();
        bundle.putString("xinchao","1234");
        fragmentTho.setArguments(bundle);
        fragmentTransaction.add(R.id.LNActivity,fragmentTho);
        fragmentTransaction.commit();
    }
    @Override
    public void onClick(View v) {
        // truyền dữ liệu cho Fragment
        String data= edtActivity.getText().toString();Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT).show();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTho= new FragmentTho();
        Bundle bundle= new Bundle();
        bundle.putString("xinchao",data);
        fragmentTho.setArguments(bundle);
        fragmentTransaction.replace(R.id.LNActivity,fragmentTho);
        fragmentTransaction.commit(); }}