package com.example.deezerapp.control;

import android.view.View;

import com.example.deezerapp.model.Deezer;
import com.example.deezerapp.util.HTTPSWebUtil;
import com.example.deezerapp.view.MainActivity;
import com.example.deezerapp.view.PlaylistActivity;

public class PlaylistController implements View.OnClickListener, HTTPSWebUtil.OnResponseListener {

    private PlaylistActivity activity;
    private HTTPSWebUtil util;
    private Deezer dz;

    public PlaylistController(PlaylistActivity activity){

        this.activity = activity;



        util = new HTTPSWebUtil();
        util.setListener(this);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onResponse(int callbackID, String response) {

    }
}
