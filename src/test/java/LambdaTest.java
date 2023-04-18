import org.junit.Test;
import ru.omsu.*;

import static org.junit.Assert.*;
import static ru.omsu.LambdaDemo.*;
import static ru.omsu.LambdaRunner.*;

public class LambdaTest {
    private String str1 = "test";
    private String str2 = "1 23 456";
    private Human human1 = new Human("Evdokimov", "Alexandr", "Victorovich", 43, Human.Gender.male);
    private Human human2 = new Human("Hisamov", "Ruslan", "Rishatovich", 17, Human.Gender.male);
    private Human human3 = new Human("Miller", "Elena", "Alexandrovna", 26, Human.Gender.female);
    private Student student1 = new Student("Pervushina", "Alexandra", "Pavlovna", 19, Human.Gender.female,
            "TPU", "Natural resources", "Petroleum Engineering");
    private Student student2 = new Student("Pervushina", "Valeria", "Pavlovna", 24, Human.Gender.female,
            "TPU", "Natural resources", "Petroleum Engineering");

    @Test
    public void lengthTest0() {
        String str0 = "";
        assertEquals(0, (int) length.apply(str0));
        assertEquals(4, (int) length.apply(str1));
    }

    @Test
    public void firstSymbolTest() {
        assertEquals('t', (int) firstSymbol.apply(str1));
        assertEquals('1', (int) firstSymbol.apply(str2));
    }

    @Test
    public void containsSpaceTest() {
        assertTrue(containsSpace.apply(str1));
        assertFalse(containsSpace.apply(str2));
    }

    @Test
    public void getWordsCountTest() {
        String str = "test,ts,te,st";
        assertEquals(4, (int) getWordsCount.apply(str));
    }

    @Test
    public void getAgeTest() {
        assertEquals(43,(int) getAge.apply(human1));
        assertEquals(17,(int) getAge.apply(human2));
        assertEquals(19,(int) getAge.apply(student1));
        assertEquals(24,(int) getAge.apply(student2));
    }

    @Test
    public void sameSurnameTest0() {
        assertTrue(run(equalsSurname,student1,student2));
        assertFalse(run(equalsSurname,human1,human2));
    }

    @Test
    public void getFullNameTest0() {
        String expected1="Evdokimov Alexandr Victorovich";
        String expected2="Pervushina Alexandra Pavlovna";
        assertEquals(expected1,getFullName.apply(human1));
        assertEquals(expected2,getFullName.apply(student1));
    }

    @Test
    public void makeYearOlderTest() {
        Human expected = new Human("Evdokimov", "Alexandr", "Victorovich", 44, Human.Gender.male);
        assertEquals(expected,makeYearOlder.apply(human1));
    }

    @Test
    public void threePersonsYoungerMaxAgeTest() {
        assertTrue( threePersonsYoungerMaxAge.apply(human1,human2,human3,45));
        assertFalse(threePersonsYoungerMaxAge.apply(human1,human2,human3,10));
    }
}
