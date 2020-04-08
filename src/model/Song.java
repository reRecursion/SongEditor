package model;

import java.util.ArrayList;

public class Song {
    String name;
    String artist;
    ArrayList<SongList> s = new ArrayList<>();

    public Song(String name, String artist){
        this.name=name;
        this.artist= artist;

    }

    public void setSongname(String name){
        this.name = name;
    }

    public String getSongname(){
        return name;
    }

    @Override
    public int hashCode(){
        String title = name+artist;
        return title.hashCode();

    }
    @Override
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        if(obj ==null){
            return false;
        }
        Song s = (Song)obj;
        return this.getSongname()==s.getSongname();
    }


    public void addA(SongList songlist){
        if(!s.contains(songlist)){
            s.add(songlist);
            songlist.addB(this);
        }
    }
    public void removeA (SongList songlist) {
        if (s.contains((songlist))) {
            s.remove(songlist);
            songlist.removeB(this);

        }
    }


}
