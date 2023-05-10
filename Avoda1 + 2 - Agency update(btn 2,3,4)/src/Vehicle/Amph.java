package Vehicle;
//Amphibious vehicle
//Delegator(composition) DP
public class Amph extends Vehicle implements Land, Motor, Water{
    Water_c water;
    Land_c land;
    private int fuel_usage;
    private int lifetime;

    public Amph(String model,  int maxSpeed,int maxPass, int lifetime, int wheels, String flag, int wind_dir, int fuel, int life)
    {
        super(0, model, maxPass, maxSpeed);//Same Grandfather
        water = new Water_c(model, maxPass, maxSpeed, flag, wind_dir);
        land = new Land_c(model, maxSpeed, maxPass, lifetime, wheels, "road");
        set_fuel_usage(fuel);
        set_lifetime(life);
    }
    public String get_model(){return water.get_model_name();}
    public boolean wind_dir(int num){return water.wind_dir(num);}//True with, Flase against
    public void set_wind_dir(int wind_dir){water.set_wind_dir(wind_dir);}
    public String get_flag(){return water.get_flag();}//return the name of the flag 
    public void set_flag(String flag){water.set_flag(flag);}
    public String print_wind(){return water.print_wind();}
    public int get_wheels(){return land.get_wheels();}
    public String get_road(){return land.get_road();}
    public void set_fuel_usage(int num){this.fuel_usage = num;}//How much gassoline the vehicle use 
    public int get_fuel_usage(){return fuel_usage;}
    public void set_lifetime(int num){this.lifetime = num;}
    public int get_lifetime(){return this.lifetime;}
    public boolean equal(Object other)
    {
        Amph a = (Amph)other;
        if(!water.equal((Water_c)other)){return false;}
        if(!land.equal((Land_c)other)){return false;}
        if(this.fuel_usage != a.fuel_usage){return false;}
        if(this.lifetime != a.lifetime){return false;}
        return true;
    }
    public String toString()
    {
        String myString = "AMPH: " + land.toString() + " " +  "Fuel:" + this.get_fuel_usage() + "Life: " + this.get_lifetime() + "Flag: " + this.get_flag();
        return myString;       
    }

    
    
}
