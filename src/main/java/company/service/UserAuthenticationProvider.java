package company.service;

import company.model.User;

public class UserAuthenticationProvider {
    public User login(String login, String password) {
        // TODO
        // robimy integrację z bazą danych i pobiera użytkownika
        // o loginie 'login' i weryfikuje, czy wprowadzone hasło
        // jest poprawne

        User user = new User();
        user.setLogin(login);

        return user;
    }

    public User register(String login, String passwors, String street) {

        User user = new User();
        user.setLogin(login);
        user.setStreet(street);

        return user;
    }
}
