package Vehicle;

public class Jeep extends Vehicle implements Land, Motor, com {
    private String road;
    private String type_lic;
    private int wheels;
    private int lifetime;
    private int fuel_usage;

    public Jeep(String model, int maxSpeed, int lifetime, int fuel_usage)
    {
        super(0, model, 5, maxSpeed);
        set_fuel_usage(fuel_usage);
        set_lifetime(lifetime);
        this.wheels = 4;
        this.type_lic = "Mini";
        this.road = "Dirt";
    }

    //motor interface:
    public void set_fuel_usage(int num){this.fuel_usage = num;}
    public int get_fuel_usage(){return this.fuel_usage;}
    public void set_lifetime(int num){this.lifetime = num; }
    public int get_lifetime(){return this.lifetime;}
    //com interface:
    public String get_type(){return this.type_lic;}

    //Land interface:
    public int get_wheels(){return wheels;}
    public String get_road(){return this.road;}

    public String toString()
    {
        String myString = "\nJeep:\n" + super.toString() + "Road: " + get_road() + " " + "Wheels: " + get_wheels() + " " + "Lifetime: " + get_lifetime() + " " + "Type license: " + get_type() + " " + "Fuel usage: " + get_fuel_usage();
        return myString;
    }
    
    public boolean equal(Object other)
    {
        Jeep j = (Jeep)other;//convert to jeep class
        if(!this.get_model_name().equals(get_model_name())){return false;}
        if(this.fuel_usage != j.fuel_usage){return false;}
        if(this.lifetime != j.lifetime){return false;}
        if(this.get_max_speed() != j.get_max_speed()){return false;}
        return true;
    }
 

}
