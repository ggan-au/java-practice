package HexEditor;

import java.io.IOException;
import java.nio.file.*;

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
                    writeAsString(content);
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
        StringBuilder output = new StringBuilder();
        output.append("Address  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f    Dump                               |")
                .append(System.lineSeparator());

        int[][] array = get2DimensionalArray(file);

        int legendCounter = 0;
        for (int i = 0; i < array.length; i++) {
            output.append(String.format("%08X", legendCounter));
            legendCounter += 16;
            for (int j = 0; j < array[i].length; j++) {
                output.append(" ").append(String.format("%02x",(int)array[i][j]));
            }

            output.append("   ");
            for (int j = 0; j < array[i].length; j++) {
                //If it is the last row and we only want to do it once before the first letter
                if (array.length-1 == i && j == 0) {
                    int requiredArrayLength = 16;
                    //Each array spot takes up 3 places
                    int lastRowSpacesToAdd = (requiredArrayLength - array[array.length-1].length) * 3;
                    output.append(" ".repeat(lastRowSpacesToAdd));
                }

                if (array[i][j] > 33 & array[i][j] < 126) {
                    output.append((char) array[i][j]);
                } else {
                    output.append(".");
                }
            }
            //If not the last row
            if (!(array.length-1 == i)) {
                output.append(System.lineSeparator());
            }
        }
        System.out.println(output.toString());
    }

    private static void writeAsHex(String file) {
        StringBuilder output = new StringBuilder();
        output.append("Address  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f")
                .append(System.lineSeparator());

        int[][] array = get2DimensionalArray(file);

        int legendCounter = 0;
        for (int i = 0; i < array.length; i++) {
            output.append(String.format("%08X", legendCounter));
            legendCounter += 16;
            for (int j = 0; j < array[i].length; j++) {
                output.append(" ").append(String.format("%02x",(int)array[i][j]));
            }
            output.append(System.lineSeparator());
        }
        System.out.println(output.toString());

    }

    private static void writeAsBinary(String file) {
        StringBuilder output = new StringBuilder();
        output.append("Address     0        1        2        3        4        5        6        7        8        9        a        b        c        d        e        f")
              .append(System.lineSeparator());

        int[][] array = get2DimensionalArray(file);

        //Print each CHAR in a binary representation - 16 per line - First element of each line should be part of the legend
        int legendCounter = 0;
        for (int i = 0; i < array.length; i++) {
            output.append(String.format("%08X", legendCounter));
            legendCounter += 16;
            for (int j = 0; j < array[i].length; j++) {
                output.append(" ").append(addZeroBinaryPrefix(Integer.toBinaryString(array[i][j])));
            }
            output.append(System.lineSeparator());
        }
        System.out.println(output.toString());
    }

    private static int[][] get2DimensionalArray(String file) {

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
            }
        }

        //Last Row
        array[rows] = new int[lastRow];
        for (int i = 0; i < lastRow; i++) {
            array[rows][i] = file.charAt(counter);
            counter++;
        }

        return array;
    }

    private static String addZeroBinaryPrefix(String binaryString) {
        int binaryLength = 8;
        if (binaryString.length() == binaryLength) {
            return binaryString;
        }

        int requiredZeros = binaryLength - binaryString.length();
        return  "0".repeat(requiredZeros).concat(binaryString);
    }
}
