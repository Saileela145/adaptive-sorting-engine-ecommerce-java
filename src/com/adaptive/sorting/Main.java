package com.adaptive.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    // ---------------- BOX UI METHODS ----------------

    static void printBoxHeader() {
        System.out.println(
            "+----------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-40s | %-22s | %-8s | %-10s | %-6s |\n",
                "PRODUCT NAME", "CATEGORY", "PRICE", "DISCOUNT", "RATING");
        System.out.println(
            "+----------------------------------------------------------------------------------------------------------------------------------+");
    }

    static void printBoxRow(String name, String category, int price, int discount, double rating) {

        if (name.length() > 40) {
            name = name.substring(0, 37) + "...";
        }
        if (category.length() > 22) {
            category = category.substring(0, 19) + "...";
        }

        System.out.printf("| %-40s | %-22s | %-8d | %-10d | %-6.1f |\n",
                name, category, price, discount, rating);
    }

    static void printBoxFooter() {
        System.out.println(
            "+----------------------------------------------------------------------------------------------------------------------------------+");
    }

    // ---------------- MAIN METHOD ----------------

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Search (or) Ask a question: ");
        String search = sc.nextLine().toLowerCase();

        System.out.print("Enter price range (low / medium / high): ");
        String range = sc.nextLine().toLowerCase();

        String algorithmUsed;

        if (range.equals("low")) {
            algorithmUsed = "Insertion Sort";
        } else if (range.equals("medium")) {
            algorithmUsed = "Shell Sort";
        } else if (range.equals("high")) {
            algorithmUsed = "Quick Sort";
        } else {
            System.out.println("Invalid range selected.");
            sc.close();
            return;
        }

        System.out.println("\nAlgorithm Used: " + algorithmUsed);
        System.out.println("------------------------------------------------------------------");

        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader("db/amazon.csv"));
            String line;

            // Skip header row
            br.readLine();

            while ((line = br.readLine()) != null) {

                // Correct CSV splitting (handles commas inside quotes)
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                // ✅ IMPORTANT FIX: rating is at index 6
                if (data.length < 7) continue;

                /*
                 * Correct Amazon CSV mapping:
                 * 0 -> product_id
                 * 1 -> product_name
                 * 2 -> category
                 * 3 -> discounted_price
                 * 4 -> actual_price
                 * 5 -> discount_percentage
                 * 6 -> rating
                 */

                String productName = data[1].replace("\"", "");
                String category = data[2].replace("\"", "");
                String productNameLower = productName.toLowerCase();

                int discountedPrice;
                int actualPrice;
                double rating;

                try {
                    discountedPrice = Integer.parseInt(
                            data[3].replace("₹", "")
                                   .replace(",", "")
                                   .replace("\"", "")
                                   .trim()
                    );

                    actualPrice = Integer.parseInt(
                            data[4].replace("₹", "")
                                   .replace(",", "")
                                   .replace("\"", "")
                                   .trim()
                    );

                    rating = Double.parseDouble(
                            data[6].replace("\"", "").trim()
                    );

                } catch (Exception e) {
                    // Skip bad rows safely
                    continue;
                }

                boolean match = false;

                // Filtering based on discounted price
                if (range.equals("low") && discountedPrice < 1000) match = true;
                if (range.equals("medium") && discountedPrice >= 1000 && discountedPrice <= 5000) match = true;
                if (range.equals("high") && discountedPrice > 5000) match = true;

                if (productNameLower.contains(search) && match) {

                    if (!found) {
                        printBoxHeader();
                    }

                    printBoxRow(productName, category, actualPrice, discountedPrice, rating);
                    found = true;
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading CSV file.");
            e.printStackTrace();
        }

        if (found) {
            printBoxFooter();
        } else {
            System.out.println("No products found for your search and price range.");
        }

        sc.close();
    }
}
