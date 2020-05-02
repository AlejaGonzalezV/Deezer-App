package com.example.deezerapp.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.deezerapp.R;
import com.example.deezerapp.model.Track;

import java.util.ArrayList;

public class PlaylistDetAdapter extends RecyclerView.Adapter<PlaylistDetAdapter.ViewHolder>{

    private ArrayList<Track> tracks;
    private View.OnClickListener clicList;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_row, parent, false);
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

        holder.nombre.setText(tracks.get(position).getTitle());
        holder.lanzamiento.setText(tracks.get(position).getRelease_date());
        holder.artista.setText(tracks.get(position).getArtist().getName());
        holder.cambiarImagen(tracks.get(position).getAlbum().getCover());


    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView songIV;
        private TextView nombre, artista, lanzamiento;
        private View v;

        public ViewHolder (@NonNull View itemView) {
            super(itemView);

            v = itemView;
            songIV = itemView.findViewById(R.id.songIV);
            nombre = itemView.findViewById(R.id.nombre);
            artista = itemView.findViewById(R.id.artista);
            lanzamiento = itemView.findViewById(R.id.lanzamiento);


        }

        public void cambiarImagen(String url){

            Glide.with(v).load(url).centerCrop().into(songIV);

        }
    }

    public PlaylistDetAdapter(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public void setSongs(ArrayList<Track> tracks){

        this.tracks = tracks;
        notifyDataSetChanged();

    }

    public void setClickListener(View.OnClickListener callback) {
        clicList = (View.OnClickListener) callback;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }
}
