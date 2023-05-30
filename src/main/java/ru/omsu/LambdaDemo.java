package ru.omsu;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Stream;

public class LambdaDemo {

    //1)для строки символов получить ее длину
    public static final Function<String, Integer> length = String::length;

    //2)для строки символов получить ее первый символ
    public static final Function<String, Character> firstSymbol = n -> { if (n != null && !n.isEmpty()) {
            return n.charAt(0);} return null; };

    //3)для строки проверить, что она не содержит пробелов
    public static final Function<String, Boolean> containsSpace = n -> (n.split(" ").length <= 1);

    //4)слова в строке разделены запятыми, по строке получить количество слов в ней
    public static final Function<String, Integer> getWordsCount = n ->
            Stream.of(n.split(",")).filter(s -> !s.equals("")).toList().size();

    //5)по человеку получить его возраст
    public static final  Function<? super Human, Integer> getAge = Human::getAge;

    //6)по двум людям проверить, что у них одинаковая фамилия
    public static final BiPredicate<? super Human, ? super Human> equalsSurname = (n, m) -> n.getSurname().equals(m.getSurname());

    //7)получить фамилию, имя и отчество человека в виде одной строки
    public static final Function<? super Human, String> getFullName = n -> n.getSurname() + " " +
            n.getName() + " " + n.getPatronymic();

    //8)сделать человека старше на один год
    public static final Function<Human, Human> makeYearOlder = n ->
            new Human(n.getSurname(), n.getName(), n.getPatronymic(), n.getAge() + 1, n.getGender());

    //9)по трем людям и заданному возрасту maxAge проверить, что все три человека моложе maxAge
    interface IthreePersonsYoungerMaxAge{
        boolean task9(Human human1, Human human2, Human human3, int maxAge);
    }
    public static final IthreePersonsYoungerMaxAge threePersonsYoungerMaxAge =
            ((human1, human2, human3, maxAge) -> human1.getAge()<maxAge && human2.getAge()<maxAge && human3.getAge()<maxAge);

}

