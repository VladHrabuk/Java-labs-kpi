package com.company.lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        /**
         * 1404 - номер залікової книжки
         * C13 = 10 => Визначити ієрархію квітів. Створити кілька об'єктів-квітів. Зібрати букет (використовуючи аксесуари)
         * з визначенням його вартості. Провести сортування квітів у букеті за рівнем свіжості. Знайти квітку в букеті, що
         * відповідає заданому діапазону довжин.
         * **/
        Flower daisy = new Daisy(4, 15, 30, 3);
        Flower peony = new Peony(5, 20, 25, 0);
        Flower rose = new Rose(3, 18, 35, 5);
        Flower tulip = new Tulip(2, 12, 20, 0);

        Accessory ribbon = new Accessory("ribbon", 5);
        Accessory wrapper = new Accessory("wrapper", 8);

        List<Flower> flowers = new ArrayList<>(List.of(daisy, peony, rose, tulip));

        Bouquet bouquet = new Bouquet(flowers, ribbon, wrapper);

        System.out.println("Total price of the bouquet: $" + bouquet.calculateTotalPrice());

        bouquet.sortByFreshness();
        System.out.println("Bouquet sorted by freshness:\n" + bouquet);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the minimum length of flower:");
        int minLength = scanner.nextInt();
        System.out.println("Enter the maximum length of flower:");
        int maxLength = scanner.nextInt();

        List<Flower> matchingFlowers = bouquet.findFlowersByLengthRange(minLength, maxLength);

        if (!matchingFlowers.isEmpty()) {
            System.out.println("Flowers found in the specified length range:");
            for (Flower matchingFlower : matchingFlowers) {
                System.out.println(matchingFlower);
            }
        }
    }
}
