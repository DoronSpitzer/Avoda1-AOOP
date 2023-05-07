package Vehicle;

public class Land_c extends Vehicle implements Land{
    private int wheels;
    private String road;
    
    public Land_c(String model, int maxSpeed,int maxPass, int lifetime, int wheels, String road)
    {
        super(0, model, maxPass, maxSpeed);

    }
    public int get_wheels(){return wheels;}
    public String get_road(){return this.road;}
    @Override
    public boolean equal(Object other) {
        Land_c j = (Land_c)other;//convert to jeep class
        if(!this.get_model_name().equals(get_model_name())){return false;}
        if(this.get_max_speed() != j.get_max_speed()){return false;}
        if(this.get_wheels() != j.get_wheels()){return false;}
        if(this.get_road() != j.get_road()){return false;}
        return true;       
    }
    public String toString()
    {
        String myString = super.toString() + " " + "Wheels:" + this.get_wheels() + " " + "Road:" + this.get_road();
        return myString;
    }

}
