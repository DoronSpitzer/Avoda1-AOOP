package Vehicle;

import javax.print.attribute.standard.MediaSize.Other;

public class Bike extends Land_c implements non_motor {
    private String energy;
    private String power;

    public Bike(String model, int maxSpeed, int lifetime, String road)
    {
        super(model, maxSpeed, 1, lifetime, 2, road);
        this.energy = "A";
        this.power = "Manuel";
    }
    public String get_power(){return this.energy;}
    public String get_power2(){return this.power;}//return the power use of the bikes
    @Override
    public boolean equal(Object Other)
    {
        super.equal(Other);
        Bike b = (Bike)Other;
        if(this.get_power() != b.get_power()){return false;}
        if(this.get_power2() != b.get_power2()){return false;}
        return true;
    }
    public String toString()
    {
        String myString = "Bike" + super.toString() + "Energy: " + this.get_power() + " " + "Power: " + this.get_power2();
        return myString; 
    }

    
}
