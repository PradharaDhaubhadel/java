package week25;
import java.util.LinkedList;


/**
 * Write a description of class PlayListManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayListManager
{
    public static void main(String[] args)
    {
        LinkedList<String> playlist = new LinkedList<>();
        playlist.add("Bohemian Rhapsody");
        playlist.add("Blinding Lights");
        playlist.add("Imagine");
        
        playlist.addFirst("Billie Jean");
        
        playlist.addLast("Rolliong in the Deep");
        
        playlist.remove(1);
        
        for(String songs: playlist)
        {
            System.out.print(songs);
    }
    }
}