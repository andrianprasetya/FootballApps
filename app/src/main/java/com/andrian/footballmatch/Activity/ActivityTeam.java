package com.andrian.footballmatch.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andrian.footballmatch.Adapter.TeamAdapter;
import com.andrian.footballmatch.Model.TeamModel;
import com.andrian.footballmatch.R;
import com.andrian.footballmatch.RestClass.RestFootball;
import com.andrian.footballmatch.RetrofitGson;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivityTeam extends AppCompatActivity {

    private BottomNavigationView BottomNav;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Football League");
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        BottomNav = findViewById(R.id.bottom_navigation);

        BottomNav.setSelectedItemId(R.id.nav_teams);

        BottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_match:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_teams:
                        return true;
                    case R.id.nav_Favorite:
                        startActivity(new Intent(getApplicationContext(),ActivityFavorite.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        RecyclerView Rv_Bola = findViewById(R.id.rv_team);
        Rv_Bola.setHasFixedSize(true);
        Rv_Bola.setLayoutManager(new LinearLayoutManager(ActivityTeam.this));
        HashMap<String,String> maps = new HashMap<>();
        Call<RestFootball> getListTeam = RetrofitGson.getInstance().api().getListTeam(maps);
        getListTeam.enqueue(new Callback<RestFootball>() {
            @Override
            public void onResponse(Call<RestFootball> call, Response<RestFootball> response) {
                if (response.isSuccessful()){
                    List<TeamModel> resultList = response.body().getTeams();
                    Rv_Bola.setAdapter(new TeamAdapter(resultList));
                }
            }
            @Override
            public void onFailure(Call<RestFootball> call, Throwable t) {

            }
        });

    }
}
