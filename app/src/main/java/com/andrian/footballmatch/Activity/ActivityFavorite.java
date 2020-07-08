package com.andrian.footballmatch.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.andrian.footballmatch.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityFavorite extends AppCompatActivity {

    private BottomNavigationView BottomNav;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Football League");
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(0xFFFFFFFF);

        BottomNav = findViewById(R.id.bottom_navigation);

        BottomNav.setSelectedItemId(R.id.nav_Favorite);

        BottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_teams:
                        startActivity(new Intent(getApplicationContext(),ActivityTeam.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_Favorite:
                        return true;
                    case R.id.nav_match:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}
