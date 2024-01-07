package com.company.lab6;

public class Wrapper {
    private int price;

    public Wrapper(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Wrapper (Price: $" + price + ")";
    }
}
