package com.company.lab5;

import java.util.ArrayList;

public class Lab5 {
    public static void main(String[] args) {

        StringBuilder text = new StringBuilder("My name is Vlad! What is your name?");

        ArrayList<Sentence> sentences = new ArrayList<>();
        ArrayList<Punctuation> punctuations = new ArrayList<>();
        ArrayList<Word> words = new ArrayList<>();
        ArrayList<Letter> letters = new ArrayList<>();
        String endOfSentencePunctuation = ".!?";

        char symbol;
        for (int i = 0; i < text.length(); i++) {
            symbol = text.charAt(i);

            if (Character.isLetter(symbol)) {
                letters.add(new Letter(symbol));
            } else if (symbol == ' ') {
                if (letters.size() > 0) {
                    words.add(new Word(letters.toArray(new Letter[0])));
                }
                letters.clear();
            } else if (endOfSentencePunctuation.indexOf(symbol) != -1) {
                punctuations.add(new Punctuation(symbol, words.size()));
                words.add(new Word(letters.toArray(new Letter[0])));
                letters.clear();
                sentences.add(new Sentence(words.toArray(new Word[0]), punctuations.toArray(new Punctuation[0])));
                words.clear();
                punctuations.clear();
            } else {
                punctuations.add(new Punctuation(symbol, words.size()));
            }
        }

        Text newText = new Text(sentences.toArray(new Sentence[0]));
        System.out.println(newText.toString());

        char startLetter = 'i';
        char endLetter = 's';

        for (Sentence sentence : newText.getSentences()) {
            Word[] wordsInSentence = sentence.getWords();
            for (int i = 0; i < wordsInSentence.length; i++) {
                String wordString = wordsInSentence[i].toString();
                int startIndex = wordString.indexOf(startLetter);
                int endIndex = wordString.lastIndexOf(endLetter);

                if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
                    String modifiedWord = wordString.substring(0, startIndex) + wordString.substring(endIndex + 1);
                    wordsInSentence[i] = new Word(lettersFromString(modifiedWord));
                }
            }
        }

        System.out.println(newText.toString());
    }

    private static Letter[] lettersFromString(String str) {
        char[] charArray = str.toCharArray();
        Letter[] letters = new Letter[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            letters[i] = new Letter(charArray[i]);
        }
        return letters;
    }
}