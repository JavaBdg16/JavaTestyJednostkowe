package zadania.zadanie32;

import java.util.Scanner;

public class Worker extends Person {

    private String education;
    private String workplace;

    @Override
    public void init() {
        super.init();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź wykształcenie: ");
        education = scanner.nextLine();

        System.out.println("Wprowadź stanowisko pracy: ");
        workplace = scanner.nextLine();
    }

    @Override
    void print() {
        System.out.printf("Person first name is %s, " +
                        "last name is %s, " +
                        "city is %s, " +
                        "postal code is %s, " +
                        "street is %s, " +
                        "education is %s, " +
                        "workplace is %s\n",
                getFirstName(), getLastName(), getCity(), getPostalCode(), getStreet(), education, workplace);
    }
}
