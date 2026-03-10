package week18;
import java.util.ArrayList;


/**
 * Write a description of class Students here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Students
{
    private int id;
    private String name;
    private String gender;
    private String skill;
    private String course;

    public static ArrayList<Students> studentList = new ArrayList<>();

    // Constructor
    public Students(int id, String name, String gender, String skill, String course) {
        this.id     = id;
        this.name   = name;
        this.gender = gender;
        this.skill  = skill;
        this.course = course;
    }

    // Getters
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getGender(){
        return this.gender;
    }

    public String getSkill(){
        return this.skill;
    }

    public String getCourse(){
        return this.course;
    }
    
  
}