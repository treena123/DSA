package codeChallenge.bookstore;

/**
 * @author trinapal
 */
public class BookFactory {

    public BookType getBookType(String bookType){
        if (bookType == null || bookType.isEmpty()) {
            throw new IllegalArgumentException("Book type cannot be null or empty");
        }

        switch (bookType.toLowerCase()) {
            case "ebook":
                return new Ebook();
            case "printedbook":
                return new PrintedBook();
            case "audiobook":
                return new AudioBook();
            default:
                throw new IllegalArgumentException("Unknown book type: " + bookType);
        }
    }
    }

