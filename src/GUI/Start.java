package GUI;



import com.sun.org.apache.xpath.internal.SourceTree;
import exceptions.InvalidIndexException;
import exceptions.ListEmptyExceptions;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Song;
import model.SongList;
import model.SongPlayer;

import javax.xml.soap.Text;
import java.awt.*;
import java.util.ArrayList;

public class Start extends Application  {
    Button b0 = new Button("Display Songs");
    Button b1 = new Button("Add Song");
    Button b2 = new Button("Remove Song");
    Button b3 = new Button("Shuffle Playlist");
    Button sb1 = new Button("Add Song");
    Button back = new Button("back");
    Button back2 = new Button("back");
    Button back3 = new Button("back");
    Button remove = new Button("remove");
    TextField stext1 = new TextField();
    TextField stext2 = new TextField();
    TextField removeText = new TextField();
    Label notice = new Label();

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage ps) throws Exception{
        SongList songs = new SongList();

        songs.addSong(new Song("Pickle Rick REMIX SKILLREX XD ", "Jason"));
        songs.addSong(new Song("StOnEr P@rTY", "Jason"));
        songs.addSong(new Song("You spin me right round", "Gregor"));
        songs.addSong(new Song("UBC SMOKE WEED ", "Gregor"));
        songs.addSong(new Song("poo poo pee pee", "Gregor"));
        songs.addSong(new Song("STFU", "Patrick Walls"));



        ps.setTitle("Song PLayer");

//base layout

        Insets inset = new Insets(110,0,0,0);
        GridPane grid = new GridPane();
        grid.setPadding(inset);
        grid.setHgap(10);
        grid.setVgap(10);

        GridPane.setConstraints(b0,4,0);
        GridPane.setConstraints(b1,4,1);
        GridPane.setConstraints(b2,4,2);
        GridPane.setConstraints(b3,4,3);

        grid.getChildren().addAll(b0,b1,b2,b3);
        Scene startMenu = new Scene(grid,400,400);

        //Buttons actions
        sb1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Song s = new Song(stext1.getText(),stext2.getText());
                songs.addSong(s);
                returnMain(ps,startMenu);
            }
        });
//back
        back.setOnAction(e-> returnMain(ps,startMenu));
//back
        back2.setOnAction(e-> returnMain(ps,startMenu));
 //back
        back3.setOnAction(e-> returnMain(ps,startMenu));
//display song
        b0.setOnAction(e-> ps.setScene(display(songs,back)));
//Add Songs
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stext1.clear();
                stext2.clear();
                ps.setScene(addSong(sb1, back2, stext1, stext2));
            }
        });
//RemoveSong
        b2.setOnAction(e->ps.setScene(removeSong(removeText,remove,back3,notice)));
//shuffle
        b3.setOnAction(e->songs.shufflePlaylist());

        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int num = Integer.parseInt(removeText.getText());
                    songs.removeSong(num);
                    notice.setText("Song Removed!");
                } catch(NumberFormatException e){
                    notice.setText("Your Input is NOT a Number");
                }catch (InvalidIndexException e) {
                    notice.setText("Your Input Does NOT Exist");
                } catch (ListEmptyExceptions listEmptyExceptions) {
                    notice.setText("List is Empty");
                }
            }
        });


        ps.setScene(startMenu);
        ps.show();

    }

    public Scene display(SongList songs,Button back){
        int n = 0;
        VBox options = new VBox(20);
        for(Song s: songs){
            n++;
            Button b = new Button(n + ": " + s.getSongname());
            options.getChildren().add(b);
        }
        options.getChildren().add(back);
        Scene select = new Scene(options,400,400);
        return select;
    }

    public Scene addSong(Button add,Button back, TextField stext1, TextField stext2){
        Label label2 = new Label("Song Name: ");
        Label label3 = new Label("Artist Name: ");


        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(label2, stext1, label3,stext2, add,back);
        Scene addSong = new Scene(layout2,400,400);


        return addSong;
    }

    public Stage returnMain(Stage ps,Scene menu){
        ps.setScene(menu);
        return ps;
    }

    public Scene removeSong( TextField removeText,Button remove,Button back3,Label notice){
        VBox box = new VBox(20);
        Label i = new Label("Number of song you like to remove");
        box.getChildren().addAll(i,removeText,remove, back3,notice);
        Scene removeSong = new Scene(box,400,400);
        return removeSong;
    }


}
