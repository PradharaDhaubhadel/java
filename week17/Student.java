package week17;


/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private String studentId;
    private String name;
    private String course;
    
    public Student(String studentId, String name, String course){
        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }
    
    public String display(){
        return "<html><body><h2><p>Student Id: "+studentId+
                "<br>Student Name: "+name+
                "<br>Course: "+course+"</p></h2></body></html>";
    }
}