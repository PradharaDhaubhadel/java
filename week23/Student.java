package week23;


/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student extends Person
{
    private String course;

    public Student(String name, int age, String course)
    {
        super(name, age);
        this.course = course;
    }

    @Override
    public String performRole()
    {
        return name + " studies " + course;
    }

    public String attendClass()
    {
        return name + " is attending class.";
    }
}