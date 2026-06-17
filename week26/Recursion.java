package week26;
import java.util.*;

/**
 * Write a description of class REcursion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recursion
{
    public static void main(String[] args)
    {
        int fact = factorial(5);
        System.out.println("Factorial of 5 is: "+fact);
        
        int num = sum(5);
        System.out.println("sum of first 5 numbers is: "+num);
        
        int[] no = {1,2,3,4,5,6};
        System.out.println(linearSearch(no,3));
        
        System.out.println(binarySearch(no,3, 0, no.length -1));
    }
    public static int factorial(int n)
    {
        //base case
        if (n == 0 || n == 1)
        {
            return 1;
        }
        return n* factorial(n-1);
    }
    public static int sum(int n)
    {
        //base case
        if (n == 0 )
        {
            return 0;
        }
        return n+sum(n-1);
    }
    
    //linear search
    public static int linearSearch(int[] arr, int target)
    {
        if (arr == null || arr.length == 0)
        {
            return -1;
        }
        for (int i = 0; i < arr.length ; i++)
        {
            if (arr[i] == target)
            {
                return i;
            }
        }
        return -1;
    }
    
    //binary Search
    public static int binarySearch(int[] arr, int target, int left, int right)
    {
        Arrays.sort(arr);
        
        if(arr == null || arr.length == 0)
        {
            return -1;
            
        }
        while(left <= right)
        {
            int mid = (left +  right)/2;
            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    //recursive binary search
    public static int recBinarySearch(int[] arr, int target, int left, int right)
    {
        Arrays.sort(arr);
        
        //base case
        if(left > right)
        {
            return -1;
        }
        
        int mid = (left +  right)/2;
        if(arr[mid] == target)
        {
            return mid;
        }
        else if(arr[mid] < target)
        {
            return recBinarySearch(arr, target, mid+1, right);
        }
        else
        {
            return recBinarySearch(arr, target, left, mid -1);
        }
        
        
    }
}