package week16;
import java.util.Scanner;


/**
 * Write a description of class q5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q5
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a strings");
        String s1 = input.nextLine();
        
        System.out.println("Enter next strings");
        String s2 = input.nextLine();
        
        StringBuilder sb = new StringBuilder();
        sb.append(s1).append(s2);
        System.out.println(sb);
        
        sb.append(1).append("#");
        System.out.println(sb);
        
        
        
        
    }
}