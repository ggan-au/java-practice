package FileManipulations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File dir = new File("./data/mydir/mydir2");
        File dir2 = new File("./data");

        File[] list = dir2.listFiles();
        System.out.println("-------------------");
        for (File f : list) {
            if (f.isDirectory()) {
                System.out.println("-dir "+f.getName());
            } else {
                System.out.println("-file "+f.getName());
            }
        }

        System.out.println("-------------------");


        if (dir.mkdirs()) {
            System.out.println("Dir: " + dir.getAbsolutePath() + " created");
        } else {
            System.out.println("Dir: " + dir.getAbsolutePath() + " failed");
        }

        File f = new File(dir.getAbsolutePath() + "/file.txt");

        try (FileWriter fw = new FileWriter(f);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.print("Hello ");
            pw.print("there.");
            pw.println();
            pw.println("This is another line!");

            System.out.println("File: " + f.getAbsolutePath() + " has been created");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Path path = Paths.get(f.getAbsolutePath());
        String s = Files.readString(path, Charset.forName("ISO-8859-1"));

        Stream<String> stream = Files.lines(path);

        stream.forEach(System.out::println);

        try {
            Thread.sleep(5000);

            if (f.delete()) {
                System.out.println("File deleted: " + f.getAbsolutePath());
            } else {
                System.out.println("File failed to delete: " + f.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (dir.delete()) {
            System.out.println("Directory deleted");
        } else {
            System.out.println("Directory not deleted");
        }

    }
}
