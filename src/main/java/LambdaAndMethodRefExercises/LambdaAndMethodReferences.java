package LambdaAndMethodRefExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class LambdaAndMethodReferences {
    public static void main(String[] args) {
       // unboundMR();
        constructorMR();
    }

    public static void staticMR() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,7,4,5));
        Consumer<List<Integer>> sortListLambda = li -> Collections.sort(li);
        System.out.println("List before Lambda: " + list);
        sortListLambda.accept(list);
        System.out.println("List after Lambda: " + list);

        list = new ArrayList<>(Arrays.asList(1,2,7,4,5));

        Consumer<List<Integer>> sortMR = Collections::sort;
        System.out.println("List before MR: " + list);
        sortMR.accept(list);
        System.out.println("List after MR: " + list);
    }

    public static void boundMR() {
        String name = "Mr. Joe Bloggs";
        Predicate<String> nameCheckLambda = value -> name.startsWith(value);
        System.out.println(nameCheckLambda.test("Mr."));
        System.out.println(nameCheckLambda.test("Ms."));
        Predicate<String> nameCheckMR = name::startsWith;
        System.out.println(nameCheckMR.test("Mr."));
        System.out.println(nameCheckMR.test("Ms."));
    }

    public static void unboundMR() {
        Predicate<String> unLambda = str -> str.isEmpty();
        System.out.println(unLambda.test(""));
        System.out.println(unLambda.test("ddd"));

        Predicate<String> ubMR = String::isEmpty;
        System.out.println(ubMR.test(""));
        System.out.println(ubMR.test("dd"));

        BiPredicate<String, String> biubL = (str1, str2) -> str1.startsWith(str2);
        System.out.println(biubL.test("Mr. Joe Bloggs", "Mr"));
        System.out.println(biubL.test("Mr. Joe Bloggs", "Ms"));

        BiPredicate<String, String> biMR = String::startsWith;
        System.out.println(biMR.test("Mr. Joe Bloggs", "Mr"));
        System.out.println(biMR.test("Mr. Joe Bloggs", "Ms"));

    }

    public static void constructorMR() {
        Supplier<List<String>> newAl = () -> new ArrayList<>();
        List<String> list = newAl.get();
        list.add("Lambda");
        System.out.println(list);

        Supplier<List<String>> newAlMR = ArrayList::new;
        List<String> list2 = newAlMR.get();
        list2.add("Method Reference");
        System.out.println(list2);

        Function<Integer, List<String>> funcLambda = capacity -> new ArrayList<>(capacity);
        List<String> list3 = funcLambda.apply(10);
        list3.add("Lambda");
        System.out.println(list3);

        Function<Integer, List<String>> funcMR = ArrayList::new;
        List<String> list4 = funcMR.apply(10);
        list4.add("Method Reference");
        System.out.println(list4);
    }
}
