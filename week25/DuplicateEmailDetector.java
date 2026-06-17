package week25;
import java.util.HashSet;


/**
 * Write a description of class DuplicateEmailDetector here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DuplicateEmailDetector
{
    public static void main(String[] args)
    {
        String[] allEmails = {"alice@email.com", "bob@email.com", "alice@email.com", "charlie@email.com"};
        
        HashSet<String> email = new HashSet<>();
        boolean hasDuplicate = false;
        
        for(String em: allEmails)
        {
            if(email.contains(em))
            {
                hasDuplicate = true;
                System.out.println(em);
                break;
            }
            email.add(em);
        }
        
        if(!hasDuplicate){
            System.out.println("No duplicate");
        }
    }
}