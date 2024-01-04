package com.company.iformationnbook.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.company.iformationnbook.R;
import com.company.iformationnbook.adaptors.ViewPagerAdapterCountries;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CountriesActivity extends AppCompatActivity {
    private TabLayout tabLayoutUK;
    private ViewPager2 viewPagerUK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        tabLayoutUK=findViewById(R.id.tabLayoutUK);
        viewPagerUK=findViewById(R.id.viewPagerUK);

        ViewPagerAdapterCountries adapter=new ViewPagerAdapterCountries(getSupportFragmentManager(),getLifecycle());
        viewPagerUK.setAdapter(adapter);

        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayoutUK, viewPagerUK, true,
                true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){

                    case 0:
                        tab.setText("United Kingdom");
                        break;

                    case 1:
                        tab.setText("France");
                        break;
                }
            }
        });

        tabLayoutMediator.attach();
    }
}