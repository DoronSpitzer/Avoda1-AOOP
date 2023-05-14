package Vehicle;
//Vehicle that have an engine
public interface Motor {
    public void set_fuel_usage(int num);//How much gassoline the vehicle use 
    public int get_fuel_usage();
    public void set_lifetime(int num);
    public int get_lifetime();
}
