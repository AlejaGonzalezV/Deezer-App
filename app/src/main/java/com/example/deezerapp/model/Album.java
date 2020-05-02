package com.example.deezerapp.model;

public class Album {

    String title;
    String cover_medium;

    public Album() {
    }

    public Album(String title, String cover_medium) {
        this.title = title;
        this.cover_medium = cover_medium;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover_medium;
    }

    public void setCover(String cover_medium) {
        this.cover_medium = cover_medium;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
