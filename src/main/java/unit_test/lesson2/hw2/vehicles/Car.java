package unit_test.lesson2.hw2.vehicles;

public class Car extends Vehicle {
    private String company;
    private String model;
    private int yearRelease;
    private int numWheels;
    private int speed;

    public Car(String company, String model, int year) {
        this.company = company;
        this.model = model;
        this.yearRelease = year;
        this.numWheels = 4;
        this.speed = 0;
    }

    public void testDrive() {
        this.speed = 60;
    }

    public void park() {
        this.speed = 0;
    }

    public String toString() {
        return "This car is a “ + year + “ “ + make + “ “ + model + ";
    }

    // getters

    public int getNumWheels() {
        return numWheels;
    }

    public int getSpeed() {
        return speed;
    }

}