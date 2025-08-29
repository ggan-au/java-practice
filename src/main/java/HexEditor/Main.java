package HexEditor;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        String filename = args[args.length - 1];
        Path filePath = Paths.get(filename);
        String content = Files.readString(filePath);

        for (int i = 0; i < args.length-1; i++) {
            switch(args[i]) {
                case "-a":
                    writeAsBinary(content);
                    writeAsHex(content);
                    writeAsHex(content);
                    break;
                case "-s":
                    writeAsString(content);
                    break;
                case "-h":
                    writeAsHex(content);
                    break;
                case "-b":
                    writeAsBinary(content);
                    break;
                default:
                    writeUsage();
            }
        }
    }

    private static void writeUsage() {
        System.out.println("Usage:\njava HexViewer.java -s -b -h -a <file>");
    }

    private static void writeAsString(String file) {
        System.out.println(file);
    }

    private static void writeAsHex(String file) {
        System.out.println("Printing Hex");
    }

    private static void writeAsBinary(String file) {
        String temp = "Address     0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f\n";
        //How many lines of 16 - outer array
        int rows = file.length() / 16;
        int lastRow = rows % 16;
        //Added one for the last row
        int[][] array = new int[rows+1][];

        //fill everything except for lastRow
        int counter = 0;
        for (int i = 0; i < rows; i++) {
            array[i] = new int[16];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = file.charAt(counter);
                counter++;
                System.out.println((char)array[i][j]);
            }
        }

        //Last Row
        array[rows] = new int[lastRow];
        for (int i = 0; i < lastRow; i++) {
            array[rows][i] = file.charAt(counter);
            counter++;
            System.out.println((char)array[rows][i]);
        }

        System.out.println(Arrays.deepToString(array));
        //Print binary hex address on left hand side
        //00000000
        //00000010
        //00000020
//        int num1 = 16;
//        int num2 = 32;
//        String hex1 = String.format("%08X\n", num1);
//        String char1 = Integer.toBinaryString(89);
//
//        String hex2 = String.format("%08X\n", num2);
//        temp += hex1;
//        temp += hex2;
//        System.out.println(temp);


    }
}
