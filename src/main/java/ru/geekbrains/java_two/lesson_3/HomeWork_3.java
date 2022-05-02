package ru.geekbrains.java_two.lesson_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class HomeWork_3 {
    private static final String[] arr = {"в", "качество", "тип", "ключ", "и", "тип", "значение", "может",
            "выступать", "практически", "есть", "небольшой", "дополнительный", "требование", "к", "тип",
            "ключ", "дополнительный", "и", "коллекция", "java", "требование", "java", "коллекция", "java"};



    private static TreeSet<String> getSetFromArr(String[] arr) {
        return new TreeSet<>(Arrays.asList(arr));
    }

    private static HashMap<String, Integer> getWordsCount(String[] arr) {
        HashMap<String, Integer> countOfWord = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            countOfWord.put(word, countOfWord.getOrDefault(word, 0) + 1);
        }
        return countOfWord;
    }

    public static void main(String[] args) {
        System.out.println(getSetFromArr(arr));
        System.out.println(getWordsCount(arr));

        Phonebook phonebook = new Phonebook();
        phonebook.add("Krasin", "+7(701)228-33-91");
        phonebook.add("Musin", "+7(702)555-55-55");
        phonebook.add("Krasin", "+7(777)428-28-28");


        System.out.println("phone Krasin: " + phonebook.getPhones("Krasin"));
        System.out.println("phone Musin: " + phonebook.getPhones("Musin"));
    }

}