package com.example.deezerapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import com.example.deezerapp.R;
import com.example.deezerapp.control.MainController;


public class MainActivity extends AppCompatActivity {

    private EditText buscar;
    private ImageButton buscarBt;
    private RecyclerView lista;
    private MainController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        buscar = findViewById(R.id.buscar);
        lista = findViewById(R.id.lista);
        buscarBt = findViewById(R.id.buscarBt);
        controller = new MainController(this);

    }

    public EditText getBuscar() {
        return buscar;
    }

    public void setBuscar(EditText buscar) {
        this.buscar = buscar;
    }

    public ImageButton getBuscarBt() {
        return buscarBt;
    }

    public void setBuscarBt(ImageButton buscarBt) {
        this.buscarBt = buscarBt;
    }

    public RecyclerView getLista() {
        return lista;
    }

    public void setLista(RecyclerView lista) {
        this.lista = lista;
    }
}
