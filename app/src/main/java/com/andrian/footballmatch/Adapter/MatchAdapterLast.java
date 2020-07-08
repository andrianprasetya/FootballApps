package com.andrian.footballmatch.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andrian.footballmatch.Activity.DetailLastMatchActivity;
import com.andrian.footballmatch.Model.EventModel;
import com.andrian.footballmatch.R;

import java.util.List;

public class MatchAdapterLast extends RecyclerView.Adapter<MatchAdapterLast.ListViewHolder> {

    private List<EventModel> listMatch;
    private boolean identiview;
    public MatchAdapterLast(List<EventModel> listMatch, boolean identiview) {
        this.listMatch = listMatch;
        this.identiview = identiview;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_lastmatch, parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        EventModel football = listMatch.get(position);
        holder.Tv_DateMatch.setText(football.getDateEvent());
        holder.Tv_TeamHome.setText(football.getStrHomeTeam());
        holder.Tv_ScoreHome.setText(football.getIntHomeScore());
        holder.Tv_TeamAway.setText(football.getStrAwayTeam());
        holder.Tv_ScoreAway.setText(football.getIntAwayScore());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name_Home = football.getStrHomeTeam();
                String Name_Away = football.getStrAwayTeam();
                String ID_home = football.getIdHomeTeam();
                String ID_away = football.getIdAwayTeam();
                String Date = football.getDateEvent();
                String HomeScore = football.getIntHomeScore();
                String AwayScore = football.getIntAwayScore();
                String HomeGoal = football.getStrHomeGoalDetails();
                String AwayGoal = football.getStrAwayGoalDetails();
                String HomeGoalKeeper = football.getStrHomeLineupGoalkeeper();
                String AwayGoalKeeper = football.getStrAwayLineupGoalkeeper();
                String HomeDefender = football.getStrHomeLineupDefense();
                String AwayDefender = football.getStrAwayLineupDefense();
                String HomeMidfielder = football.getStrHomeLineupMidfield();
                String AwayMidfielder = football.getStrAwayLineupMidfield();
                String HomeForward = football.getStrHomeLineupForward();
                String AwayForward = football.getStrAwayLineupForward();
                String HomeSubtitutes = football.getStrHomeLineupSubstitutes();
                String AwaySubtitues = football.getStrAwayLineupSubstitutes();

                Intent intent = new Intent(view.getContext(), DetailLastMatchActivity.class);

                intent.putExtra("date", Date);
                intent.putExtra("home_name", Name_Home);
                intent.putExtra("away_name", Name_Away);
                intent.putExtra("id_home", ID_home);
                intent.putExtra("id_away", ID_away);
                intent.putExtra("home_score", HomeScore);
                intent.putExtra("away_score", AwayScore);
                intent.putExtra("home_goal", HomeGoal);
                intent.putExtra("away_goal", AwayGoal);
                intent.putExtra("home_goal_keeper", HomeGoalKeeper);
                intent.putExtra("away_goal_keeper", AwayGoalKeeper);
                intent.putExtra("home_defender", HomeDefender);
                intent.putExtra("away_defender", AwayDefender);
                intent.putExtra("home_midfielder", HomeMidfielder);
                intent.putExtra("away_midfielder", AwayMidfielder);
                intent.putExtra("home_forward", HomeForward);
                intent.putExtra("away_forward", AwayForward);
                intent.putExtra("home_subtitutes", HomeSubtitutes);
                intent.putExtra("away_subtitues", AwaySubtitues);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMatch.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView Tv_DateMatch,Tv_TeamHome,Tv_ScoreHome,Tv_TeamAway,Tv_ScoreAway;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            Tv_DateMatch = itemView.findViewById(R.id.tv_date_match);
            Tv_TeamHome = itemView.findViewById(R.id.tv_team_home);
            Tv_ScoreHome = itemView.findViewById(R.id.tv_score_home);
            Tv_TeamAway = itemView.findViewById(R.id.tv_team_away);
            Tv_ScoreAway = itemView.findViewById(R.id.tv_score_away);

        }
    }
}
