package week23;
import java.util.*;


/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{
    public static void main(String[] args){
        ArrayList<Person> persons = new ArrayList<>();
        //upcasting
        Person p1 = new Student("Sandesh",18,"Computing");
        Person p2 = new Student("Saroj",30,"Programming");
        
        p1.showBasicInfo();
        p2.showBasicInfo();
        
        // specific method
        
        if(p1 instanceof Student)
        {
           Student s1 = (Student) p1;
           s1.attendClass(); 
           persons.add(s1);
        }
        
        if(p2 instanceof Teacher)
        {
            Teacher t1 = (Teacher)p2;
            t1.takeLecture();
            persons.add(t1);
        }
        
        for(Person p: persons)
        {
            if(p instanceof Teacher t)
            {
                //Teacher t=(Teacher)p;  if this then .... instanceof Teacher)
                t.showBasicInfo();
            }
            
        }
    }
}