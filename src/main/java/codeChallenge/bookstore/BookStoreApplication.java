package codeChallenge.bookstore;

/**
 * @author trinapal
 */
public class BookStoreApplication {
    public static void main(String[] args) {
        BookFactory bookFactory = new BookFactory();
        //order for each book type
        bookFactory.getBookType("ebook");
    }
}
