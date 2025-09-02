package FileManipulations;

import java.io.File;

public class PrintDirectories {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a directory argument");
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File Path provided does not exist: " + file.getAbsolutePath());
        }

        printFiles(file, 0);

    }

    public static void printFiles(File file, int depth) {
        //Print indentation
        String indent = " ".repeat(depth);

        System.out.println(indent + file.getName() + (file.isDirectory() ? "/" : ""));

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printFiles(f, depth + 1);
                }
            }
        }
    }
}


