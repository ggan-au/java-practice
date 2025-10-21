package StreamsAssignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1, "Screw"));
        itemList.add(new Item(2, "Nail"));
        itemList.add(new Item(3, "Bolt"));

        itemList.stream().map(Item::getName).sorted().forEach(System.out::print);

    }
}
