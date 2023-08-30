package saucedemo;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductTest extends BaseTest {

    @BeforeEach
    public void login() {
        authenticatedWithUser("standard_user", "secret_sauce");
    }

    @Test
    public void addBackpackAndTShirtToCart() {
        WebElement addBackpackBtn = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addBackpackBtn.click();

        WebElement addTShirtBtn = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        addTShirtBtn.click();

        WebElement cartIcon = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
        wait.until(ExpectedConditions.visibilityOf(cartIcon));
        cartIcon.click();

        //Add assert
//        Assertions.assertEquals("");
//        WebElement checkoutBtn = driver.findElement(By.xpath("//button[@id='checkout']"));
//        checkoutBtn.click();
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() {

    }
}
