package week23;


/**
 * Write a description of class Car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car extends Vehicle {
    private int seats;
    private double fuelEfficiency; // km per liter
    private double tankCapacity;

    public Car(String name, int speed, int seats, double fuelEfficiency, double tankCapacity) 
    {
        super(name, speed);
        this.seats = seats;
        this.fuelEfficiency = fuelEfficiency;
        this.tankCapacity= tankCapacity;
    }

    // calculate max range based on tank capacity
    public double calculateRange() 
    {
        return fuelEfficiency * tankCapacity;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Seats: " + seats + ", Fuel Efficiency: " + fuelEfficiency + " km/l"+ ", tankCapacity: "+ tankCapacity+ "litres";
    }
}