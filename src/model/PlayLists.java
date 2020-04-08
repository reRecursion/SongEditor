package model;

import exceptions.PlaylistExistException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayLists {
    private Map<String, SongList> playlist;
    private SongList selected;

    public PlayLists(){
        playlist = new HashMap<>();

        SongList songs = new SongList();

        songs.addSong(new Song("Pickle Rick REMIX SKILLREX XD ", "Jason"));
        songs.addSong(new Song("StOnEr P@rTY", "Jason"));
        songs.addSong(new Song("You spin me right round", "Gregor"));
        songs.addSong(new Song("UBC SMOKE WEED ", "Gregor"));
        songs.addSong(new Song("poo poo pee pee", "Gregor"));
        songs.addSong(new Song("STFU", "Patrick Walls"));

        SongList songs2 = new SongList();

        songs2.addSong(new Song("Pickle Rick REMIX SKILLREX XD ", "Jason"));
        songs2.addSong(new Song("StOnEr P@rTY", "Jason"));
        songs2.addSong(new Song("Merciless", "Gregor"));
        songs2.addSong(new Song("Sad song ", "John"));
        songs2.addSong(new Song("Ending My Life", "John"));
        songs2.addSong(new Song("Wanna kms", "John"));

        playlist.put("Chill Music", songs);
        playlist.put("Feeling Emotional", songs2);
    }
    public SongList selectPlaylist(){
        while(true) {
            System.out.println("Please select playlist: ");
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            try {
                selection(input);
                selected = playlist.get(input);
                break;
            } catch (PlaylistExistException e) {
                System.out.println("The playlist you've entered does not exist!");
            }
        }
        return selected;
    }

    public void selection(String input)throws PlaylistExistException{
        if(!playlist.containsKey(input)){
            throw new PlaylistExistException();
        }

    }
}
