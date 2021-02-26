package com.nguyenvantho.a36tho_fragmentsentdata;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FragmentTho extends Fragment {
    TextView txtGetDataFromFragment,txtGetDataFromActivity;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragmenttho_layout,container,false);

        // gọi getActivity() để truy cập đến View trong Activity
        txtGetDataFromFragment= getActivity().<TextView>findViewById(R.id.txtGetDataFromFragment);
        txtGetDataFromActivity= view.<TextView>findViewById(R.id.txtGetDataFromActivity);
        txtGetDataFromFragment.setText("Văn Thọ");

        // nhận dữ liệu từ Activity
        Bundle bundle= getArguments();
        if (bundle!=null)
        {
            String data= bundle.getString("xinchao");
            txtGetDataFromActivity.setText(data);
        }

        return view;
    }
}
