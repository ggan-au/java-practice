package StreamsAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q7 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>(List.of(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Night", 5.0),
                new Book("Gone with the wind", 5.0)
        ));

        Map<String, Double> bookMap = books.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice));

        bookMap.forEach((key, value) -> {
            if (key.startsWith("A")) {
                System.out.println("Book price: " + value + " " + key);
            }
        });
    }
}
