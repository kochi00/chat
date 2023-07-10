package jp.ac.shibaura_it.infolab1.chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class loginTest {
    Users users;
    Login login;
    @BeforeEach
    void before() {
        users = new Users();
        login = new Login();
        users.addUser("test-name", "test-password");
    }
    @Test
    void test_login() {
        assertThat(login.login("test-name", "test-password", users), is(1));
    }
    @Test
    void test_login2() {
        assertThat(login.login("test-name2", "test-password2", users), is(0));
    }
}
