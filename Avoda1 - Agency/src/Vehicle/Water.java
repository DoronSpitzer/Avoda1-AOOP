package Vehicle;
//interface of water vehicle


public interface Water {
    public boolean wind_dir(int num);//True with, Flase against
    public void set_wind_dir(int wind_dir);
    public String get_flag();//return the name of the flag 
    public void set_flag(String flag);
    public String print_wind();
}
