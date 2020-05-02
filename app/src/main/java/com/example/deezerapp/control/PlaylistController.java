package com.example.deezerapp.control;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.deezerapp.model.Deezer;
import com.example.deezerapp.model.Playlist;
import com.example.deezerapp.model.Track;
import com.example.deezerapp.util.Constants;
import com.example.deezerapp.util.HTTPSWebUtil;
import com.example.deezerapp.util.PlaylistDetAdapter;
import com.example.deezerapp.view.PlaylistActivity;
import com.example.deezerapp.view.TracksActivity;
import com.google.gson.Gson;

import java.util.ArrayList;

public class PlaylistController implements HTTPSWebUtil.OnResponseListener{

    private PlaylistActivity activity;
    private HTTPSWebUtil util;
    private ArrayList<Track> tracks;
    private Playlist playlist;
    private PlaylistDetAdapter adapter;
    private  Gson gson;

    public PlaylistController(PlaylistActivity activity){

        this.activity = activity;
        util = new HTTPSWebUtil();
        util.setListener(this);
        gson = new Gson();
        tracks = new ArrayList<Track>();

        activity.getLista().setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        activity.getLista().setLayoutManager(manager);

        adapter = new PlaylistDetAdapter(tracks);
        activity.getLista().setAdapter(adapter);
        activity.getLista().addItemDecoration(new DividerItemDecoration(activity.getLista().getContext(), DividerItemDecoration.VERTICAL));

        infoPlaylist();

        adapter.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos =activity.getLista().getChildAdapterPosition(v);
                String id  = adapter.getTracks().get(pos).getId();
                Intent i = new Intent(activity, TracksActivity.class);
                i.putExtra("id", id);
                activity.startActivity(i);

            }
        });

    }

    @Override
    public void onResponse(int callbackID, String response) {

        switch(callbackID) {
            case Constants.PLAYLIST_CALLBACK:
                playlist = gson.fromJson(response, Playlist.class);

                activity.runOnUiThread(

                        () -> {

                            Glide.with(activity).load(playlist.getPicture_small()).centerCrop().into(activity.getPlaylistIV());
                            activity.getNombre().setText(playlist.getTitle());
                            activity.getDescripcion().setText(playlist.getDescripcion());
                            activity.getCanciones().setText("Canciones: " + playlist.getNb_tracks());
                            activity.getFans().setText("Fans: " + playlist.getFans());


                        }

                );
                tracks();
                break;

        }

    }

    public void infoPlaylist(){

        String id = activity.getIntent().getExtras().get("id").toString();
        new Thread(
                () -> {
                    util.GETrequest(Constants.PLAYLIST_CALLBACK, "https://api.deezer.com/playlist/"+id);
                }
        ).start();

    }

    public void tracks(){


        tracks = playlist.getTracks().getData();
        ArrayList<Track> others = new ArrayList<Track>();
        for(int i=0; i<tracks.size(); i++){

            String query = util.GETrequest("https://api.deezer.com/track/"+tracks.get(i).getId());
            Track tr = gson.fromJson(query, Track.class);
            others.add(tr);

        }
        activity.runOnUiThread(

                () -> {

                    adapter.setSongs(others);
                    adapter.notifyDataSetChanged();

                }

        );

    }
}
