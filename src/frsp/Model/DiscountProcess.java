package frsp.Model;

public class DiscountProcess extends BookingProcess
{
    private double discount;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public DiscountProcess(double discount,double d,Booking b){
        super(d,b);
        this.discount = discount;
    }
    @Override
    public double getPrice() {
        double discountedPrice = super.getPrice()*(getDiscount()/100.0);
        return discountedPrice;
    }
    public static boolean compareDate(String date1, String date2){
        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");
        double diff2 = (Double.parseDouble(d2[0])) + (Double.parseDouble(d2[1])/12.0) + (Double.parseDouble(d2[2])/360);
        double diff1 = (Double.parseDouble(d1[0])) + (Double.parseDouble(d1[1])/12.0) + (Double.parseDouble(d1[2])/360);
        if((diff2-diff1)>0)
            return true;
        else
            return false;
    }
    public String toString(){
        return book.toString()+getPrice();
    }
}