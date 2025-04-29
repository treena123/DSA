package codeChallenge.bookstore;

/**
 * @author trinapal
 */
public class AudioBook implements BookType{
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

    public String narrator(){
    return "";
    }

    public int lengthInMinutes(){
    return 0;
    }

    public String audioSampleUrl(){
        return "";
    }
}
