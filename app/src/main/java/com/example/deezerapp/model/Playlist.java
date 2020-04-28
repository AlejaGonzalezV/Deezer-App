package com.example.deezerapp.model;

import com.google.gson.JsonObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Playlist {

    private String id;
    private String nombre;
    private String canciones;
    private String creador;
    private String descripcion;
    private String fans;
    private URL imagen;
    private ArrayList<Song> lista;

    public Playlist(String id, String nombre, String canciones, String creador, String descripcion, String fans, URL imagen, ArrayList<Song> lista) {
        this.id = id;
        this.nombre = nombre;
        this.canciones = canciones;
        this.creador = creador;
        this.descripcion = descripcion;
        this.fans = fans;
        this.imagen = imagen;
        this.lista = lista;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCanciones() {
        return canciones;
    }

    public void setCanciones(String canciones) {
        this.canciones = canciones;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public URL getImagen() {
        return imagen;
    }

    public void setImagen(URL imagen) {
        this.imagen = imagen;
    }

    public ArrayList<Song> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Song> lista) {
        this.lista = lista;
    }

    public void agregarCancion(Song can){

        lista.add(can);

    }

    public static Playlist getPlaylist(JsonObject jsonObject){
        String id  = jsonObject.get("id").getAsString();
        String nombre  = jsonObject.get("title").getAsString();
        String canciones  = jsonObject.get("nb_tracks").getAsString();
        JsonObject user  = jsonObject.get("user").getAsJsonObject();
        String creador  = user.get("name").getAsString();
        String imagen  = jsonObject.get("picture").getAsString();


        URL url = null;
        try{
            url  = new URL(imagen);
        } catch (MalformedURLException ex){

        }

        //Playlist playlist = new Playlist(id,);
        return null;
    }

}
