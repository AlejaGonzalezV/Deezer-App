package com.example.deezerapp.model;

public class Track {

    private String id;
    private String title;
    private String duration;
    private String release_date;
    private Album album;
    private Artista artist;
    private String preview;


    public Track() {
    }

    public Track(String id, String title, String duration, Album album, Artista artist, String preview) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.album = album;
        this.artist = artist;
        this.preview = preview;
    }

    public Track(String id, String title, String duration, String release_date, Album album, Artista artist) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.release_date = release_date;
        this.album = album;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String time_add) {
        this.release_date = time_add;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artista getArtist() {
        return artist;
    }

    public void setArtist(Artista artist) {
        this.artist = artist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
