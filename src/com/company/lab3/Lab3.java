package com.company.lab3;

import java.util.Arrays;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        // 1404 - номер залікової книжки
        // C3 = 0 => тип StringBuilder
        /* C13 = 10 => З кожного речення заданого тексту видалити підрядок найбільшої
        довжини, що починається та закінчується заданими літерами.*/

        Scanner scan = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        System.out.println("Enter text for further interaction!");
        String ScanText = scan.nextLine();
        if (ScanText.isEmpty()) {
            System.out.println("Need to enter text!");
        } else {
            System.out.print("Enter fist letter of sub-string: ");
            String initialLetter = scan.nextLine();
            System.out.print("Enter last letter of substring: ");
            String finalLetter = scan.nextLine();
            String[] sentences = ScanText.split("(?<=[.?!]{1,3})");
            System.out.println(Arrays.toString(sentences));
            for (String sentence : sentences) {
                int start = sentence.indexOf(initialLetter);
                int end = sentence.lastIndexOf(finalLetter);
                if (start <= end) {
                    sentence = sentence.replace(sentence.substring(start, end + 1), " ");
                }
                text.append(sentence);
            }
        }
        System.out.println(text);
    }
}
