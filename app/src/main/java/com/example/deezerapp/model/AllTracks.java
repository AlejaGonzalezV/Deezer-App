package com.example.deezerapp.model;

import java.util.ArrayList;

public class AllTracks {

    private ArrayList<Track> data;

    public AllTracks() {
    }

    public AllTracks(ArrayList<Track> data) {
        this.data = data;
    }

    public ArrayList<Track> getData() {
        return data;
    }

    public void setData(ArrayList<Track> data) {
        this.data = data;
    }
}
