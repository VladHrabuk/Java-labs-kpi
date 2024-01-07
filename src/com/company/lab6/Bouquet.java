package com.company.lab6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Bouquet {
    private List<Flower> flowers;
    private Accessory ribbon;
    private Accessory wrapper;

    public Bouquet(List<Flower> flowers, Accessory ribbon, Accessory wrapper) {
        this.flowers = flowers;
        this.ribbon = ribbon;
        this.wrapper = wrapper;
    }

    public int calculateTotalPrice() {
        int totalPrice = ribbon.getPrice() + wrapper.getPrice();
        for (Flower flower : flowers) {
            if (flower.getCount() > 0) {
                totalPrice += flower.getPrice() * flower.getCount();
            }
        }
        return totalPrice;
    }

    public void sortByFreshness() {
        flowers.sort(Comparator.comparingInt(Flower::getFreshnessLevel));
    }

    public List<Flower> findFlowersByLengthRange(int minLength, int maxLength) {
        if (minLength > maxLength) {
            System.out.println("Min length should be less than or equal to max length.");
        }

        List<Flower> matchingFlowers = new ArrayList<>();

        for (Flower flower : flowers) {
            if (flower.getCount() > 0) {
                int flowerLength = flower.getLength();
                if (flowerLength >= minLength && flowerLength <= maxLength) {
                    matchingFlowers.add(flower);
                }
            }
        }

        if (matchingFlowers.isEmpty()) {
            System.out.println("No flowers found in the [" + minLength + ", " + maxLength + "] length range.");
        }

        return matchingFlowers;
    }

    @Override
    public String toString() {
        String result = "";
        for (Flower flower : flowers) {
            if (flower.getCount() > 0) {
                result += flower + "\n";
            }
        }
        result += ribbon + "\n";
        result += wrapper + "\n";
        return result;
    }
}