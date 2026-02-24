package week16;
import java.util.Scanner;


/**
 * Write a description of class q1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q1
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter any two strings");
        String s1 = input.nextLine();
        String s2 = input.nextLine();
        
        String text = s1.concat(s2);
        System.out.println(text);
        
        System.out.println("Enter a string");
        String s3 = input.nextLine();
        
        System.out.println(text.equals(s3));
        
    }
}