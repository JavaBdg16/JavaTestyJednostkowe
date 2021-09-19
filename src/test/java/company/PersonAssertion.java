package company;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.RecursiveComparisonAssert;

public class PersonAssertion extends AbstractAssert<PersonAssertion, Person> {

    public PersonAssertion(Person person) {
        super(person, PersonAssertion.class);
    }

    public static PersonAssertion assertThat(Person actual) {
        return new PersonAssertion(actual);
    }

    @Override
    public RecursiveComparisonAssert<?> usingRecursiveComparison() {
        return super.usingRecursiveComparison();
    }

    public PersonAssertion hasFullName(String firstName, String lastName) {
        isNotNull();

        // assertThat(person1) --> actual == person1
        if (!actual.getFirstName().equals(firstName) ||
            !actual.getLastName().equals(lastName)) {

            failWithMessage("Expected person to have full name %s %s but was %s %s",
                    firstName, lastName, actual.getFirstName(), actual.getLastName());

        }

        return this;

        // assertThat(person1).hasFullName("Jan", "Nowak").equalsTo().
    }


}
