package Vehicle;

public class Ship extends Water_c implements com, Motor {
    String type_l;
    int fuel_usage;
    int lifetime;
    public Ship(String model, int maxPass, int maxSpeed, String flag, int fuel, int lifetime)
    {
        super(model, maxPass, maxSpeed, flag, 1);
        type_l = "Unlimited";
        set_lifetime(lifetime);
        set_fuel_usage(fuel);
    }
    public String get_type(){return type_l;}//returning the type of license(Mini, Limit, Unlimit)
    public void set_fuel_usage(int num){this.fuel_usage = num;}//How much gassoline the vehicle use 
    public int get_fuel_usage(){return this.fuel_usage;}
    public void set_lifetime(int num){this.lifetime = num;}
    public int get_lifetime(){return this.lifetime;}
    @Override
    public boolean equal(Object other)
    {
        super.equal(other);
        Ship s = (Ship)other;
        if(this.get_type() != s.get_type()){return false;}
        if(this.get_fuel_usage() != s.get_fuel_usage()){return false;}
        if(this.get_lifetime() != s.get_lifetime()){return false;}
        return true;
    }
    public String toString()
    {
        String myString = "Ship Cruise: " + super.toString() + " " + "license type:" + this.get_type() + "Fuel usage: " + this.get_fuel_usage() + " " + "Life: " + this.get_lifetime();
        return myString;
    }
    
}
