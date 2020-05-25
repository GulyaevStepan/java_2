package ru.geekbrains.java_2.lesson_3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<Person, Integer> book = new HashMap<>();

    public void addPerson (String name, int phone, String mail) {
        book.put(new Person(name, phone, mail), phone);
    }

    public ArrayList<Integer> getPhone (String name) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Person key : book.keySet()) {
            if (key.name.equals(name)) {
                result.add(key.phone);
            }
        }
        return result;
    }

    public ArrayList<String> getMail (String name) {
        ArrayList<String> result = new ArrayList<>();
        for (Person key : book.keySet()) {
            if (key.name.equals(name)) {
                result.add(key.mail);
            }
        }
        return result;
    }
}
