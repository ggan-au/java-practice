package StreamsAssignment;

import java.util.ArrayList;
import java.util.List;

public class Q6 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>(List.of(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0)
        ));

        books.stream()
                .filter(book -> book.getPrice() > 10)
                        .mapToDouble(Book::getPrice).average().ifPresent(System.out::println);

        double booksAve = books.stream()
                .filter(book -> book.getPrice() > 90)
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("Answer: " + booksAve);
    }
}
