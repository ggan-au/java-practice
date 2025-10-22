package StreamsAssignment;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Q12 {
    public static void main(String[] args) {
        DoubleStream ds = DoubleStream.of(0, 2,4);

        double s = ds.filter(n -> n % 2 != 0).sum();
        System.out.println(s);

        List<Double> myList = Arrays.asList(1.0, 3.0);

        double result = myList.stream()
                .mapToDouble(n -> n)
                .filter(n -> n % 2 == 0)
                .average()
                .orElse(0.0);


        System.out.println("Result: " + result);
    }
}
