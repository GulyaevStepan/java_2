package ru.geekbrains.java_2.lesson_1;

public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    void fly() {
        System.out.println(name + " flies");
    }
}
