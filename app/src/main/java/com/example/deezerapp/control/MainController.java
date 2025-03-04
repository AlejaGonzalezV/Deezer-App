package com.example.deezerapp.control;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.deezerapp.R;
import com.example.deezerapp.model.Deezer;
import com.example.deezerapp.model.Playlist;
import com.example.deezerapp.util.Constants;
import com.example.deezerapp.util.HTTPSWebUtil;
import com.example.deezerapp.util.PlaylistAdapter;
import com.example.deezerapp.view.MainActivity;
import com.example.deezerapp.view.PlaylistActivity;
import com.example.deezerapp.view.TracksActivity;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainController implements View.OnClickListener, HTTPSWebUtil.OnResponseListener{

    private MainActivity activity;
    private HTTPSWebUtil util;
    private Deezer dz;
    private ArrayList<Playlist> pl;
    private PlaylistAdapter adapter;

    public MainController(MainActivity activity){

        this.activity = activity;
        this.activity.getBuscarBt().setOnClickListener(this);
        util = new HTTPSWebUtil();
        util.setListener(this);
        pl = new ArrayList<Playlist>();

        activity.getLista().setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        activity.getLista().setLayoutManager(manager);

        adapter = new PlaylistAdapter(pl);
        activity.getLista().setAdapter(adapter);
        activity.getLista().addItemDecoration(new DividerItemDecoration(activity.getLista().getContext(), DividerItemDecoration.VERTICAL));

        adapter.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos =activity.getLista().getChildAdapterPosition(v);
                String id  = adapter.getPlayLists().get(pos).getId();
                Intent i = new Intent(activity, PlaylistActivity.class);
                i.putExtra("id", id);
                activity.startActivity(i);

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buscarBt:

                String search = activity.getBuscar().getText().toString();


                new Thread(

                        () -> {

                           util.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/search/playlist?q="+search);


                        }

                ).start();



            break;

        }
    }




    @Override
    public void onResponse(int callbackID, String response) {
        switch(callbackID){
            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();
                dz = gson.fromJson(response, Deezer.class);
                pl = dz.getData();

                activity.runOnUiThread(
                        ()->
                        {

                            adapter.setPlayLists(pl);
                            adapter.notifyDataSetChanged();
                        }
                );




        }
    }
}
