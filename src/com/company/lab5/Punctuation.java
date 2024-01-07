package com.company.lab5;

public class Punctuation {
    private final char punctuationChar;
    private final int afterWhatWord;

    public Punctuation(char punctuationChar, int afterWhatWord) {
        this.punctuationChar = punctuationChar;
        this.afterWhatWord = afterWhatWord;
    }

    public int getAfterWhatWord() {
        return afterWhatWord;
    }

    public char toChar() {
        return punctuationChar;
    }
}