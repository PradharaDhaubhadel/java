package week23;


/**
 * Write a description of class Vehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Vehicle 
{
    private String name;
    private int speed;

    public Vehicle(String name, int speed) 
    {
        this.name = name;
        this.speed = speed;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getSpeed()
    {
        return this.speed;
    }

    public String getInfo() {
        return "Vehicle Name: " + name + ", Speed: " + speed + " km/h";
    }
}