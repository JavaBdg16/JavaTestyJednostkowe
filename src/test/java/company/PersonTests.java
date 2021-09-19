package company;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static company.PersonAssertion.*;

public class PersonTests {

    @Test
    public void equalityTest() {

        Person person1 = new Person("Jan", "Nowak");
        // Person person2 = new Person("Jan", "Nowak");
        Person person2 = person1;

        assertThat(person1).isEqualTo(person2);

        person2 = new Person("Jan", "Nowak");

        assertThat(person1).usingRecursiveComparison().isEqualTo(person2);
        assertThat(person1.getFirstName()).isEqualTo("Jan");
        assertThat(person1.getLastName()).isEqualTo("Nowak"); // assertEquals(person1.getLastName(), "Nowak");

        assertThat(person1).hasFullName("Jan", "Nowak");
        assertThat(person2).hasFullName("Jan", "Nowakk");
    }
}
