package com.adaptive.sorting;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputWriter {

    public static void write(List<String> data) {
        try {
            FileWriter writer = new FileWriter("output/sample-output.txt");

            writer.write("Adaptive Sorting Engine Output\n");
            writer.write("--------------------------------\n");

            for (String line : data) {
                writer.write(line + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
