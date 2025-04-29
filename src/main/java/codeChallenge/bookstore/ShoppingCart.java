package codeChallenge.bookstore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author trinapal
 */
public class ShoppingCart {
    Map<Book, Integer> bookQuantityMap = new HashMap<>();
    public void add(Book book, int count){
        if (book == null || count <= 0) {
            throw new IllegalArgumentException("Book must be valid and count must be positive.");
        }
        bookQuantityMap.put(book,bookQuantityMap.getOrDefault(book, 0) +count);
    }

    public void remove(Book book, int count){
        if (book == null || count <= 0) {
            throw new IllegalArgumentException("Book must be valid and count must be positive.");
        }
        int currentCount = bookQuantityMap.getOrDefault(book, 0);
        if (currentCount == 0) {
            System.out.println("Book not found in cart.");
            return;
        }

        if (currentCount <= count) {
            bookQuantityMap.remove(book);
        } else {
            bookQuantityMap.put(book, currentCount - count);
        }
    }
    public  Map<Book, Integer> getCartItems(){
       return Collections.unmodifiableMap(bookQuantityMap);
    }
    //total cartValue
    public double getTotalPrice() {
        return bookQuantityMap.entrySet().stream().mapToDouble(each -> each.getKey().getPrice()* each.getValue()).sum();
    }

    // Checkout and clear cart
    public Map<Book, Integer> checkout(Book book, int count){
        System.out.println("Checkout Summary:");
        for (Map.Entry<Book, Integer> entry : bookQuantityMap.entrySet()) {
            Book each = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("%s x %d = $%.2f%n", book.getTitle(), quantity, book.getPrice() * quantity);
        }

        System.out.printf("Total: $%.2f%n", getTotalPrice());

        Map<Book, Integer> cartSnapshot = new HashMap<>(bookQuantityMap);
        bookQuantityMap.clear();
        return cartSnapshot;
    }
}
