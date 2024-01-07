package com.company.lab5;

public class Word {

    private final Letter[] letters;

    public Word(Letter[] letters) {
        this.letters = letters;
    }


    @Override
    public String toString() {
        StringBuilder wordStringBuilder = new StringBuilder();
        for (Letter letter : letters) {
            wordStringBuilder.append(letter);
        }
        return wordStringBuilder.toString();
    }
}