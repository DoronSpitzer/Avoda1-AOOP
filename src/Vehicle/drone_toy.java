package Vehicle;

public class drone_toy extends Vehicle implements Air, non_motor{
    private String energy;
    private String type;

    public drone_toy(String model)
    {
        super(0, model, 0, 10);
        energy = "A";
        this.type = "Toy";
    }
    //Air interface:
    public void use(String type){this.type = type;}
    public String get_use(){return this.type;}

    //non-motor interface:
    public String get_power(){return energy;}

    //toString and equal:
    public String toString()
    {
        String myString = "\nToy Drone:\n" + super.toString() + "Energy type: " + get_power() + " " + "Use for: " + get_use();
        return myString;
    }
    public boolean equal(Object other)
    {
        drone_toy d1 = (drone_toy)other;//converting
        if(this.get_model_name() == d1.get_model_name()){return true;}
        else{return false;}
    }
}
