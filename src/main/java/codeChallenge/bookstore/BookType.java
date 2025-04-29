package codeChallenge.bookstore;

/**
 * @author trinapal
 */
public interface BookType {
    public  void displayDetails();

    // Checkout behavior can vary (e.g. shipping or download)
    public double calculateFinalPrice();  // includes shipping or discounts

    public  String getDeliveryDetails(); // download link or shipping note
}
