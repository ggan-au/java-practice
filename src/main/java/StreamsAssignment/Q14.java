package StreamsAssignment;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Q14 {
    public static void main(String[] args) {
//        AtomicInteger ai = new AtomicInteger();
//        Stream.of(11, 11, 22, 33)
//                .parallel()
//                .filter(n -> {
//                    ai.incrementAndGet();
//                    return n % 2 == 0;
//                });
//        System.out.println(ai);

        AtomicInteger ai = new AtomicInteger();
        Stream<Integer> stream = Stream.of(11, 11, 22, 33);

        stream.parallel().filter(n -> {
                                ai.incrementAndGet();
                                return n % 2 == 0;
                                });

        stream.forEach(System.out::println);
        System.out.println(ai);
    }
}
