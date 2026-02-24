package week16;


/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private String name;
    private int age;
    private String school;
    private int grade;
    private String citizenship;
    private String phone;
    
    public Student(String name, int age, String school, int grade, String citizenship, String phone){
        this.name = name;
        this.age = age;
        this.school = school;
        this.grade = grade;
        this.citizenship = citizenship;
        this.phone = phone;
    }
    
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getSchool(){
        return this.school;
    }
    public int getGrade(){
        return this.grade;
    }
    public String getCitizenship(){
        return this.citizenship;
    }
    public String getPhone(){
        return this.phone;
    }
    
    public String getNameInitials(){
        String nametrimmed = name.trim();
        String text[] = nametrimmed.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < text.length; i++)
        {
            String first = text[i].substring(0,1).toUpperCase();
            sb.append(first).append(".");
        }
        return sb.toString().trim();
    }
    
    @Override
    public String toString(){
        return String.format("%s|%d|Grade %d|%s",getName(),getAge(),getGrade(),getSchool());
    }
        
        
    
}