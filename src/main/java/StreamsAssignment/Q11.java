package StreamsAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q11 {
    public static void main(String[] args) {
        List<AnotherBook> books = new ArrayList<>(List.of(
                new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller")
        ));

        List<String> genreList = books.stream()
                .map(book -> book.getGenre())
                .toList();

        for (String genre : genreList) {
            System.out.println("Genre: " + genre);
        }
    }
}
