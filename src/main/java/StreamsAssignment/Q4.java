package StreamsAssignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Q4 {
    public static void main(String[] args) {
        //QUESTION 4 - a
        int sum = IntStream.rangeClosed(1,3).sum();
        int max = IntStream.rangeClosed(1,3).max().orElseThrow();
        System.out.println("Sum: " + sum + ", Max: " + max);


        //QUESTION 4 -b
        List<Person> people = new ArrayList<>(List.of(
                new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29)
        ));

        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        int total = List.of(10, 47, 33, 23).stream()
                .reduce(Integer::sum).get();
        System.out.println("TOTAL - 1 : " + total);

        int total2 = List.of(10, 47, 33, 23).stream()
                .reduce(1000, Integer::sum);

        System.out.println("TOTAL - 2 : " + total2);



    }
}
