package ru.geekbrains.java_2.lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        String[] words = {
                "Ехал", "Грека", "Через", "Реку",
                "Видит", "Грека", "В", "Реке", "Рак",
                "Сунул", "Грека", "В", "Реку", "Руку",
                "Рак", "За", "Руку", "Греки", "Цап"
        };

        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < words.length; i++) {
            hashSet.add(words[i]);
        }
        System.out.println(hashSet);

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!hashMap.containsKey(words[i])) {
                hashMap.put(words[i], 1);
            } else {
                hashMap.put(words[i], (hashMap.get(words[i]) + 1));
            }
        }
        System.out.println(hashMap);

        PhoneBook book = new PhoneBook();
    }
}
