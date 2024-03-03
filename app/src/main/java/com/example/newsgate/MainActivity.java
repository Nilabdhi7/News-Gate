package com.example.newsgate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar nToolbar;
   TabLayout tabLayout;
    TabItem nHome,nSports,nHealth,nScience,nEntertainment,nTechnology,nBusiness;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    String api = "456c3c4c97ad496296477917f3b9f1cd";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(nToolbar);

        nHome = findViewById(R.id.home);
        nSports = findViewById(R.id.sports);
        nHealth = findViewById(R.id.health);
        nScience = findViewById(R.id.science);
        nEntertainment = findViewById(R.id.entertainment);
        nTechnology = findViewById(R.id.technology);
        nBusiness = findViewById(R.id.business);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.fragmentContainer);


        pagerAdapter = new com.example.newsgate.PagerAdapter(getSupportFragmentManager(),7);
        viewPager.setAdapter(pagerAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3 || tab.getPosition()==4 || tab.getPosition()==5 || tab.getPosition()==6){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }

}