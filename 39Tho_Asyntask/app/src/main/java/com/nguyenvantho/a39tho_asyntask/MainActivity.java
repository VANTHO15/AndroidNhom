package com.nguyenvantho.a39tho_asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    TextView txtText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtText= this.<TextView>findViewById(R.id.txt);

        DemoAsyntask demoAsyntask= new DemoAsyntask();
        demoAsyntask.execute(10,20,30);
        //  String x=demoAsyntask.get();   sẽ trả ra cái result của onPostExecute
    }
    public class DemoAsyntask extends AsyncTask<Integer,Integer,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtText.setText("Asyntask đang chạy"); }
        @Override   // worker thread
        protected String doInBackground(Integer... params) {
            int nhanmotsotruyenvao= params[0];  // params[0] là lấy 10, params1 lấy 20....
            for (int i=0;i<nhanmotsotruyenvao;i++) {
                publishProgress(i);
            }
            String result="Tham số truyền từ DoInBackgroud";
            return result; }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int giatrinhantoDoin=values[0];
            txtText.setText(String.valueOf(giatrinhantoDoin));
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show(); }
    }
}