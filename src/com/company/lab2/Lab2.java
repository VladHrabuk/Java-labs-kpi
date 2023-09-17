package com.company.lab2;

import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {

//C5 = 4 - C = A * B
// C7 = 4 - тип long
/* C11 = 7 - Обчислити суму найб. ел. в стовпцях матриці з непарними номерами та
та найм. ел. в стовпцях матриці з парними номерами */
        Scanner scan = new Scanner(System.in);

        //Ввід матриці А та B
        int rowA, columnA, rowB, columnB;
        while (true) {
            System.out.print("Визначте матрицю А\nВведіть кількість рядків: ");
            try {
                rowA = Integer.parseInt(scan.next());
                System.out.print("Введіть кількість стовпців: ");
                columnA = Integer.parseInt(scan.next());
                System.out.print("Визначте матрицю B\nВведіть кількість рядків: ");
                rowB = Integer.parseInt(scan.next());
                System.out.print("Введіть кількість стовпців: ");
                columnB = Integer.parseInt(scan.next());
                if (columnA != rowB) {
                    System.out.println("Кількість стовпців матриці А повинна дорівнювати кількості рядків матриці В!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введіть цілочисельне значення!");
                continue;
            }
            break;
        }

        long[][] matrix_A = new long[rowA][columnA];
        long[][] matrix_B = new long[rowB][columnB];

        //Заповнення матриці А
        while (true) {
            System.out.println("Введіть числа матриці А ");
            try {
                for (int i = 0; i < matrix_A.length; i++) {
                    for (int j = 0; j < matrix_A[i].length; j++) {
                        System.out.format("Елемент з індексом " + i + j + ": ");
                        matrix_A[i][j] = Long.parseLong(scan.next());
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Потрібно значення типу long! ");
                continue;
            }
            break;
        }

        //Заповнення матриці В
        while (true) {
            System.out.println("Введіть числа матриці B ");
            try {
                for (int i = 0; i < matrix_B.length; i++) {
                    for (int j = 0; j < matrix_B[i].length; j++) {
                        System.out.format("Елемент з індексом " + i + j + ": ");
                        matrix_B[i][j] = Long.parseLong(scan.next());
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Потрібно значення типу long! ");
                continue;
            }
            break;
        }

        //Вивід матриці А
        System.out.println("Матриця А: ");
        for (int i = 0; i < matrix_A.length; i++) {
            for (int j = 0; j < matrix_A[i].length; j++) {
                System.out.print(matrix_A[i][j] + "  ");
            }
            System.out.println();
        }

        //Вивід матриці B
        System.out.println("Матриця B: ");
        for (int i = 0; i < matrix_B.length; i++) {
            for (int j = 0; j < matrix_B[i].length; j++) {
                System.out.print(matrix_B[i][j] + "  ");
            }
            System.out.println();
        }

        //Множення матриць С = А * В
        long[][] matrix_C = new long[rowA][columnB];
        for (int i = 0; i < matrix_A.length; i++) {
            for (int j = 0; j < matrix_B[i].length; j++) {
                for (int l = 0; l < matrix_B.length; l++) {
                    matrix_C[i][j] += matrix_A[i][l] * matrix_B[l][j];
                }
            }
        }

        //Вивід матриці С = А * В
        System.out.println("Матриця С = А * В ");
        for (int i = 0; i < matrix_C.length; i++) {
            for (int j = 0; j < matrix_C[i].length; j++) {
                System.out.print(matrix_C[i][j] + "  ");
            }
            System.out.println();
        }

        //Дії з результуючою матрицею С
        long sum_max = 0, max_column;
        for (int j = 0; j < matrix_C.length; j += 2) {
            max_column = matrix_C[0][j];
            for (int i = 1; i < matrix_C.length; i++) {
                if (matrix_C[i][j] > max_column) {
                    max_column = matrix_C[i][j];
                }
            }
            sum_max += max_column;
        }
        System.out.printf("Сума найбільших елементів в стовпцях матриці з непарними номерами: %d", sum_max);
        if (columnB > 1) {
            long sum_min = 0, min_column;
            for (int j = 1; j < matrix_C.length; j += 2) {
                min_column = matrix_C[0][j];
                for (int i = 1; i < matrix_C.length; i++) {
                    if (matrix_C[i][j] < min_column) {
                        min_column = matrix_C[i][j];
                    }
                }
                sum_min += min_column;
            }
            System.out.printf("\nСума найменших елементів в стовпцях матриці з парними номерами: %d", sum_min);
        } else {
            System.out.println("\nПарних стовпців не має! Сума найменших елементів в стовпцях матриці з " +
                    "парними номерами: 0");
        }
    }
}
