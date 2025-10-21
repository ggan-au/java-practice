package StreamsAssignment;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Q1 {
    public static void main(String[] args) {
        //QUESTION 1
        double ave = IntStream.range(0, 5).average().getAsDouble();
        System.out.println(ave);


    }


}
