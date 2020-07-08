package com.andrian.footballmatch.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrian.footballmatch.Adapter.MatchAdapterNext;
import com.andrian.footballmatch.R;
import com.andrian.footballmatch.Model.EventModel;
import com.andrian.footballmatch.RestClass.RestFootball;
import com.andrian.footballmatch.RetrofitGson;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NextMatchFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_next_match, container, false);
        RecyclerView Rv_Bola = view.findViewById(R.id.rv_NextMatch);

        Rv_Bola.setHasFixedSize(true);
        Rv_Bola.setLayoutManager(new LinearLayoutManager(getContext()));
        HashMap<String,String> maps = new HashMap<>();
        Call<RestFootball> getListEvent = RetrofitGson.getInstance().api().getListNextEvent(maps);
        getListEvent.enqueue(new Callback<RestFootball>() {
            @Override
            public void onResponse(Call<RestFootball> call, Response<RestFootball> response) {
                if (response.isSuccessful()){
                    List<EventModel> resultList = response.body().getEvents();
                    Rv_Bola.setAdapter(new MatchAdapterNext(resultList,true));
                }
            }
            @Override
            public void onFailure(Call<RestFootball> call, Throwable t) {

            }
        });

        return view;
    }
}
