package ru.geekbrains.java_two.lesson_3;

import java.util.ArrayList;
import java.util.HashMap;


public class Phonebook {
    private final HashMap<String, ArrayList<Person>> records = new HashMap<>();

    public void add(String name, String phone) {
        if (records.containsKey(name)) {
            ArrayList<Person> persons = records.get(name);
            persons.add(new Person(name, phone));
        } else {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(new Person(name, phone));
            records.put(name, persons);
        }
    }

    public ArrayList<String> getPhones(String name) {
        if (!records.containsKey(name)) return null;
        ArrayList<Person> persons = records.get(name);
        ArrayList<String> phonenumbers = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            phonenumbers.add(persons.get(i).phone);
        }
        return phonenumbers;
    }
}
