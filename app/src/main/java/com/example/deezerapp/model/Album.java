package com.example.deezerapp.model;

public class Album {

    String title;
    String cover;

    public Album() {
    }

    public Album(String title, String cover) {
        this.title = title;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
