package com.adaptive.sorting;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> result = new ArrayList<>();
        result.add("Laptop - 45000");
        result.add("Phone - 12000");
        result.add("Tablet - 30000");

        // print to console
        for (String r : result) {
            System.out.println(r);
        }

        // write to file ✅
        OutputWriter.write(result);
    }
}
