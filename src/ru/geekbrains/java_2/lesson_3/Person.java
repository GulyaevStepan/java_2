package ru.geekbrains.java_2.lesson_3;

import java.util.Objects;

public class Person extends Object{

    /*
    * В общем, всё странно.
    * Но если конкретно, мне не понятно, куда положить фамилии.
    * По условию задания в Персоне они быть не могут (2 поля:
    * телефон и мэйл). С мапой труднее. В ключе не может быть
    * строка, иначе у нас не будет однофамильцев. Туда следует
    * положить персону, она уникальна. Получается, что место для имени
    * осталость только в значении мапы. Но тогда странная получится книга:
    * в ней надо фамилии искать по телефону и мэйлу (персоне).
    * Кроме того у нас условие задания обязывает положить имя в ключ.
    * Думаю, можно было бы выкрутиться, если бы String не был бы final,
    * унаследовать, переопределить hashCode() и использовать, как замену
    * стандартному стрингу, но с уникальным хешом.
    * */
    String name;
    Integer phone;
    String mail;


    public Person (String name, int phone, String mail) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return (name + " " + phone + " " + mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, mail);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(phone, person.phone) &&
                Objects.equals(mail, person.mail);
    }
}
