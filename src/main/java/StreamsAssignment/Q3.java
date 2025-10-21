package StreamsAssignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Q3 {
    public static void main(String[] args) {
        Stream<List<String>> listStream = Stream.of(
                Arrays.asList("a", "b"),
                Arrays.asList("a", "c"));

        listStream
                .flatMap(List::stream)
                .filter(ch -> ch.contains("c"))
                .forEach(System.out::print);
    }
}
