package com.adaptive.sorting;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("db/amazon.csv"));
            String line;

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println(data[0] + " - " + data[1]);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
