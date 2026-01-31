package com.adaptive.sorting;

public class Product {

    String name;
    String category;
    int actualPrice;
    int discountPrice;
    double rating;

    public Product(String name, String category, int actualPrice, int discountPrice, double rating) {
        this.name = name;
        this.category = category;
        this.actualPrice = actualPrice;
        this.discountPrice = discountPrice;
        this.rating = rating;
    }
}
