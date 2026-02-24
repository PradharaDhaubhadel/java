package week16;


/**
 * Write a description of class q4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q4
{
    public static void main(String[] args){
        String s1 = " HeLlO  WorlD ";
        String text = s1.trim();
        System.out.println(text);
        
        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());
        
        String[] text1 = text.split("\\s+");
        /* \\s for space \\s+ for one or many space */
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < text1.length; i++)
        {
            String first = text1[i].substring(0,1).toUpperCase();
            String rest = text1[i].substring(1).toLowerCase();
            sb.append(first).append(rest).append(" ");
        }
        System.out.println(sb.toString().trim());
        
    }
}