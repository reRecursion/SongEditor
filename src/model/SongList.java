package model;

import Interfaces.Observers;
import exceptions.InvalidIndexException;
import exceptions.ListEmptyExceptions;

import java.util.*;

public class SongList implements Observers,Iterable<Song> {
    ArrayList<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(int index) throws InvalidIndexException,ListEmptyExceptions  {
        if(songs.size()==0){
            throw new ListEmptyExceptions();
        }
        if(index > songs.size()|| index-1 < 0){
            throw new InvalidIndexException();
        }
        songs.remove(index-1);
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean equals (SongList s) {
        for (int i = 0; i<songs.size(); i++) {
            if (!songs.get(i).getSongname().equals(s.getSongs().get(i).getSongname())){
                return false;
            }

        }
        return true;
    }


    public void printSongs() {
        System.out.println("Track #:   Song name:"   );
        for (int i = 1; i<=songs.size(); i++) {
            System.out.println(i + "   |     " + songs.get(i-1).getSongname());
        }
    }

    public void shufflePlaylist(){
        if(songs.size()<=1){
            System.out.println("There's no need to shuffle!");
        }

        Collections.shuffle(songs);
    }

    public void addB(Song s){
        if(!songs.contains(s)){
            songs.add(s);
            s.addA(this);
        }

    }
    public void removeB(Song s){
        if(songs.contains((s))){
            songs.remove(s);
            s.removeA(this);
        }
    }


    public void update(Song o) {
        if(!songs.contains(o)){
            songs.add(o);
        }
    }

    @Override
    public Iterator<Song> iterator() {
        return songs.iterator();
    }
}
