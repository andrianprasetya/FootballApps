package com.andrian.footballmatch.RestClass;

import java.util.List;

import com.andrian.footballmatch.Model.EventModel;
import com.andrian.footballmatch.Model.TeamModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestFootball {

    @SerializedName("events")
    @Expose
    private List<EventModel> events = null;

    public List<EventModel> getEvents() {
        return events;
    }

    public void setEvents(List<EventModel> events) {
        this.events = events;
    }

    @SerializedName("teams")
    @Expose
    private List<TeamModel> teams = null;

    public List<TeamModel> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamModel> teams) {
        this.teams = teams;
    }

}
