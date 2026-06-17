package week24;
import java.io.Serializable;

public abstract class Vehicle implements Serializable
{
    private static final long serialVersionUID = 1L;
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