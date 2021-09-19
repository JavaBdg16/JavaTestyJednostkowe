package company;

import static org.junit.jupiter.api.Assertions.fail;

public class JunitCustomAssertions {

    public static void assertSomething(boolean val) {
        if (!val) {
             fail("expecting true value");
        }
    }

    public static void assertPersonFullname(Person person, String firstName, String lastName) {
        if (!person.getFirstName().equals(firstName) ||
                !person.getLastName().equals(lastName)) {

            fail("full name asserion failed");

        }
    }
}
