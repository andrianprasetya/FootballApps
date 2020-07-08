package com.andrian.footballmatch.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrian.footballmatch.Model.TeamModel;
import com.andrian.footballmatch.R;
import com.andrian.footballmatch.RestClass.RestFootball;
import com.andrian.footballmatch.RetrofitGson;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailLastMatchActivity extends AppCompatActivity {
    TextView TV_HomeScore, TV_AwayScore, TV_HomeGoal, TV_AwayGoal, TV_HomeName, TV_AwayName, TV_HomeGoalKeeper
            , TV_AwayGoalKeeper, TV_HomeDefender,TV_AwayDefender, TV_HomeMidfielder, TV_AwayMidfielder, TV_HomeForward
            , TV_AwayForward, TV_HomeSubtitutes, TV_AwaySubtitues,TV_Date;
    ImageView IMG_HomeBadge,IMG_AwayBadge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_last_match);

        TV_HomeName = findViewById(R.id.tv_home_name);
        TV_AwayName = findViewById(R.id.tv_away_name);
        TV_HomeScore = findViewById(R.id.tv_HomeScore);
        TV_AwayScore = findViewById(R.id.tv_AwayScore);
        TV_HomeGoal = findViewById(R.id.tv_HomeGoal);
        TV_AwayGoal = findViewById(R.id.tv_AwayGoal);
        TV_HomeGoalKeeper = findViewById(R.id.tv_HomeGoalKeeper);
        TV_AwayGoalKeeper = findViewById(R.id.tv_AwayGoalKeeper);
        TV_HomeDefender = findViewById(R.id.tv_HomeDefender);
        TV_AwayDefender = findViewById(R.id.tv_AwayDefender);
        TV_HomeMidfielder = findViewById(R.id.tv_HomeMidfielder);
        TV_AwayMidfielder = findViewById(R.id.tv_AwayMidfielder);
        TV_HomeForward = findViewById(R.id.tv_HomeForward);
        TV_AwayForward = findViewById(R.id.tv_AwayForward);
        TV_HomeSubtitutes = findViewById(R.id.tv_HomeSubstitution);
        TV_AwaySubtitues = findViewById(R.id.tv_AwaySubstitution);
        TV_Date = findViewById(R.id.tv_date_match);

        IMG_HomeBadge = findViewById(R.id.Home_Badge);
        IMG_AwayBadge = findViewById(R.id.Away_Badge);

        Toolbar ToolBarAtas = findViewById(R.id.toolbar);
        setSupportActionBar(ToolBarAtas);
        ToolBarAtas.setLogoDescription(getResources().getString(R.string.app_name));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String Date = intent.getStringExtra("date");
        String Home_Name = intent.getStringExtra("home_name");
        String Away_Name = intent.getStringExtra("away_name");
        String ID_home = intent.getStringExtra("id_home");
        String ID_away = intent.getStringExtra("id_away");
        String HomeScore = intent.getStringExtra("home_score");
        String AwayScore = intent.getStringExtra("away_score");
        String HomeGoal = intent.getStringExtra( "home_goal");
        String AwayGoal = intent.getStringExtra("away_goal");
        String HomeGoalKeeper = intent.getStringExtra("home_goal_keeper");
        String AwayGoalKeeper = intent.getStringExtra("away_goal_keeper");
        String HomeDefender = intent.getStringExtra("home_defender");
        String AwayDefender = intent.getStringExtra("away_defender");
        String HomeMidfielder = intent.getStringExtra("home_midfielder");
        String AwayMidfielder = intent.getStringExtra("away_midfielder");
        String HomeForward = intent.getStringExtra("home_forward");
        String AwayForward = intent.getStringExtra("away_forward");
        String HomeSubtitutes = intent.getStringExtra("home_subtitutes");
        String AwaySubtitues = intent.getStringExtra("away_subtitues");

        TV_Date.setText(Date);
        TV_HomeName.setText(Home_Name);
        TV_AwayName.setText(Away_Name);
        TV_HomeScore.setText(HomeScore);
        TV_AwayScore.setText(AwayScore);
        TV_HomeGoal.setText(HomeGoal);
        TV_AwayGoal.setText(AwayGoal);
        TV_HomeGoalKeeper.setText(HomeGoalKeeper);
        TV_AwayGoalKeeper.setText(AwayGoalKeeper);
        TV_HomeDefender.setText(HomeDefender);
        TV_AwayDefender.setText(AwayDefender);
        TV_HomeMidfielder.setText(HomeMidfielder);
        TV_AwayMidfielder.setText(AwayMidfielder);
        TV_HomeForward.setText(HomeForward);
        TV_AwayForward.setText(AwayForward);
        TV_HomeSubtitutes.setText(HomeSubtitutes);
        TV_AwaySubtitues.setText(AwaySubtitues);

        // Home Badge
        Call<RestFootball> getListTeam = RetrofitGson.getInstance().api().getListTeamByID(ID_home);
        getListTeam.enqueue(new Callback<RestFootball>() {
            @Override
            public void onResponse(Call<RestFootball> call, Response<RestFootball> response) {
                if (response.isSuccessful()){
                    List<TeamModel> resultList = response.body().getTeams();
                    for (TeamModel result : resultList){
                        Glide.with(DetailLastMatchActivity.this)
                                .load(result.getStrTeamBadge())
                                .apply(new RequestOptions().override(55,55))
                                .into(IMG_HomeBadge);
                    }
                }
            }

            @Override
            public void onFailure(Call<RestFootball> call, Throwable t) {

            }
        });
        getListTeam = RetrofitGson.getInstance().api().getListTeamByID(ID_away);
        getListTeam.enqueue(new Callback<RestFootball>() {
            @Override
            public void onResponse(Call<RestFootball> call, Response<RestFootball> response) {
                if (response.isSuccessful()){
                    List<TeamModel> resultList = response.body().getTeams();
                    for (TeamModel result : resultList){
                        Glide.with(DetailLastMatchActivity.this)
                                .load(result.getStrTeamBadge())
                                .apply(new RequestOptions().override(55,55))
                                .into(IMG_AwayBadge);
                    }
                }
            }

            @Override
            public void onFailure(Call<RestFootball> call, Throwable t) {

            }
        });
    }

}