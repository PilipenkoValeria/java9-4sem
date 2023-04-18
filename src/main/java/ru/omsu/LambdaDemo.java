package ru.omsu;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class LambdaDemo {

    //1)для строки символов получить ее длину
    public static final Function<String, Integer> length = String::length; //s -> s.length();

    //2)для строки символов получить ее первый символ
    public static final Function<String, Character> firstSymbol = string -> (string != null || string.length() == 0)
            ? string.charAt(0) : null;

    //3)для строки проверить, что она не содержит пробелов
    public static final Function<String, Boolean> containsSpace = string -> !string.contains(" ");
   // ObjectOperation<Boolean, String> containsSpace = s -> !s.contains(" ");

    //4)слова в строке разделены запятыми, по строке получить количество слов в ней
    public static final Function<String, Integer> getWordsCount = string -> (int) Arrays.stream(string.split(",")).count();

    //5)по человеку получить его возраст
    public static final  Function<? super Human, Integer> getAge = Human::getAge;

    //6)по двум людям проверить, что у них одинаковая фамилия
    public static final BiPredicate<? super Human, ? super Human> equalsSurname = (human0, human1) ->
            human0.getSurname().equals(human1.getSurname());

    //7)получить фамилию, имя и отчество человека в виде одной строки
    public static final Function<? super Human, String> getFullName = human -> human.getSurname() + " " +
            human.getName() + " " + human.getPatronymic();

    //8)сделать человека старше на один год
    public static final Function<Human, Human> makeYearOlder = human ->
            new Human(human.getSurname(), human.getName(), human.getPatronymic(), human.getAge() + 1, human.getGender());

    //9)по трем людям и заданному возрасту maxAge проверить, что все три человека моложе maxAge
    public static final HumansLambda <Human, Human, Human, Integer> threePersonsYoungerMaxAge = (human0, human1, human2, maxAge) ->
        human0.getAge() < maxAge && human1.getAge() < maxAge && human2.getAge() < maxAge;
}
