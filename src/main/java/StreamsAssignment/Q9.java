package StreamsAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Q9 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(List.of(
                new Person("Bob", 32),
                new Person("Paul", 32),
                new Person("John", 33)
        ));




        double aveAge = people.stream()
                .filter(person -> person.getAge() < 30)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);

        System.out.println("Average Age: " + aveAge);
    }
}
