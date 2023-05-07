package Vehicle;

public abstract class Vehicle {
    private int totalDistance;
    private String model;
    private int maxPass;
    private int maxSpeed;

    public Vehicle(int totalDistance, String model, int maxPass, int maxSpeed)
    {
        this.totalDistance = totalDistance;
        this.model = model;
        this.maxPass = maxPass;
        this.maxSpeed = maxSpeed;
    }
    public void distance_update(int distance){this.totalDistance += distance;}//updating the total distance of the vehicle
    public String get_model_name(){return this.model;}
    public int get_total_distance(){return this.totalDistance;}
    public int get_max_pass(){return this.maxPass;}
    public int get_max_speed(){return this.maxSpeed;}
    public String toString()
    {
        String myString = "Model name: " + get_model_name() + " " + "Distance: " + get_total_distance() + " " + "Max Speed: " + get_max_speed() + " " + "Total Passenger: " + get_max_pass() + " ";
        return myString;
    }
    public void distance_reset(){this.totalDistance = 0;}
    public abstract boolean equal(Object other);
    
    
}
