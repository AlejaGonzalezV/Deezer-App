package com.example.deezerapp.control;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.Glide;
import com.example.deezerapp.R;
import com.example.deezerapp.model.Track;
import com.example.deezerapp.util.Constants;
import com.example.deezerapp.util.HTTPSWebUtil;
import com.example.deezerapp.view.TracksActivity;
import com.google.gson.Gson;

public class TrackController implements HTTPSWebUtil.OnResponseListener, View.OnClickListener{

    private TracksActivity activity;
    private HTTPSWebUtil util;
    private Gson gson;
    private Track track;

    public TrackController(TracksActivity activity){

        this.activity = activity;
        activity.getEscucharBt().setOnClickListener(this);
        util = new HTTPSWebUtil();
        util.setListener(this);
        gson = new Gson();
        infoTracks();

    }



    @Override
    public void onResponse(int callbackID, String response) {

        switch(callbackID){

            case Constants.TRACKS_CALLBACK:
                track = gson.fromJson(response, Track.class);

                activity.runOnUiThread(

                        () -> {

                            Glide.with(activity).load(track.getAlbum().getCover()).centerCrop().into(activity.getCancionIV());
                            activity.getNombre().setText(track.getTitle());
                            activity.getArtista().setText(track.getArtist().getName());
                            activity.getAlbum().setText(track.getAlbum().getTitle());
                            activity.getDuracion().setText(track.getDuration() + " seg.");

                        }

                );


        }

    }

    public void infoTracks(){


        String id = activity.getIntent().getExtras().get("id").toString();
        new Thread(
                () -> {
                    util.GETrequest(Constants.TRACKS_CALLBACK, "https://api.deezer.com/track/"+id);
                }
        ).start();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.escucharBt:
                Intent intent = this.activity.getPackageManager().getLaunchIntentForPackage("deezer.android.app");
                Uri enlace = Uri.parse(track.getPreview());
                if(intent == null){

                    Intent inte = new Intent(Intent.ACTION_VIEW);
                    inte.setData(enlace);
                    activity.startActivity(inte);

                } else {

                    intent.setData(enlace);
                    activity.startActivity(intent);

                }
            break;
        }
    }
}
