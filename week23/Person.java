package week23;


/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Person
{
    protected String name;
    protected int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void showBasicInfo()
    {
        System.out.println("Name: " + name + " Age: " + age);
    }

    public abstract String performRole();
}