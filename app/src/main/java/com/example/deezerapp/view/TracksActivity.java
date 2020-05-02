package com.example.deezerapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezerapp.R;
import com.example.deezerapp.control.TrackController;

public class TracksActivity extends AppCompatActivity {

    private ImageView cancionIV;
    private TextView nombre;
    private TextView artista;
    private TextView album;
    private TextView duracion;
    private Button escucharBt;
    private TrackController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        cancionIV = findViewById(R.id.cancionIV);
        nombre = findViewById(R.id.nombre);
        artista = findViewById(R.id.artista);
        album = findViewById(R.id.album);
        duracion = findViewById(R.id.duracion);
        escucharBt = findViewById(R.id.escucharBt);

        controller = new TrackController(this);



    }

    public ImageView getCancionIV() {
        return cancionIV;
    }

    public TextView getNombre() {
        return nombre;
    }

    public TextView getArtista() {
        return artista;
    }

    public TextView getAlbum() {
        return album;
    }

    public TextView getDuracion() {
        return duracion;
    }

    public Button getEscucharBt() {
        return escucharBt;
    }
}
