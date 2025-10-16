package LambdasLab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class BasicLambdas {
    public static void main(String[] args) {
       // consumer();
        // supplier();
        //predicate();
       // function();
        List<Person> listPeople = getPeople();
       // sortAge(listPeople);
        sortName(listPeople);
        sortHeight(listPeople);
    }

    public static void consumer() {
        Printable<String> printer = text -> System.out.println(text);
        printer.print("Printable lambda");

        Printable<String> printerMR = System.out::println;
        printerMR.print("Printable Method Reference");
    }

    public static void supplier() {
        Retrievable<Integer> get = () -> 77;
        System.out.println(get.retrieve());
    }

    public static void predicate() {
//        Evaluate<Integer> temp = n -> n < 0;
//        System.out.println(temp.isNegative(-1));
//        System.out.println(temp.isNegative(1));
//
//        Predicate<Integer> temp2 = n -> n < 0;
//        System.out.println(temp2.test(-1));
//        System.out.println(temp2.test(1));
        Boolean output = check(4,(n) -> n % 2 == 0);
        System.out.println(output);

        Boolean output2 = check(7,(n) -> n % 2 == 0);
        System.out.println(output2);

        Boolean output3 = check("Mr. Joe Bloggs", str -> str.startsWith("Mr."));
        System.out.println(output3);

        Boolean output4 = check("Ms. Anne Bloggs", str -> str.startsWith("Mr."));
        System.out.println(output4);

        Boolean isAdult = check(33, age -> age >= 18);
        System.out.println("Is Mike an adult: " + isAdult);

        isAdult = check(13, age -> age >= 18);
        System.out.println("Is Anne an adult: " + isAdult);
    }

    public static <T> Boolean check(T input, Predicate<T> checker) {
        return checker.test(input);
    }

    public static void function() {
        Functionable<Integer, String> func = n -> "Number is: " + n;
        System.out.println(func.applyThis(25));
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    private static void sortName(List<Person> people) {
        people.sort(Comparator.comparing(Person::getName));
        people.forEach(p -> System.out.println(p.getName() + " " + p.getAge() + " " + p.getHeight()));
    }

    private static void sortAge(List<Person> people) {
        people.sort(Comparator.comparing(other -> other.getAge()));
        people.forEach(p -> System.out.println(p.getName() + " " + p.getAge() + " " + p.getHeight()));
    }

    private static void sortHeight(List<Person> people) {
        people.sort(Comparator.comparing(Person::getHeight));
        people.forEach(p -> System.out.println(p.getName() + " " + p.getAge() + " " + p.getHeight()));
    }

}
