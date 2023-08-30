package saucedemo;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void validLogin_when_validCredentialsProvided() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.navigate();
        loginPage.assertNavigated();

        loginPage.fillLoginForm("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver, wait);
        inventoryPage.navigate();
        inventoryPage.assertNavigated();

//        WebElement hamburgerBtn = driver.findElement(By.id("react-burger-menu-btn"));
//        hamburgerBtn.click();
//
//        WebElement logoutBtn = driver.findElement(By.id("logout_sidebar_link"));
//        wait.until(ExpectedConditions.visibilityOf(logoutBtn));
//
//        Assertions.assertEquals("Logout", driver.findElement(By.id("logout_sidebar_link")).getText());
    }
}
