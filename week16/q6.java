package week16;
import java.util.Scanner;


/**
 * Write a description of class q6 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q6
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a strings");
        String s1 = input.nextLine().trim();
        StringBuilder sb= new StringBuilder();
        
        for(int i = s1.length() - 1; i >= 0; i--)
        {
            sb.append(s1.charAt(i));
        }
        
        String reversed= sb.toString();
        
        if(s1.equals(reversed)){
            System.out.println("The string is a palindrome");
        }
        else
        {
            System.out.println("The string is not palindrome");
        }
        
    }
}