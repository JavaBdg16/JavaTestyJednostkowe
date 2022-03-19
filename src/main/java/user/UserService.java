package user;

public class UserService {

    private final PeselValidator peselValidator;

    public UserService(PeselValidator peselValidator) {
        this.peselValidator = peselValidator;
    }

    public boolean setPesel(String pesel) {
        try {
            peselValidator.setPesel(pesel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Sex getSex() throws Exception {

        if (peselValidator.plec().equals("Mezczyzna")) {
            return Sex.M;
        } else if (peselValidator.plec().equals("Kobieta")) {
            return Sex.W;
        } else {
            throw new Exception("Unknown sex");
        }
    }
}
