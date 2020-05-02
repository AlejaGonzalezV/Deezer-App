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

    private String description;
    private String fans;
    private AllTracks tracks;

    public Playlist(){

    }

    public Playlist(String title, String nb_tracks, String description, String fans, AllTracks tracks) {
        this.title = title;
        this.nb_tracks = nb_tracks;
        this.description = description;
        this.fans = fans;
        this.tracks = tracks;
    }

    public Playlist(String id, String title, String nb_tracks, String link, String picture_small, String track_list, User user) {
        this.id = id;
        this.title = title;
        this.nb_tracks = nb_tracks;
        this.link = link;
        this.picture_small = picture_small;
        this.track_list = track_list;
        this.user = user;
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
        return description;
    }

    public void setDescripcion(String descripcion) {
        this.description = descripcion;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AllTracks getTracks() {
        return tracks;
    }

    public void setTracks(AllTracks tracks) {
        this.tracks = tracks;
    }
}
