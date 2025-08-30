package HexEditor;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    private static final int BYTES_PER_ROW = 16;
    private static final int BITS_PER_BYTE = 8;
    private static final int PRINTED_ARRAY_SPACING = 3;

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
        StringBuilder output = new StringBuilder("Address ");
        for (int i = 0; i < BYTES_PER_ROW; i++) {
            output.append(String.format("%2x ", i));
        }
        output.append("     Dump").append(System.lineSeparator());

        int[][] array = splitIntoRows(file);

        int address = 0;
        int counter = 0;

        for (int[] row : array) {
            output.append(String.format("%08X ", address));
            address += BYTES_PER_ROW;
            //Print row HEX values
            for (int value : row) {
                output.append(String.format("%02X ", value));
            }

            output.append("    ");

            int arrayLastRow = array.length - 1;
            boolean lastRowPrinted = false;
            //Print String Dump
            for (int value : row) {
                if (arrayLastRow == counter && !lastRowPrinted) {
                    lastRowPrinted = true;
                    int spacing = (BYTES_PER_ROW - array[arrayLastRow].length) * PRINTED_ARRAY_SPACING;
                    output.append(" ".repeat(spacing));
                }

                char temp = Character.isISOControl(value) ? '.' : (char) value;
                output.append(temp);
            }

            boolean isLastRow = array.length-1 == counter;
            if (!(isLastRow)) output.append(System.lineSeparator());
            counter++;
        }
        System.out.println(output);
    }

    private static void writeAsHex(String file) {
        StringBuilder output = new StringBuilder("Address  ");
        for (int i = 0; i < BYTES_PER_ROW; i++) {
            output.append(String.format("%x  ", i));
        }
        output.append((System.lineSeparator()));

        int[][] array = splitIntoRows(file);

        int address = 0;
        for (int[] row : array) {
            output.append(String.format("%08X ", address));
            address += BYTES_PER_ROW;

            for (int value : row) {
                output.append(String.format("%02X ", value));
            }
            output.append(System.lineSeparator());
        }
        System.out.println(output);

    }

    private static void writeAsBinary(String file) {
        StringBuilder output = new StringBuilder();
        output.append("Address     0        1        2        3        4        5        6        7        8        9        a        b        c        d        e        f")
              .append(System.lineSeparator());

        int[][] array = splitIntoRows(file);

        //Print each CHAR in a binary representation - 16 per line - First element of each line should be part of the legend
        int legendCounter = 0;
        for (int i = 0; i < array.length; i++) {
            output.append(String.format("%08X", legendCounter));
            legendCounter += BYTES_PER_ROW;
            for (int j = 0; j < array[i].length; j++) {
                output.append(" ").append(formatBinaryByte(Integer.toBinaryString(array[i][j])));
            }
            output.append(System.lineSeparator());
        }
        System.out.println(output.toString());
    }

    private static int[][] splitIntoRows(String file) {

        int rows = file.length() / BYTES_PER_ROW;
        int lastRow = file.length() % BYTES_PER_ROW;
        //Added one for the last row
        int[][] array = new int[rows+1][];

        //fill everything except for lastRow
        int counter = 0;
        for (int i = 0; i < rows; i++) {
            array[i] = new int[BYTES_PER_ROW];
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

    private static String formatBinaryByte(String binaryString) {
        if (binaryString.length() == BITS_PER_BYTE) {
            return binaryString;
        }

        int requiredZeros = BITS_PER_BYTE - binaryString.length();
        return  "0".repeat(requiredZeros).concat(binaryString);
    }
}
