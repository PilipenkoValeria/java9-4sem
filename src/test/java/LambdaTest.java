import org.junit.Test;
import ru.omsu.*;
import java.util.Optional;

import static org.junit.Assert.*;
import static ru.omsu.LambdaDemo.*;
import static ru.omsu.LambdaRunner.*;

public class LambdaTest {
    @Test
    public void lengthTest(){
        assertEquals(Optional.of(4), Optional.of(run(length, "test")));
    }

    @Test
    public void firstSymbolTest(){
        assertEquals(Optional.of('t'), Optional.of(run(firstSymbol, "test")));
    }

    @Test
    public void containsSpaceTest0(){
        assertEquals(Optional.of(true), Optional.of(run(containsSpace, "test")));
    }

    @Test
    public void containsSpaceTest1() {
        assertEquals(Optional.of(false), Optional.of(run(containsSpace, "te st")));
    }

    @Test
    public void getWordsCountTest(){
        assertEquals(Optional.of(4), Optional.of(run(getWordsCount, "test,te,st,ts")));
    }

    @Test
    public void ageTest0(){
        assertEquals(Optional.of(43), Optional.of(run(getAge, new Human("Evdokimov", "Alexandr",
                "Victorovich", 43, Human.Gender.male))));
    }

    @Test
    public void ageTest1(){
        assertEquals(Optional.of(20), Optional.of(run(getAge, new Student("Pervushina", "Alexandra",
                "Pavlovna", 20, Human.Gender.female, "a","b", "c"))));
    }

    @Test
    public void sameSurnameTest0(){
        assertTrue(run(equalsSurname, new Human("Miller", "Victor", "Vladimirovich", 42, Human.Gender.male),
                new Human("Miller", "Elena", "Victorovna", 38, Human.Gender.female)));
    }

    @Test
    public void sameSurnameTest1(){
        assertTrue(run(equalsSurname, new Student("Pervushina", "Alexandra",
                        "Pavlovna", 20, Human.Gender.female, "a","b", "c"),
                new Student("Pervushina", "Valeria", "Pavlovna", 24, Human.Gender.female,
                        "a", "b", "c")));
    }

    @Test
    public void getFullNameTest0(){
        assertEquals("Evdokimov Alexandr Victorovich", run(getFullName, new Human("Evdokimov", "Alexandr",
                "Victorovich", 43, Human.Gender.male)));
    }

    @Test
    public void getFullNameTest1(){
        assertEquals("Pervushina Alexandra Pavlovna", run(getFullName, new Student("Pervushina", "Alexandra",
                "Pavlovna", 20, Human.Gender.female, "a","b", "c")));
    }

    @Test
    public void makeYearOlderTest(){
        assertEquals(new Human("Evdokimov", "Alexandr",  "Victorovich", 44, Human.Gender.male),
                run(makeYearOlder, new Human("Evdokimov", "Alexandr",  "Victorovich", 43, Human.Gender.male)));
    }

    @Test
    public void threePersonsYoungerMaxAgeTest0(){
        Human human0 = new Human("Evdokimov", "Alexandr", "Victorovich", 43, Human.Gender.male);
        Human human1 = new Human("Hisamov", "Ruslan", "Rishatovich", 17, Human.Gender.male);
        Human human2 = new Human("Miller", "Elena", "Alexandrovna", 15, Human.Gender.female);
        assertTrue(run(threePersonsYoungerMaxAge, human0, human1, human2, 45));
    }

    @Test
    public void threePersonsYoungerMaxAgeTest1() {
        Human human0 = new Human("Evdokimov", "Alexandr", "Victorovich", 43, Human.Gender.male);
        Human human1 = new Human("Hisamov", "Ruslan", "Rishatovich", 17, Human.Gender.male);
        Human human2 = new Human("Miller", "Elena", "Alexandrovna", 15, Human.Gender.female);
        assertFalse(run(threePersonsYoungerMaxAge, human0, human1, human2, 10));
    }
}
