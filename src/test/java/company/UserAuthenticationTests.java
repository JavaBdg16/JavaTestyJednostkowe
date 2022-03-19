package company;

import company.model.User;
import company.service.UserAuthenticationProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static company.JunitCustomAssertions.*;

public class UserAuthenticationTests {

    @Test
    public void loginTest() {

        UserAuthenticationProvider provider = new UserAuthenticationProvider();
        User user = provider.login("jnowak@op.pl", "pA$w0rD");

        assertNotNull(user);
        assertEquals(user.getLogin(), "jnowak@op.pl");
    }

    @Test
    public void registerTest() {
        UserAuthenticationProvider provider = new UserAuthenticationProvider();
        User user = provider.register("jnowk@op.pl", "pA$w0rD", "adres");

        assertNotNull(user);
        assertEquals(user.getLogin(), "jnowk@op.pl");
        assertEquals(user.getStreet(), "adres");

        // assertArrayEquals(user.getRoles(), new String[]{ "admin" });
    }

    @Test
    public void adminRoleTest() {
        UserAuthenticationProvider provider = new UserAuthenticationProvider();
        User user = provider.login("admin", "pA$w0rD");

        assertNotNull(user);
        assertEquals(user.getLogin(), "admin");
        // assertArrayContains(user.getRoles(), "admin");
    }
}
