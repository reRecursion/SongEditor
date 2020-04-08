package model;

import exceptions.InvalidIndexException;
import exceptions.PlaylistExistException;
import exceptions.RemoveListExceptions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class SongPlayer {
    //private Map<String, SongList> playlist;
    private SongList selected;
    public HashSet<Song> history;


    public SongPlayer() {
        Scanner scanner = new Scanner(System.in);

        String input = "";


        PlayLists playLists = new PlayLists();
        this.selected = playLists.selectPlaylist();

        while (true) {

            menu();

            input = scanner.nextLine();
            if (input.equals("0")) {
                selected.shufflePlaylist();
            }

            if (input.equals("1")) {
                selected.printSongs();
            }

            if (input.equals("2")) {
                String input2;
                System.out.println("Song Name:");
                input = scanner.nextLine();
                System.out.println("Artist name:");
                input2 = scanner.nextLine();

                Song s = new Song(input, input2);


                selected.addSong(s);

            }

            if (input.equals("3")) {
                int i;
                System.out.println("Which song would you like to remove?");
                i = scanner.nextInt();
                try {
                    selected.removeSong(i);
                } catch (InvalidIndexException e) {
                    System.out.println("Song does no exist within current list!");
                } catch (RemoveListExceptions e) {
                    System.out.println("Song list is in trouble");
                } finally {
//                    System.out.println("There is currently" + songs.songs.size() + "Songs in the list");
                }
            }

            if(input.equals("add")){

            }

            if(input.equals("addall")){
                System.out.println("Which song would you like to add?");
                input = scanner.nextLine();
                String input2 = scanner.nextLine();
                Song oo= new Song(input,input2);
                selected.addB(oo);

            }

            if(input.equals("switch")){
                this.selected = playLists.selectPlaylist();
            }

            if (input.equals("quit")) {
                break;
            }


        }
    }

    public void menu() {
        System.out.println("What would you like to do?");
        System.out.println("[0] Shuffle Songlist");
        System.out.println("[1] Display SongList");
        System.out.println("[2] Add Songs");
        System.out.println("[3] Remove Songs");
        System.out.println("[addall] Add Songs To Both Playlist and song");
        System.out.println("[switch] Switch Playlist");
        System.out.println("[quit] to exit");
    }


}
