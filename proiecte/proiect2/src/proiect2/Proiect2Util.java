package proiect2;

import proiect2.entities.Passenger;

import java.util.ArrayList;

public class Proiect2Util {
    //gasire pasager dint-o lista de pasageri
    public static Passenger getPassangerFromList(ArrayList<Passenger> list, String firstName, String lastName){
        for(Passenger p: list){
            if(p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)){
                return p;
            }
        }
        return null;
    }
}
