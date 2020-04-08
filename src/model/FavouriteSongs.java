package model;

import Interfaces.Subjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FavouriteSongs extends Subjects{
    private List<Song> BestSongs;
    private String name;

    public FavouriteSongs(String name){
        this.name = name;
    }

    public void addSongs(Song s){
        BestSongs.add(s);
        notifyObservers(s);
    }

}

