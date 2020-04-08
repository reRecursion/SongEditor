package test;

import exceptions.InvalidIndexException;
import exceptions.ListEmptyExceptions;
import exceptions.RemoveListExceptions;
import model.Song;
import model.SongList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestSongList {


//    @Before
//    public void initialize() {
//        SongList songs = new SongList();
//
//            songs.addSong(new Song("StOnEr P@rTY", "Jason"));
//            songs.addSong(new Song("You spin me right round", "Gregor"));
//            songs.addSong(new Song("UBC SMOKE WEED ", "Gregor"));
//            songs.addSong(new Song("poo poo pee pee", "Gregor"));
//            songs.addSong(new Song("STFU", "Patrick Walls"));
//
//
//    }

    @Test
    public void testSongListFeatures(){


        SongList s = new SongList();

        s.addSong(new Song("UBC SMOKE WEED ","Gregor"));
        s.addSong(new Song("poo poo pee pee","Gregor"));
        s.addSong(new Song("STFU","Patrick Walls"));

        assertTrue(s.equals(s));

    }
    @Test
    public void testValidRemove(){
        SongList songs = new SongList();

        songs.addSong(new Song("StOnEr P@rTY", "Jason"));
        try{
            songs.removeSong(1);
        }catch(RemoveListExceptions e){
            fail("Should not throw exception");
        }

    }

    @Test
    public void testInvalidRemove(){
        SongList songs = new SongList();
        songs.addSong(new Song("StOnEr P@rTY", "Jason"));
        try{
            songs.removeSong(9);
            fail("Should throw exception");
        }catch(InvalidIndexException e){


        }catch(ListEmptyExceptions e){
            fail("should throw invalidIndexException");
        }

    }

    @Test
    public void testEmptyRemove(){
        SongList songs = new SongList();

        try{
            songs.removeSong(9);
            fail("Should throw exception");
        }catch(InvalidIndexException e){
            fail("Should throw ListEmptyException");


        }catch(ListEmptyExceptions e){

        }

    }




    @Test
    public void testShufffleEmptyList(){
        SongList songs = new SongList();
        songs.shufflePlaylist();
        assertEquals(songs.getSongs().size(),0);

    }

}
