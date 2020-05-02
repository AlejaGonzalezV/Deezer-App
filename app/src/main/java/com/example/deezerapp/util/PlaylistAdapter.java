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

import com.bumptech.glide.Glide;
import com.example.deezerapp.R;
import com.example.deezerapp.model.Playlist;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {

    private ArrayList<Playlist> playLists;
    private View.OnClickListener clicList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre, creador, items;
        private ImageView playlistIV;
        private View v;

        public ViewHolder(View view) {
            super(view);
            v = view;
            playlistIV = view.findViewById(R.id.songIV);
            nombre = view.findViewById(R.id.nombre);
            creador = view.findViewById(R.id.artista);
            items = view.findViewById(R.id.lanzamiento);

        }

        public void cambiarImagen(String url) {

            Glide.with(v).load(url).centerCrop().into(playlistIV);

        }


    }

    public PlaylistAdapter(ArrayList<Playlist> playLists) {
        this.playLists = playLists;
    }

    public void setPlayLists(ArrayList<Playlist> playLists) {
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicList.onClick(view);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nombre.setText(playLists.get(position).getTitle());
        holder.creador.setText(playLists.get(position).getUser().getName());
        holder.items.setText(playLists.get(position).getNb_tracks());
        holder.cambiarImagen(playLists.get(position).getPicture_small());


    }

    public ArrayList<Playlist> getPlayLists() {
        return playLists;
    }

    @Override
    public int getItemCount() {
        return playLists.size();
    }






}
