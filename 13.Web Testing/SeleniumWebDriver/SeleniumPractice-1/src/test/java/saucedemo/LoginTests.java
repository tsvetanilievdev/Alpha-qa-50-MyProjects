package saucedemo;

import base.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        authenticatedWithUser("standard_user", "secret_sauce");
        //Add assert
    }
}
