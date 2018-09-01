package spring.tdd.sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertionsBasic {

    Person person = new Person("sieun", 1981);
    Person irene = new Person("irene", 1991, Person.Gender.F);

    @Test
    void standardAssertions(){
        assertEquals(7,7);
        assertNotEquals(3,7);
        assertTrue(3 < 7);

        assertEquals("sieun",person.getName());
        assertTrue(1985 > person.getBorn());
    }

    @Test
    void groupedAssertions() {
        assertAll("person",
                () -> assertEquals("sieun", person.getName()),
                () -> assertEquals("1981", person.getBorn().toString())
        );
    }

    @Test
    void dependentAssertions() {

        assertAll("properties",
                () -> {
                    String name = person.getName();
                    assertNotNull(name);

                    assertAll("name",
                            () -> assertTrue(name.startsWith("s")),
                            () -> assertTrue(name.endsWith("n"))
                    );
                },
                () -> {
                    Person.Gender gender = person.getGender();
                    assertNull(gender);
                },
                () -> {
                    Person.Gender gender = irene.getGender();
                    assertNotNull(gender);

                    assertAll("아이린",
                            () -> assertEquals("irene", irene.getName()),
                            () -> assertEquals(Person.Gender.F, irene.getGender())
                    );
                }
        );
    }

}
