package FileManipulations;

import java.io.*;

public class StaticUtils {
    public static void serializeObject(Object o, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(o);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getSerializedObject(String fileName) {
        Object o = null;

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn);) {
            o = in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return o;
    }
}
