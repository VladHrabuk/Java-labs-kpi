package com.company.lab6;

public class Accessory {
    private final int price;
    private final String name;

    public Accessory(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + "(Price: $" + price + ")";
    }
}

