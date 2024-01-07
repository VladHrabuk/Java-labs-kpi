package com.company.lab6;

public class Flower {
    private final String name;
    private final int freshnessLevel;
    private final int price;
    private final int length;
    private final int count;

    public Flower(String name, int freshnessLevel, int price, int length, int count) {
        this.name = name;
        this.freshnessLevel = freshnessLevel;
        this.price = price;
        this.length = length;
        this.count = count;
    }

    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    public int getPrice() {
        return price;
    }

    public int getLength() {
        return length;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return name + " (Freshness Level (from 1 to 5): " + freshnessLevel + ", Price: $" + price + ", Length: " +
                length + " cm, Count: " + count + ")";
    }
}