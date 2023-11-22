package com.company.lab4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Lab4 {
    public static void main(String[] args) {
        // 1404 - номер залікової книжки
        // C11 = 7 => Визначити клас спортивний інвентар, який складається як мінімум з 5-ти полів.

        Scanner sc = new Scanner(System.in);

        int size_of_list;
        String name_of_balls, name_of_dumbbells, name_of_institution, parameter1;
        int quantity_of_balls, quantity_of_dumbbells;
        int size_of_name_of_institution = 4, size_of_name_of_balls = 13, size_of_name_of_dumbbells = 16, temp = 1;

        while (true) {
            try {
                System.out.print("Enter the quantity of institutions, where you want to deliver inventory: ");
                size_of_list = sc.nextInt();
                if (size_of_list <= 0) {
                    System.out.println("The quantity of institutions can't be less than 1!");
                    continue;
                }
                break;
            } catch (InputMismatchException exc) {
                System.out.println("Enter integer number!");
                sc.next();
            }
        }

        Sport_Inventory[] list_of_institutions = new Sport_Inventory[size_of_list];

        for (int i = 0; i < size_of_list; i++) {
            try {
                System.out.printf("Enter data about %d institution:\n", i + 1);
                System.out.print("Enter name of institution: ");
                name_of_institution = sc.nextLine();
                name_of_institution = sc.nextLine();
                if (name_of_institution.length() > size_of_name_of_institution) {
                    size_of_name_of_institution = name_of_institution.length();
                }
                System.out.print("Enter name of company that produces balls: ");
                name_of_balls = sc.nextLine();
                if (name_of_balls.length() > size_of_name_of_balls) {
                    size_of_name_of_balls = name_of_balls.length();
                }
                System.out.print("Enter quantity of balls you need: ");
                quantity_of_balls = sc.nextInt();
                if (quantity_of_balls < 0) {
                    System.out.println("Quantity of balls can't be less than 0!");
                    i--;
                    continue;
                }
                System.out.print("Enter name of company that produces dumbbells: ");
                name_of_dumbbells = sc.nextLine();
                name_of_dumbbells = sc.nextLine();
                if (name_of_dumbbells.length() > size_of_name_of_dumbbells) {
                    size_of_name_of_dumbbells = name_of_dumbbells.length();
                }
                System.out.print("Enter quantity of dumbbells: ");
                quantity_of_dumbbells = sc.nextInt();
                if (quantity_of_dumbbells < 0) {
                    System.out.println("Quantity of barbells can't be less than 0!");
                    i--;
                    continue;
                }
                list_of_institutions[i] = new Sport_Inventory(name_of_balls, quantity_of_balls, name_of_dumbbells,
                        quantity_of_dumbbells, name_of_institution);
            } catch (InputMismatchException exc) {
                System.out.println("Invalid entered data!");
                i--;
                sc.next();
            }
        }
        Printing_List(list_of_institutions, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
        System.out.println("\nList of parameters: enterprise, company:balls, balls, company:dumbbells, dumbbells");
        parameter1 = sc.nextLine();
        while (true) {
            System.out.println("Enter parameter to sort objects:");
            parameter1 = sc.nextLine();
            if (parameter1.equals("enterprise") || parameter1.equals("company:balls") || parameter1.equals("balls") ||
            parameter1.equals("company:dumbbells") || parameter1.equals("dumbbells")) {
                Sort(list_of_institutions, parameter1, temp, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
                break;
            } else {
                System.out.println("Entered invalid parameter!");
            }
        }
        temp = 2;
        while (true) {
            System.out.println("Enter parameter to sort objects in reverse order:");
            parameter1 = sc.nextLine();
            if (parameter1.equals("enterprise") || parameter1.equals("company:balls") || parameter1.equals("balls") ||
            parameter1.equals("company:dumbbells") || parameter1.equals("dumbbells")) {
                Sort(list_of_institutions, parameter1, temp, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
                break;
            } else {
                System.out.println("Entered invalid parameter!");
            }
        }
    }

    public static void Printing_List(Sport_Inventory[] institution, int size_of_name_of_institution,
                                     int size_of_name_of_balls, int size_of_name_of_dumbbells) {
        System.out.printf("%" + size_of_name_of_institution + "s | %" + size_of_name_of_balls + "s | Balls | %" +
                size_of_name_of_dumbbells + "s | Dumbbells\n" + "*".repeat(size_of_name_of_balls +
                size_of_name_of_dumbbells + size_of_name_of_institution + 28) + "\n", "Name", "Company:balls", "Company:dumbbells");
        for (Sport_Inventory enterprise : institution) {
            System.out.printf("%" + size_of_name_of_institution + "s | %" + size_of_name_of_balls + "s | %5d | %" +
                            size_of_name_of_dumbbells + "s | %10d\n" + "*".repeat(size_of_name_of_balls +
                            size_of_name_of_dumbbells + size_of_name_of_institution + 28) +
                            "\n", enterprise.getName_of_institution(), enterprise.getName_of_balls(),
                    enterprise.getQuantity_of_balls(), enterprise.getName_of_dumbbells(), enterprise.getQuantity_of_dumbbells());
        }
    }

    public static void Sort(Sport_Inventory[] institutions, String parameter, int start, int size_of_name_of_institution,
                            int size_of_name_of_balls, int size_of_name_of_dumbbells) {
        if (start == 1) {
            if (parameter.equals("institution")) {
                Arrays.sort(institutions, Comparator.comparing(Sport_Inventory::getName_of_institution));
                Printing_List(institutions, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
            }
            if (parameter.equals("company:balls")) {
                Arrays.sort(institutions, Comparator.comparing(Sport_Inventory::getName_of_balls));
                Printing_List(institutions, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
            }
            if (parameter.equals("balls")) {
                Arrays.sort(institutions, Comparator.comparing(Sport_Inventory::getQuantity_of_balls));
                Printing_List(institutions, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
            }
            if (parameter.equals("company:dumbbells")) {
                Arrays.sort(institutions, Comparator.comparing(Sport_Inventory::getName_of_dumbbells));
                Printing_List(institutions, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
            }
            if (parameter.equals("dumbbells")) {Arrays.sort(institutions, Comparator.comparing(Sport_Inventory::getQuantity_of_dumbbells));
                Printing_List(institutions, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
            }
        } else if (start == 2) {
            if (parameter.equals("institution")) {
                Arrays.sort(institutions, Comparator.comparing(Sport_Inventory::getName_of_institution).reversed());
                Printing_List(institutions, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
            }
            if (parameter.equals("company:balls")) {
                Arrays.sort(institutions, Comparator.comparing(Sport_Inventory::getName_of_balls).reversed());
                Printing_List(institutions, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
            }
            if (parameter.equals("balls")) {
                Arrays.sort(institutions, Comparator.comparing(Sport_Inventory::getQuantity_of_balls).reversed());
                Printing_List(institutions, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
            }
            if (parameter.equals("company:dumbbells")) {
                Arrays.sort(institutions, Comparator.comparing(Sport_Inventory::getName_of_dumbbells).reversed());
                Printing_List(institutions, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
            }
            if (parameter.equals("dumbbells")) {
                Arrays.sort(institutions, Comparator.comparing(Sport_Inventory::getQuantity_of_dumbbells).reversed());
                Printing_List(institutions, size_of_name_of_institution, size_of_name_of_balls, size_of_name_of_dumbbells);
            }
        }
    }
}
