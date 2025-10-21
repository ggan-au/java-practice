package StreamsAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q8 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>(List.of(
                new Book("Gone with the wind", 5.0),
                new Book("Gone with the wind", 10.0),
                new Book("Atlas shrugged", 15.0)
        ));

        books.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice, Double::sum))
                .forEach((title, price) -> {
                    System.out.println("Title: " + title);
                    System.out.println("Price: " + price);
                });
    }
}
