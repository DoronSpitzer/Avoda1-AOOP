package Vehicle;

public class drone_spy extends Vehicle implements Air, non_motor{
    private String energy;
    private String type;
    
    public drone_spy()
    {
        super(0, "Classifeid", 1, 50);
        energy = "C";
        this.type = "Military";
    }

    //Air interface:
    public void use(String type){this.type = type;}
    public String get_use(){return this.type;}

    //non-motor interface:
    public String get_power(){return energy;}

    //toString and equal:
    public String toString()
    {
        String myString = "\nSpy Drone:\n" + super.toString() + "Energy type: " + get_power() + " " + "Use for: " + get_use();
        return myString;
    }
    public boolean equal(Object other)
    {
        if(this == other){return true;}
        drone_spy d1 = (drone_spy)other;//converting
        if(this.energy == d1.energy){return true;}
        if(this.type == d1.type){return true;}
        return false;
    }
}
