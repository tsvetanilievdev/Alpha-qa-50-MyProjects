package saucedemo;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTestsParametrized extends BaseTest {

    @BeforeEach
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
    }
    @ParameterizedTest
    @CsvSource({"standard_user,secret_sauce",
            "locked_out_user,secret_sauce",
            "problem_user,secret_sauce",
            "performance_glitch_user,secret_sauce"})
    public void loginWithValidCredentials(String username, String password) {
        authenticatedWithUser(username, password);

        WebElement hamburgerBtn = driver.findElement(By.id("react-burger-menu-btn"));
        hamburgerBtn.click();

        WebElement logoutBtn = driver.findElement(By.id("logout_sidebar_link"));
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));

        Assertions.assertEquals("Logout", driver.findElement(By.id("logout_sidebar_link")).getText());
    }

}
