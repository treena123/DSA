package codeChallenge.bookstore;

/**
 * @author trinapal
 */
public class PrintedBook implements BookType{

    @Override
    public void displayDetails() {

    }

    @Override
    public double calculateFinalPrice() {
        return 0;
    }

    @Override
    public String getDeliveryDetails() {
        return "";
    }

    public double weight(){
        return 0;
    }

    public double shiipingCost(){
        return 0;
    }

    public double dimensions(){
        return 0;
    }
}
