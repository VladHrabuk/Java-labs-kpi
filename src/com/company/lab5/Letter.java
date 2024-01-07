package com.company.lab5;

public class Letter {
    private final char letterChar;

    public Letter(char letterChar) {
        this.letterChar = letterChar;
    }

    @Override
    public String toString() {
        return String.valueOf(letterChar);
    }
}