package LambdasAndMethodReferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class LambdasAndMethodReferences {
    public static void main(String[] args) {
        //staticMR();
        //boundMR();
        //unboundMR();
        constructorMR();
    }

    public static void staticMR() {
        List<Integer> list = new ArrayList<>(List.of(1,2,7,4,5));
        Consumer<List<Integer>> myConsumer = l -> Collections.sort(l);
        myConsumer.accept(list);
        list.forEach(System.out::print);

        System.out.println();
        System.out.println("-----------------");

        list = new ArrayList<>(List.of(1,2,7,4,5));
        Consumer<List<Integer>> MrConsumer = Collections::sort;
        MrConsumer.accept(list);
        list.forEach(System.out::print);
    }

    public static void boundMR() {
        String name = "Mr. Joe Bloggs";
        Predicate<String> lambdaCheck = n -> name.startsWith(n);
        System.out.println(lambdaCheck.test("Mr."));
        System.out.println(lambdaCheck.test("Ms."));

        Predicate<String> MRcheck = name::startsWith;
        System.out.println(MRcheck.test("Mr."));
        System.out.println(MRcheck.test("Ms."));

    }

    public static void unboundMR() {
//        Predicate<String> isEmptyLambda = str -> str.isEmpty();
//        System.out.println(isEmptyLambda.test(""));
//        System.out.println(isEmptyLambda.test("sadf"));
//
//        Predicate<String> isEmptyMR = String::isEmpty;
//        System.out.println(isEmptyMR.test(""));
//        System.out.println(isEmptyMR.test("dfa"));

        BiPredicate<String, String> startsWith = (str1, str2) -> str1.startsWith(str2);
        System.out.println(startsWith.test("Mr. Joe Bloggs", "Mr."));
        System.out.println(startsWith.test("Mr. Joe Bloggs", "Ms."));

        BiPredicate<String,String> startsWithMR = String::startsWith;
        System.out.println(startsWithMR.test("Mr. Joe Bloggs", "Mr."));
        System.out.println(startsWithMR.test("Mr. Joe Bloggs", "Ms."));



    }

    public static void constructorMR() {
        Supplier<List<String>> listSupplier = () -> new ArrayList<>();
        List<String> list = listSupplier.get();
        list.add("Lambda");
        System.out.println(list);

        Supplier<List<String>> listSupplierMR = ArrayList::new;
        List<String> listMR = listSupplierMR.get();
        listMR.add("Method Reference");
        System.out.println(listMR);

        Function<Integer, List<String>> listLambda = capacity -> new ArrayList<>(capacity);
        List<String> listWithCapacity = listLambda.apply(10);
        listWithCapacity.add("Lambda - 10");
        System.out.println(listWithCapacity);

        Function<Integer, List<String>> listMethodRef = ArrayList::new;
        List<String> list4 = listMethodRef.apply(30);
        list4.add("Method Reference with Capacity");
        System.out.println(list4);
    }
}
