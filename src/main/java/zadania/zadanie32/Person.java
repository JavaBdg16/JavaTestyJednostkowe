package zadania.zadanie32;

import java.util.Scanner;

public class Person {

    private String firstName;
    private String lastName;
    private String city;
    private String postalCode;
    private String street;

    void init() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź imię: ");
        firstName = scanner.nextLine();

        System.out.println("Wprowadź nazwisko: ");
        lastName = scanner.nextLine();

        System.out.println("Wprowadź miasto: ");
        city = scanner.nextLine();

        System.out.println("Wprowadź kod pocztowy: ");
        postalCode = scanner.nextLine();

        System.out.println("Wprowadź ulicę: ");
        street = scanner.nextLine();
    }

    void print() {
        System.out.printf("Person first name is %s, " +
                "last name is %s, " +
                "city is %s, " +
                "postal code is %s, " +
                "and street is %s\n",
                firstName, lastName, city, postalCode, street);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }
}
