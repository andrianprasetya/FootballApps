package com.andrian.footballmatch.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.andrian.footballmatch.Fragment.LastMatchFragment;
import com.andrian.footballmatch.Fragment.NextMatchFragment;
import com.andrian.footballmatch.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private LastMatchFragment lastmatchFragment;
    private NextMatchFragment nextmatchFragment;
    private BottomNavigationView BottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Football League");
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(0xFFFFFFFF);


        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        BottomNav = findViewById(R.id.bottom_navigation);

        BottomNav.setSelectedItemId(R.id.nav_match);

        BottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_teams:
                        startActivity(new Intent(MainActivity.this,ActivityTeam.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_match:
                        return true;
                    case R.id.nav_Favorite:
                        startActivity(new Intent(getApplicationContext(),ActivityFavorite.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        LastMatchFragment lastmatch = new LastMatchFragment();
        NextMatchFragment nextmatch = new NextMatchFragment();



        ViewPagerAdapter viewpager = new ViewPagerAdapter(getSupportFragmentManager(),0);


        viewpager.addFragment(lastmatch, "LastMatch" );
        viewpager.addFragment(nextmatch, "NextMatch" );
        viewPager.setAdapter(viewpager);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_lastmatch);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_nextmatch_revisi2);

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm ,int behavior) {
            super(fm,behavior);
        }

        public void addFragment(Fragment fragment , String Title){
            fragments.add(fragment);
            fragmentTitle.add(Title);

        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }
}
