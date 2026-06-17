package week25;
import java.util.HashMap;


/**
 * Write a description of class StudentGradeTracker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentGradeTracker
{
    public static void main(String[] args)
    {
        HashMap<Integer, Integer> grade = new HashMap<>();
        grade.put(101, 85);
        grade.put(102, 92);
        grade.put(103, 78);
        
        grade.put(102, 95);
        
        grade.remove(101);
        
        if(grade.containsKey(103))
        {
            System.out.println("Score: "+grade.get(103));
        }
        
        for(Integer studId : grade.keySet())
        {
            System.out.println("ID: "+ studId+ ",Score: "+grade.get(studId));
        }
        
    }
}