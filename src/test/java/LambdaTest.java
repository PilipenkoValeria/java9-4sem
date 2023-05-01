import org.junit.Test;
import ru.omsu.*;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void lengthTest() {
        assertEquals(0, (int) length.apply(""));
        assertEquals(4, (int) length.apply("test"));
    }

    @Test
    public void firstSymbolTest() {

        assertEquals('t', (int) firstSymbol.apply("test"));
        assertEquals('A', (int) firstSymbol.apply("Abc"));
    }

    @Test
    public void containsSpaceTest() {
        assertTrue(containsSpace.apply(""));
        assertFalse(containsSpace.apply("A bc"));
    }

    @Test
    public void getWordsCountTest() {
        assertEquals(3, (int) getWordsCount.apply("a,b,c"));
    }

    @Test
    public void getAgeTest() {
        assertEquals(43, (int) getAge.apply(human1));
        assertEquals(17, (int) getAge.apply(human2));
        assertEquals(26, (int) getAge.apply(human3));
        assertEquals(19, (int) getAge.apply(student1));
        assertEquals(24, (int) getAge.apply(student2));
    }

    @Test
    public void sameSurnameTest0() {
        assertTrue(run(equalsSurname, student1, student2));
        assertFalse(run(equalsSurname, human1, human2));
    }

    @Test
    public void getFullNameTest0() {
        String expected1 = "Evdokimov Alexandr Victorovich";
        String expected2 = "Pervushina Alexandra Pavlovna";
        assertEquals(expected1, getFullName.apply(human1));
        assertEquals(expected2, getFullName.apply(student1));
    }

    @Test
    public void makeYearOlderTest() {
        Human expected = new Human("Evdokimov", "Alexandr", "Victorovich", 44, Human.Gender.male);
        assertEquals(expected, makeYearOlder.apply(human1));
    }

    @Test
    public void threePersonsYoungerMaxAgeTest() {
        List<Human> Human = new ArrayList<Human>();
        Human.add(human1);
        Human.add(human2);
        Human.add(human3);
        assertTrue(run(threePersonsYoungerMaxAge, Human, 45));
        assertFalse(run(threePersonsYoungerMaxAge, Human, 10));
    }
}
