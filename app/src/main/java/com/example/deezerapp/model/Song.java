package com.example.deezerapp.model;

public class Song {

    private String nombre;
    private String artista;
    private String lanzamiento;
    private String album;
    private String duracion;

    public Song(String nombre, String artista, String lanzamiento, String album, String duracion) {
        this.nombre = nombre;
        this.artista = artista;
        this.lanzamiento = lanzamiento;
        this.album = album;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
