package com.example.deezerapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.deezer.sdk.network.connect.DeezerConnect;
import com.example.deezerapp.R;

public class PlaylistActivity extends AppCompatActivity {

    public final static String ID = "410122";

    private ImageView playlistIV;
    private TextView nombre;
    private TextView descripcion;
    private TextView canciones;
    private TextView fans;
    private RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_playlist);

        playlistIV = findViewById(R.id.songIV);
        nombre = findViewById(R.id.nombre);
        descripcion = findViewById(R.id.descripcion);
        canciones = findViewById(R.id.descripcion);
        fans = findViewById(R.id.fans);
        lista = findViewById(R.id.lista);

    }

    public ImageView getPlaylistIV() {
        return playlistIV;
    }

    public TextView getNombre() {
        return nombre;
    }

    public TextView getDescripcion() {
        return descripcion;
    }

    public TextView getCanciones() {
        return canciones;
    }

    public TextView getFans() {
        return fans;
    }

    public RecyclerView getLista() {
        return lista;
    }
}
