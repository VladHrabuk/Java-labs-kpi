package com.company.lab5;

public class Text {
    private final Sentence[] sentences;

    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        StringBuilder textStringBuilder = new StringBuilder();
        for (Sentence sentence : sentences) {
            textStringBuilder.append(sentence).append(" ");
        }
        return textStringBuilder.toString().trim();
    }

    public Sentence[] getSentences() {
        return sentences;
    }
}