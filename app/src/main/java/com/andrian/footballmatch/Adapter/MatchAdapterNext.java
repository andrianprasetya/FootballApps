package com.andrian.footballmatch.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andrian.footballmatch.R;
import com.andrian.footballmatch.Model.EventModel;

import java.util.List;

public class MatchAdapterNext extends RecyclerView.Adapter<MatchAdapterNext.ListViewHolder> {

    private List<EventModel> listMatch;
    private boolean identiview;
    public MatchAdapterNext(List<EventModel> listMatch, boolean identiview) {
        this.listMatch = listMatch;
        this.identiview = identiview;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_nextmatch, parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        EventModel football = listMatch.get(position);
        holder.Tv_DateMatch.setText(football.getDateEvent());
        holder.Tv_TeamHome.setText(football.getStrHomeTeam());
        holder.Tv_TeamAway.setText(football.getStrAwayTeam());

    }

    @Override
    public int getItemCount() {
        return listMatch.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView Tv_DateMatch,Tv_TeamHome,Tv_TeamAway;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            Tv_DateMatch = itemView.findViewById(R.id.tv_date_match);
            Tv_TeamHome = itemView.findViewById(R.id.tv_team_home);
            Tv_TeamAway = itemView.findViewById(R.id.tv_team_away);

        }
    }
}
