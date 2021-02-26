package com.nguyenvantho.drawermenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBar actionBar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= this.<Toolbar>findViewById(R.id.toolbar);
        drawerLayout= this.<DrawerLayout>findViewById(R.id.drawer_layout);
        navigationView= this.<NavigationView>findViewById(R.id.navigation_view);

         setSupportActionBar(toolbar);

        actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.open,R.string.close);
        drawerToggle.syncState();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager= getSupportFragmentManager();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int i=item.getItemId();
        switch (i)
        {
            case R.id.so1:
            {
                FragmentTransaction transaction= fragmentManager.beginTransaction();

                FramentSo1_activity framentSo1_activity= new FramentSo1_activity();
                transaction.replace(R.id.content_layout,framentSo1_activity);
                transaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                ; break;
            }
            case R.id.so2:
            {
                FragmentTransaction transaction1= fragmentManager.beginTransaction();

                FramentSo2_activity framentSo2_activity= new FramentSo2_activity();
                transaction1.replace(R.id.content_layout,framentSo2_activity);
                transaction1.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case R.id.so3:
            {
                FragmentTransaction transaction2= fragmentManager.beginTransaction();

                FramentSo3_activity framentSo3_activity = new FramentSo3_activity();
                transaction2.replace(R.id.content_layout,framentSo3_activity);
                transaction2.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }

            case R.id.so5:
            {
                break;
            }
            case R.id.so6:
            {

            }
        }
        return true;
    }
}