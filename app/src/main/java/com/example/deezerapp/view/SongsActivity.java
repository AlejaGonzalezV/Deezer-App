package com.example.deezerapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezerapp.R;

public class SongsActivity extends AppCompatActivity {

    public final static String ID = "410122";

    private ImageView cancionIV;
    private TextView nombre;
    private TextView artista;
    private TextView album;
    private TextView duracion;
    private Button escucharBt;

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
