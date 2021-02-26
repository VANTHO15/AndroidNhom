package com.nguyenvantho.a38tho_sharedpredrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edHoTen,edLop;
    Button btnSave,btnGet;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edHoTen= this.<EditText>findViewById(R.id.edHoTen);
        edLop= this.<EditText>findViewById(R.id.edlop);
        btnGet= this.<Button>findViewById(R.id.btnGet);
        btnSave= this.<Button>findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this::onClick);
        btnGet.setOnClickListener(this::onClick);
        sharedPreferences= getSharedPreferences("thongtinhocsinh", Context.MODE_PRIVATE); }
    @Override
    public void onClick(View v) {
        int id= v.getId();
        switch (id) {
            case R.id.btnSave: {
                SharedPreferences.Editor editor= sharedPreferences.edit();
                String HoTen= edHoTen.getText().toString();
                String Lop= edLop.getText().toString();
                editor.putString("hoten",HoTen);
                editor.putString("lop",Lop);
                editor.commit();
                Toast.makeText(MainActivity.this,"Lưu thành công",Toast.LENGTH_SHORT).show();
                break; }
            case R.id.btnGet: {
                edHoTen.setText(sharedPreferences.getString("hoten",""));
                edLop.setText(sharedPreferences.getString("lop",""));
            } } }}