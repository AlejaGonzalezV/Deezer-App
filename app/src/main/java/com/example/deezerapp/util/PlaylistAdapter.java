package com.example.deezerapp.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deezerapp.R;
import com.example.deezerapp.model.Playlist;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder>{

    private ArrayList<Playlist> playLists;
    private View.OnClickListener clicList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre, creador, items;
        private ImageView playlistIV;

        public ViewHolder(View view) {
            super(view);
            playlistIV = view.findViewById(R.id.playlistIV);
            nombre = view.findViewById(R.id.nombre);
            creador = view.findViewById(R.id.creador);
            items = view.findViewById(R.id.items);


        }

    }

    public PlaylistAdapter(ArrayList<Playlist> playLists)
    {
        this.playLists = playLists;
    }

    public void setPlayLists(ArrayList<Playlist> playLists)
    {
        this.playLists = playLists;
        notifyDataSetChanged();

    }

    public void setClickListener(View.OnClickListener callback) {
        clicList = (View.OnClickListener) callback;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_row, parent, false);
        ViewHolder holder = new ViewHolder(view);
       return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nombre.setText(playLists.get(position).getTitle());
        holder.creador.setText(playLists.get(position).getUser().getName());
        holder.items.setText(playLists.get(position).getNb_tracks());
        //holder.playlistIV.setImageBitmap(getImage(playLists.get(position).getPicture_small()));
        Log.e("<<<<<<<<<<<<<<<<< ", "AdapterSetting");

    }

    @Override
    public int getItemCount() {
        return playLists.size();
    }



    private Bitmap getImage(String url) {
        Bitmap bm = null;
        try {
            URL _url = new URL(url);
            URLConnection con = _url.openConnection();
            con.connect();
            InputStream is = con.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {

        }
        return bm;
    }



}
