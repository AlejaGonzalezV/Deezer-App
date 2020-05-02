package com.example.deezerapp.model;


import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable {

    private String id;
    private String title;
    private String nb_tracks;
    private String link;
    private String picture_small;
    private String track_list;
    private User user;

    private String descripcion;
    private String fans;
    private ArrayList<Song> lista;

    public Playlist(){


    }



    public Playlist(String id, String title, String nb_tracks, String link, String picture_small, String track_list, User user) {
        this.id = id;
        this.title = title;
        this.nb_tracks = nb_tracks;
        this.link = link;
        this.picture_small = picture_small;
        this.track_list = track_list;
        this.user = user;
        lista = new ArrayList<Song>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(String nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture_small() {
        return picture_small;
    }

    public void setPicture_small(String picture_small) {
        this.picture_small = picture_small;
    }

    public String getTrack_list() {
        return track_list;
    }

    public void setTrack_list(String track_list) {
        this.track_list = track_list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public ArrayList<Song> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Song> lista) {
        this.lista = lista;
    }

    /*
    public void addSong(Song can){

        lista.add(can);

    }

    public static Playlist getPlaylist(JsonObject jsonObject){
        String id  = jsonObject.get("id").getAsString();
        String nombre  = jsonObject.get("title").getAsString();
        String canciones  = jsonObject.get("nb_tracks").getAsString();
        JsonObject user  = jsonObject.get("user").getAsJsonObject();
        String creador  = user.get("name").getAsString();
        String imagen  = jsonObject.get("picture").getAsString();
        //util.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/playlist/"+id);
       //String json =
        URL url = null;
        try{
            url  = new URL(imagen);
        } catch (MalformedURLException ex){

        }

        //Playlist playlist = new Playlist(id,);
        return null;
    }
    */


}
