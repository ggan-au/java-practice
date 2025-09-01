package FileManipulations;

import static FileManipulations.StaticUtils.*;

public class SerializeExample {
    public static void main(String[] args) {
//        Employee e1 = new Employee("Bob", "Johnson", 30);
//        System.out.println(e1);
//        serializeObject(e1, "./data/" + e1.getFirstName() + ".ser");

        String file = "./data/Bob.ser";
        Employee o = (Employee) getSerializedObject(file);
        System.out.println(o);
    }


}
