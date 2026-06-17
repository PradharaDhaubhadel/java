package week24;
import java.io.Serializable;

public class Car extends Vehicle implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int seats;
    private double fuelEfficiency; 
    private double tankCapacity;

    public Car(String name, int speed, int seats, double fuelEfficiency, double tankCapacity) 
    {
        super(name, speed);
        this.seats = seats;
        this.fuelEfficiency = fuelEfficiency;
        this.tankCapacity = tankCapacity;
    }

    public double calculateRange() 
    {
        return fuelEfficiency * tankCapacity;
    }

    public int getSeats() {
        return seats;
    }

    public double getFuel() {
        return fuelEfficiency;
    }

    public double getTank() {
        return tankCapacity;
    }
    
    @Override
    public String getInfo()
    {
        return super.getInfo() + ", Seats: " + seats + ", Fuel Efficiency: " + fuelEfficiency + " km/l" + ", tankCapacity: " + tankCapacity + " litres";
    }
}