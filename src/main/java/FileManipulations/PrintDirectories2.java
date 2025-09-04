package FileManipulations;

import java.io.File;

public class PrintDirectories2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a root directory");
        }

        File file = new File(args[0]);

        if(!file.exists()) {
            System.out.println("The path you provided does not exist");
        }

        printFiles(file, 0);
    }

    static void printFiles(File file, int depth) {
        String indent = " ".repeat(depth);

        System.out.println(indent + (file.isDirectory() ? "/" : "-") + file.getName());

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
