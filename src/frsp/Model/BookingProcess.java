package frsp.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BookingProcess
{
    private double noOfMiles;
    private static final double PRICE_PER_MILE = 100.0;
    private double price;
    protected Booking book;
    
    public BookingProcess(double n, Booking b){
        book = b;
        noOfMiles = n;
    }

    public double getNoOfMiles() {
        return noOfMiles;
    }

    public void setNoOfMiles(double noOfMiles) {
        this.noOfMiles = noOfMiles;
    }

    public double getPrice() {
        price = PRICE_PER_MILE*getNoOfMiles();
        return price;
    }
    public boolean verifyDate(){
        if(book.getDepartureDate().equals("") || book.getDepartureDate().equals(null) || book.getArivalDate().equals("") || book.getArivalDate().equals(null))
            return false;
        String[] d1 = book.getDepartureDate().split("-");
        String[] d2 = book.getArivalDate().split("-");
        double diff2 = (Double.parseDouble(d2[0])) + (Double.parseDouble(d2[1])/12.0) + (Double.parseDouble(d2[2])/360);
        double diff1 = (Double.parseDouble(d1[0])) + (Double.parseDouble(d1[1])/12.0) + (Double.parseDouble(d1[2])/360);
        if((diff2-diff1)>=0)
            return true;
        else
            return false;
    }
    public boolean addBooking(){
        try{
            FileWriter f = new FileWriter("Booking.dat",true);
            BufferedWriter b = new BufferedWriter(f);
            b.write(this.toString());
            b.close();
            return true;
        }catch(IOException e){
            System.out.println(e);
        }
        return false;
    }
    public String toString(){
        return book.toString()+getPrice();
    }
    
}
