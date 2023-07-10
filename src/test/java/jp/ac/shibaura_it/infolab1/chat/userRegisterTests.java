package jp.ac.shibaura_it.infolab1.chat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import jp.ac.shibaura_it.infolab1.chat.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static java.lang.System.in;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class userRegisterTests {
    Users users;

    @BeforeEach
    void before() {

        users = new Users();
    }

    @Test
    void test_userRegister() {
        users.addUser("test-name", "test-password");
        users.Show();
        assertThat(users.userList.get(0).username, is("test-name"));
    }
    @Test
    void test_userRegister2() {
        users.addUser("test-name", "test-password");
        users.addUser("test-name", "test-password");
    }
    @Test
    void test_userRegister3() {
        users.addUser("test name", "test-password");
    }
}
