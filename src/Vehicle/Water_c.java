package Vehicle;

public class Water_c extends Vehicle implements Water {
    private String flag;
    private boolean wind_dir;

    public Water_c(String model, int maxPass, int maxSpeed, String flag, int wind_dir)
    {
        super(0, model, maxPass, maxSpeed);
        set_wind_dir(wind_dir);
        set_flag(flag);
    }
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
    @Override
    public boolean equal(Object other) {
        Water_c f = (Water_c)other;//convert to jeep class
        if(!this.get_model_name().equals(get_model_name())){return false;}
        if(this.wind_dir != f.wind_dir){return false;}
        if(this.get_flag() != f.get_flag()){return false;}
        if(this.get_max_pass() != f.get_max_pass()){return false;}
        if(this.get_max_speed() != f.get_max_speed()){return false;}
        return true;
    }
    public String toString()
    {
        String myString = super.toString() + " " + "Flag: " + this.get_flag() + " " + "Wind: " + this.wind_dir;
        return myString;
    }
}
