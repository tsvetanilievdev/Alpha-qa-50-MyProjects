package saucedemo;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        authenticatedWithUser("standard_user", "secret_sauce");

        WebElement hamburgerBtn = driver.findElement(By.id("react-burger-menu-btn"));
        hamburgerBtn.click();

        WebElement logoutBtn = driver.findElement(By.id("logout_sidebar_link"));
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));

        Assertions.assertEquals("Logout", driver.findElement(By.id("logout_sidebar_link")).getText());
    }
}
