package week16;


/**
 * Write a description of class q2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q2
{
    public static void main(String[] args){
        String s1 = " Hello World ";
        String text = s1.trim();
        System.out.println(text);
        
        String firstTenChar = text.substring(0,10);
        System.out.println(firstTenChar);
        
        //split method
        String[] text1 = text.split("\\s");
        /* \\s for space \\s+ for one or many space */
        for(String text2: text1)
        {
            System.out.println(text2);
        }
    }
}