package frsp.Model;

import frsp.FRSP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Booking
{

    private String customerID;
    private long bookingID;
    private String origin;
    private String destination;
    private String departureDate;
    private String arivalDate;
    private String flightName;
    
    Booking(){
        customerID = null;
        origin = null;
        destination = null;
        departureDate = null;
        arivalDate = null;
        flightName = null;
    }
    public Booking(String customerID, String origin, String destination,String departureDate,String arivalDate,String flightName){
        this.customerID = customerID;
        this.bookingID = System.currentTimeMillis();
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arivalDate = arivalDate;
        this.flightName = flightName;
    }
    
    public double getMiles(){
        if((origin.equals("New York, USA") && destination.equals("Florida, USA")) || (origin.equals("Florida, USA") && destination.equals("New York, USA")))
            return 30.5;
        if((origin.equals("New York, USA") && destination.equals("Texas, USA")) || (origin.equals("Texas, USA") && destination.equals("New York, USA")))
            return 46.8;
        if((origin.equals("New York, USA") && destination.equals("California, USA")) || (origin.equals("California, USA") && destination.equals("New York, USA")))
            return 87.7;
        if((origin.equals("Florida, USA") && destination.equals("Texas, USA")) || (origin.equals("Florida, USA") && destination.equals("Texas, USA")))
            return 67.7;
        if((origin.equals("Florida, USA") && destination.equals("California, USA")) || (origin.equals("California, USA") && destination.equals("Texas, USA")))
            return 77.7;
        if((origin.equals("Texas, USA") && destination.equals("California, USA")) || (origin.equals("California, USA") && destination.equals("Texas, USA")))
            return 44.7;
        return 0.0;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }


    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getArivalDate() {
        return arivalDate;
    }

    public void setArivalDate(String arivalDate) {
        this.arivalDate = arivalDate;
    }
    public static String removeElement(String id) throws FileNotFoundException, IOException{
        BufferedReader b = new BufferedReader(new FileReader("Booking.dat"));
        String d = b.readLine();
        String[] allB = d.split("£");
        ArrayList<String> data = new ArrayList<String>(Arrays.asList(allB));
        data.removeIf(e->e.contains(id));
        b.close();
        String temp = "";
        for(int i = 0;i<data.size();i++){
            if(!data.get(i).equals(""))
                temp+="£"+data.get(i);
        }
        return temp;
    }
    public static void addData(String s){
        try {
            BufferedWriter fe = new BufferedWriter(new FileWriter("Booking.dat"));
            fe.write(s);
            fe.close();
        } catch (IOException ex) {
            Logger.getLogger(FRSP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String toString(){
        return "£"+customerID+"%"+bookingID+"%"+origin+"%"+destination+"%"+departureDate+"%"+arivalDate+"%"+flightName+"%";
    }
}
