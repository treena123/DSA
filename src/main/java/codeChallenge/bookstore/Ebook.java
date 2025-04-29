package codeChallenge.bookstore;

/**
 * @author trinapal
 */
public class Ebook implements BookType{
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

    public double fileSize(){
        return 0.0;
    }

    public String downloadLink(){
        return "";
    }
}
