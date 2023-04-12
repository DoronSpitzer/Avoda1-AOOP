//Doron Spitzer 313262594
//Maya Rozenberg 313381600

import Vehicle.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Agency {
    public static void main(String[] args)
    {
        //A way to do dynamic aray without an input of size from the
        ArrayList<Vehicle> agency = new ArrayList<Vehicle>();
        System.out.println("Welcome to the Vehicle Agency: You are welcome to build your own agency!");
        int input = 0, index = 0;
        Vehicle temp = null;
        agency = agency_init(input, index, temp);
        Scanner sc = new Scanner(System.in);
        if(agency.size() != 0)
        {
            main_menu();
            int cho = input_main_menu();
            do {
                switch(cho)
                {   //Purchasing vehicle
                    case 1:
                        System.out.print("Available cars:");
                        print_cars(agency);
                        System.out.println("1)Jeep\n2)Feregata\n3)Toy drone\n4)Army drone\n0)TO EXIT");
                        input = input();
                        temp = make_vehicle(input);
                        index = vehicle_exits(temp, agency);
                        if(index != -1){
                            agency.remove(agency.get(index));//erase the object from the array
                            System.out.println("Congratz! The purchase was made successfully!");
                        }
                        else{System.out.println("There is no such vehicle in the system");}
                        break;
                    //Test drive:    
                    case 2:
                        int test_dis;
                        print_cars(agency);
                        System.out.println("1)Jeep\n2)Feregata\n3)Toy drone\n4)Army drone\n0)TO EXIT");
                        input = input();
                        temp = make_vehicle(input);
                        index = vehicle_exits(temp, agency);//index of the location of the vehicle in the array
                        if(index != -1){
                            System.out.println("Enjoy your test drive!");
                        }
                        else{
                            System.out.println("There is no such vehicle in the system");
                            break;
                        }
                        index = vehicle_exits(temp, agency);
                        System.out.println("How many km did you traveled?");
                        test_dis = sc.nextInt();
                        agency.get(index).distance_update(test_dis);
                        System.out.println("Vehicle updated info:\n" + temp);
                        break;
                    //Distance reset:    
                    case 3:
                        agency_distance_reset(agency);
                        System.out.println("Distance reseted\nUpdated info:\n");
                        print_cars(agency);
                        break;
                    //Chage flag:    
                    case 4:
                        String new_flag;
                        System.out.println("Witch flang would you like to changed to?");
                        new_flag = sc.next();
                        flag_changed(new_flag, agency);
                        print_water_ve(agency);
                        break;
                    default:
                        main_menu();
                        cho = input_main_menu();
                        break;
                }
                main_menu();
                cho = input_main_menu();
            } while (cho != 0);
        }
        else{
            System.out.println("There is no vehicle in the ageceny at the moment.");
        }
        System.out.println("Bye Bye!");
        sc.close();
    }
    
    public static ArrayList<Vehicle> agency_init(int input, int index, Vehicle temp)
    {
        ArrayList<Vehicle> arr = new ArrayList<Vehicle>();
        System.out.println("What kind of vehicle would you like to add to the Agency?");
        System.out.println("1)Jeep\n2)Feregata\n3)Toy drone\n4)Army drone\n0)TO EXIT");
        int cho = input();
        int flag1 = 0;
        do
        {
            switch(cho)
            {
                case 0:
                    System.out.println("Bye Bye!");
                    break;
                case 1:
                    temp = make_vehicle(cho);
                    arr.add(temp);
                    flag1 = 1;
                    break;
                case 2:
                    temp = make_vehicle(cho);
                    arr.add(temp);
                    flag1 = 1;
                    break;
                case 3:
                    temp = make_vehicle(cho);
                    arr.add(temp);
                    flag1 = 1;
                    break;
                case 4:
                    temp = make_vehicle(cho);
                    arr.add(temp);
                    flag1 = 1;
                    break;
                default:
                    break; 
            }
            if(flag1 != 0)
            {
                System.out.println("1)Jeep\n2)Feregata\n3)Toy drone\n4)Army drone\n0)TO EXIT");
                cho = input();
            }
        }while(cho != 0);
        return arr;
    }

    public static int input()
    {
        Scanner sc = new Scanner(System.in);
        int cho = sc.nextInt();
        while(cho > 4 && cho < 0){
            System.out.println("Input out of bounds, try again:");
            cho = sc.nextInt();
            sc.close();
        }
        return cho;
        
    }
    public static void main_menu()
    {
        System.out.println("\n1)For purchase a vehicle\n2)For test drive\n3)For erasing distance travel\n4)Change marine vehicle flang\n\5)EXIT");

    }

    //Check if the input is valid and return the choosen number
    public static int input_main_menu()
    {
        Scanner sc = new Scanner(System.in);
        int cho = sc.nextInt();
        while(cho > 5 && cho < 0){
            System.out.println("Input out of bounds, try again:");
            cho = sc.nextInt();
        }
        return cho;
    }
    public static Vehicle make_vehicle(int num)
    {
        String name;
        int input;
        Vehicle temp = null;
        Scanner sc = new Scanner(System.in);
        switch(num)
        {
            case 1:
                System.out.println("You choose JEEP, please input(orderwise): Model name, Max speed, Engine lifetime, and Fuel usage:");
                temp = new Jeep(name = sc.next(), input = sc.nextInt(), input = sc.nextInt(),input = sc.nextInt());
                break;
            case 2:
                System.out.println("You choose FREGATA, please input(orderwise): Model name, Wind direction , Max passenger and Max speed");
                temp = new Fregata(name = sc.next(), input = sc.nextInt(),input = sc.nextInt(), input = sc.nextInt());
                break;
            case 3:
                System.out.println("You choose Toy drone, please Model name");
                temp = new drone_toy(name = sc.next());
                break;
            case 4:
                System.out.printf("You choose Army drone:");
                temp = new drone_spy();
                break;
            default:
                break;
        }
        return temp;
    }
    public static void print_cars(ArrayList<Vehicle> arr)
    {
        for(int i = 0; i < arr.size(); i++)
        {
            System.out.println(arr.get(i) + "\n");
        }
    }
    public static int vehicle_exits(Vehicle obj, ArrayList<Vehicle> arr)
    {
        for(int i = 0; i < arr.size(); i++)
        {
            if(arr.get(i) instanceof Jeep  && obj instanceof Jeep)
            {
                if(((Jeep)arr.get(i)).equal((Jeep)obj))
                {
                    return i;
                }
            }
            if(arr.get(i) instanceof Fregata  && obj instanceof Fregata)
            {
                if(((Fregata)arr.get(i)).equal((Fregata)obj))
                {
                    return i;
                }
            }
            if(arr.get(i) instanceof drone_spy  && obj instanceof drone_spy)
            {
                if(((drone_spy)arr.get(i)).equal((drone_spy)obj))
                {
                    return i;
                }
            }
            if(arr.get(i) instanceof drone_toy  && obj instanceof drone_toy)
            {
                if(((drone_toy)arr.get(i)).equal((drone_toy)obj))
                {
                    return i;
                }
            }
        

        }
        return -1;
    }
    public static void agency_distance_reset(ArrayList<Vehicle> arr)
    {
        for(int i = 0; i < arr.size(); i++)
        {
            arr.get(i).distance_reset();
        }
    }

    public static void flag_changed(String flag, ArrayList<Vehicle> arr)
    {
        for(int i = 0; i < arr.size(); i++)
        {
            if(arr.get(i) instanceof Water)
            {
                ((Water)arr.get(i)).set_flag(flag);
            }
        }
    }
    public static void print_water_ve(ArrayList<Vehicle> arr)
    {
        for(int i = 0; i < arr.size(); i++)
        {
            if(arr.get(i) instanceof Water)
            {
                System.out.println((Water)arr.get(i));
            }
        }
    }
}

  
