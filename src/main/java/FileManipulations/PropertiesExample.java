package FileManipulations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.Properties;

public class PropertiesExample {

    public static void main(String[] args) {
//        saveProperties();
        readProperties();
    }

    private static void readProperties() {

        try (FileInputStream fis = new FileInputStream("./data/config.properties")) {
            Properties p = new Properties();
            p.loadFromXML(fis);
            System.out.println(p.getProperty("firstName"));
            System.out.println(p.getProperty("lastName"));
            System.out.println(p.getProperty("age"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveProperties() {

        try (FileOutputStream fos = new FileOutputStream("./data/config.properties")) {
            Properties p = new Properties();
            p.setProperty("firstName", "Bob");
            p.setProperty("lastName", "Johnson");
            p.setProperty("age", "35");

            p.storeToXML(fos, "This is my employee");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
