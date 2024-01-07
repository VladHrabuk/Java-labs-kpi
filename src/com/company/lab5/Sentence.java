package com.company.lab5;

import java.util.Arrays;

public class Sentence {

    private Word[] words;
    private final Punctuation[] punctuations;

    public Sentence(Word[] words, Punctuation[] punctuations) {
        this.words = words;
        this.punctuations = punctuations;
    }

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    public Punctuation[] getPunctuations() {
        return punctuations;
    }


    @Override
    public String toString() {
        StringBuilder sentenceString = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sentenceString.append(words[i].toString());
            for (int j = 0; j < punctuations.length; j++) {
                if (i == punctuations[j].getAfterWhatWord()) {
                    sentenceString.append(punctuations[j].toChar());
                }
            }
            sentenceString.append(" ");
        }
        return sentenceString.toString();
    }
}