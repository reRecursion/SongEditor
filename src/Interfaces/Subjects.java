package Interfaces;

import model.Song;

import java.util.ArrayList;
import java.util.List;

public abstract class Subjects {
    private List<Observers> SongLists;

    public Subjects(){
        SongLists = new ArrayList<>();}

    public void addObservers(Observers o){
        if(!SongLists.contains(o)){
            SongLists.add(o);
        }
    }

    public void notifyObservers(Song a) {
        for (Observers o : SongLists) {
            o.update(a);
        }
    }

}
