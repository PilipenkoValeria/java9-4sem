import org.junit.Test;
import ru.omsu.*;

import static org.junit.Assert.*;
import static ru.omsu.LambdaDemo.*;
import static ru.omsu.LambdaRunner.*;

public class LambdaTest {
    private Human human1 = new Human("Evdokimov", "Alexandr", "Victorovich", 43, Human.Gender.male);
    private Human human2 = new Human("Hisamov", "Ruslan", "Rishatovich", 17, Human.Gender.male);
    private Human human3 = new Human("Miller", "Elena", "Alexandrovna", 26, Human.Gender.female);
    private Student student1 = new Student("Pervushina", "Alexandra", "Pavlovna", 19, Human.Gender.female,
            "TPU", "Natural resources", "Petroleum Engineering");
    private Student student2 = new Student("Pervushina", "Valeria", "Pavlovna", 24, Human.Gender.female,
            "TPU", "Natural resources", "Petroleum Engineering");

    //1)для строки символов получить ее длину
    @Test
    public void lengthTest() {
        assertEquals(0, (int) length.apply(""));
        assertEquals(4, (int) length.apply("test"));
    }
    //2)для строки символов получить ее первый символ
    @Test
    public void firstSymbolTest() {
        assertNull(firstSymbol.apply(""));
        assertNull(firstSymbol.apply(null));

        assertEquals('t', (int) firstSymbol.apply("test"));
        assertEquals('A', (int) firstSymbol.apply("Abc"));
    }
    //3)для строки проверить, что она не содержит пробелов
    @Test
    public void containsSpaceTest() {
        assertTrue(containsSpace.apply(""));
        assertFalse(containsSpace.apply("A bc"));
    }

    //4)слова в строке разделены запятыми, по строке получить количество слов в ней
    @Test
    public void getWordsCountTest() {
        assertEquals(3, (int) getWordsCount.apply("a,b,c"));
        assertEquals(3, (int) getWordsCount.apply("a,,,b,c"));
    }

    //5)по человеку получить его возраст
    @Test
    public void getAgeTest() {
        assertEquals(43, (int) getAge.apply(human1));
        assertEquals(17, (int) getAge.apply(human2));
        assertEquals(26, (int) getAge.apply(human3));
        assertEquals(19, (int) getAge.apply(student1));
        assertEquals(24, (int) getAge.apply(student2));
    }

    //6)по двум людям проверить, что у них одинаковая фамилия
    @Test
    public void sameSurnameTest0() {
        assertTrue(run(equalsSurname, student1, student2));
        assertFalse(run(equalsSurname, human1, human2));
    }

    //7)получить фамилию, имя и отчество человека в виде одной строки
    @Test
    public void getFullNameTest0() {
        String expected1 = "Evdokimov Alexandr Victorovich";
        String expected2 = "Pervushina Alexandra Pavlovna";
        assertEquals(expected1, getFullName.apply(human1));
        assertEquals(expected2, getFullName.apply(student1));
    }

    //8)сделать человека старше на один год
    @Test
    public void makeYearOlderTest() {
        Human expected = new Human("Evdokimov", "Alexandr", "Victorovich", 44, Human.Gender.male);
        assertEquals(expected, makeYearOlder.apply(human1));
    }

    //9)по трем людям и заданному возрасту maxAge проверить, что все три человека моложе maxAge
    @Test
    public void threePersonsYoungerMaxAgeTest() {
        assertTrue(threePersonsYoungerMaxAge(threePersonsYoungerMaxAge, human1, human2, human3, 45));
        assertFalse(threePersonsYoungerMaxAge(threePersonsYoungerMaxAge, human1, human2, human3, 10));
    }
}
