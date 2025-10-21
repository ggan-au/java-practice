package StreamsAssignment;

import java.util.Optional;

public class Q10 {
    public static void main(String[] args) {

        // 10 a
//        Optional<Double> price = Optional.ofNullable(null);
//
//            price.ifPresent(System.out::println);
//
//            price.ifPresentOrElse(System.out::println, () -> {
//                System.out.println("UNKNOWN");
//            });
//
//            Double output = price.orElseGet(() -> null);
//            System.out.println(output);

            //10 b

        Optional<Double> price2 = Optional.ofNullable(null);
        System.out.println(price2);
        if (price2.isEmpty()) {
            System.out.println("empty");
        }

        price2.ifPresent(System.out::println);
        Double x = price2.orElse(44.0);
        System.out.println(x);

        Optional<Double> price3 = Optional.ofNullable(null);
        try {
            Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));
            System.out.println(z);
        } catch (RuntimeException e) {
            System.out.println("Caught it");
        }

        System.out.println("Code continues here..");

    }
}
