package com.example.deezerapp.model;

import java.util.ArrayList;

public class Deezer {

    private Playlist[] data;

    public Deezer() {
    }

    public Deezer(Playlist[] data) {
        this.data = data;
    }

    public Playlist[] getData() {
        return data;
    }

    public void setData(Playlist[] data) {
        this.data = data;
    }
}
