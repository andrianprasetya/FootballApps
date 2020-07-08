package com.andrian.footballmatch.API;

import com.andrian.footballmatch.RestClass.RestFootball;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiServices {

    @GET("eventspastleague.php?id=4328")
    Call<RestFootball> getListLastEvent(@QueryMap Map<String,String> maps);

    @GET("eventsnextleague.php?id=4328")
    Call<RestFootball> getListNextEvent(@QueryMap Map<String,String> maps);

    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<RestFootball> getListTeam(@QueryMap Map<String,String> maps);
    @GET("lookupteam.php")
    Call<RestFootball> getListTeamByID(@Query("id") String id);
}
