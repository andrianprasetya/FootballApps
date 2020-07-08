package com.andrian.footballmatch.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andrian.footballmatch.Model.EventModel;
import com.andrian.footballmatch.Model.TeamModel;
import com.andrian.footballmatch.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {
    private List<TeamModel> listTeam;

    public TeamAdapter(List<TeamModel> listTeam) {
        this.listTeam = listTeam;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_team, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TeamModel team = listTeam.get(position);
        holder.Tv_item.setText(team.getStrTeam());
        Glide.with(holder.itemView.getContext())
                .load(team.getStrTeamBadge())
                .apply(new RequestOptions().override(55,55))
                .into(holder.IMG_item);
    }

    @Override
    public int getItemCount() {
        return listTeam.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Tv_item;
        ImageView IMG_item;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            IMG_item = itemView.findViewById(R.id.img_item_photo);
            Tv_item = itemView.findViewById(R.id.tv_item_name);
        }
    }
}
