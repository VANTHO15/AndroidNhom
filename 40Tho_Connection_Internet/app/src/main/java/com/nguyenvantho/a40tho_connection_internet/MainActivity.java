package com.nguyenvantho.a40tho_connection_internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgAnh;
    Button btnDownload;
    Bitmap bitmap;
    InputStream inputStream;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAnh= this.<ImageView>findViewById(R.id.imgAnh);
        btnDownload= this.<Button>findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(this);
    }
    private  boolean KiemTraKetNoi()
    {
        ConnectivityManager connectivityManager= (ConnectivityManager)
                MainActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo= connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
        {
            return true;
        }
        return false;
    }
    public void TaiHinhAnh() throws IOException {
        if (KiemTraKetNoi()==true)
        {
            String link="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQOqNg0KJovizlj5kOLgsNakj-UGWS6YAXPA&usqp=CAU";
            DownloadHinhAnh downloadHinhAnh= new DownloadHinhAnh();
            downloadHinhAnh.execute(link);
        }
        else
        {
            Toast.makeText(MainActivity.this,"Bạn chưa kết nối mạng",Toast.LENGTH_SHORT).show();
        }

    }

    public class DownloadHinhAnh extends AsyncTask<String,Void,Bitmap>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Đang doanlod...",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {

            URL url= null;
            try {
                url = new URL(params[0]);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(10000);
                // httpURLConnection.setRequestMethod("post");
                httpURLConnection.connect();
                int status=httpURLConnection.getResponseCode();
                if (status==HttpURLConnection.HTTP_OK)
                {
                    inputStream= httpURLConnection.getInputStream();
                    bitmap= BitmapFactory.decodeStream(inputStream);

                }

                httpURLConnection.disconnect();
                inputStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            imgAnh.setImageBitmap(result);
        }
    }
    @Override
    public void onClick(View v) {
        i++;
        if (i%2==0)
        {
            try {
                TaiHinhAnh();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            imgAnh.setImageBitmap(null);
        }

    }
}