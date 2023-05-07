package Vehicle;

public class Fregata extends Vehicle implements Water, Motor {
    private int fuel_avg;
    private int lifetime;
    private String flag;
    private boolean wind_dir;

    public Fregata(String model, int wind, int maxPass, int maxSpeed)
    {
        super(0, model, maxPass, maxSpeed);
        set_lifetime(4);
        set_fuel_usage(500);
        set_wind_dir(wind);
        set_flag("Israel");
        
 
    }

    //water interface:
    public boolean wind_dir(int num)
    {
        if(num == 1){
            return true;
        }
        return false;//else
    }
    public void set_wind_dir(int wind_dir)
    {
        if(wind_dir(wind_dir)){this.wind_dir = true;}
        this.wind_dir = false;
    }
    public void set_flag(String flag){this.flag = flag;}
    public String get_flag(){return this.flag;}
    public String print_wind(){
        String myStr = null;
        if(this.wind_dir){
            myStr = "With the wind";
            return myStr;
        }
        myStr = "Against the wind";
        return myStr;
    }

    //motor interface:
    public void set_fuel_usage(int num)
    {
        fuel_avg = super.get_total_distance() * num;
    }
    public int get_fuel_usage(){return fuel_avg;}
    public void set_lifetime(int num){this.lifetime = num;}
    public int get_lifetime(){return this.lifetime;}

    //String and equal method:
    public String toString()
    {
        String myString = "\nFregata:\n" + super.toString() + " " + "Fuel average: " + get_fuel_usage() + " " + "Unter the flag of: " + get_flag() + " " + "Lifetime: " + get_lifetime() + " " + print_wind();
        return myString;
    }

    public boolean equal(Object other)
    {
        Fregata f = (Fregata)other;//converting
        if(!this.get_model_name().equals(get_model_name())){return false;}
        if(this.wind_dir != f.wind_dir){return false;}
        if(this.get_flag() != f.get_flag()){return false;}
        if(this.get_fuel_usage() != f.get_fuel_usage()){return false;}
        if(this.get_max_pass() != f.get_max_pass()){return false;}
        if(this.get_max_speed() != f.get_max_speed()){return false;}
        return true;
    }
    
}
