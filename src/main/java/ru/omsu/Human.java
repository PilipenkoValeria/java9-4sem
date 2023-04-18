package ru.omsu;

import java.util.Objects;

public class Human {
    private String surname;
    private String name;
    private String patronymic;
    private int age;
    private Gender gender;

    public enum Gender{male,female}

    public Human(String surname, String name, String patronymic, int age, Gender gender) {
        if(surname == null || surname.length() < 1 || name == null || name.length() < 1 ||
                patronymic == null || patronymic.length() == 0 || age < 0){
            throw new IllegalArgumentException("Ошибка! Получены некорректные данные.");
        }
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.gender = gender;
    }
    public Human(Human human){
        surname = human.getSurname();
        name = human.getName();
        patronymic = human.getPatronymic();
        age = human.getAge();
        gender = human.getGender();
    }

    @Override
    public String toString() {
        return "Human{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                surname.equals(human.surname) &&
                name.equals(human.name) &&
                patronymic.equals(human.patronymic) &&
                gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, age, gender);
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
