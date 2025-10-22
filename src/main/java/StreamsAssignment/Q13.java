package StreamsAssignment;

import java.util.Arrays;
import java.util.List;

public class Q13 {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);

        boolean match = ls.stream().distinct().anyMatch(num -> num == 11);
        System.out.println(match);

        boolean match2 = ls.stream().noneMatch(x -> x % 11 > 0);
        System.out.println(match2);
    }
}
