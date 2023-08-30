package saucedemo;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.InventoryPage;

import java.util.List;

public class ProductTests extends BaseTest {
    String productOne = "Sauce Labs Backpack";
    Double productOnePrice = 29.99;
    String productTwo = "Sauce Labs Bolt T-Shirt";
    Double productTwoPrice = 15.99;
    String firstName = "JohnFirst";
    String lastName = "DoeLast";
    String postalCode = "12345";

    @BeforeEach
    public void login() {
        driver.get("https://www.saucedemo.com/");
        authenticatedWithUser("standard_user", "secret_sauce");
    }

    @Test
    public void productAddedToShoppingCart_when_addToCart() {
        try {
            addProductToCartByTitle(productOne);
            addProductToCartByTitle(productTwo);
            WebElement cartBtn = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));

            Assertions.assertEquals("2", cartBtn.findElement(By.cssSelector("span")).getText(), "The number of items in the cart is not correct");
            cartBtn.click();
            WebElement productOneIntoCart = findProductInCart(productOne);
            WebElement productTwoIntoCart = findProductInCart(productTwo);
            Assertions.assertTrue(productOneIntoCart.isDisplayed());
            Assertions.assertTrue(productOneIntoCart.isDisplayed());

            //Clear cart
            productOneIntoCart.findElement(By.cssSelector("button")).click();
            productTwoIntoCart.findElement(By.cssSelector("button")).click();
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() {

        try {
            addProductToCartByTitle(productOne);
            addProductToCartByTitle(productTwo);

            WebElement cartBtn = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
            cartBtn.click();

            WebElement checkoutBtn = driver.findElement(By.xpath("//div[@class='cart_footer']/button[contains(@class,'checkout_button')]"));
            checkoutBtn.click();

            WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='firstName']"));
            firstNameInput.sendKeys(firstName);
            WebElement lastNameInput = driver.findElement(By.xpath("//input[@name='lastName']"));
            lastNameInput.sendKeys(lastName);
            WebElement postalCodeInput = driver.findElement(By.xpath("//input[@name='postalCode']"));
            postalCodeInput.sendKeys(postalCode);

            WebElement continueBtn = driver.findElement(By.xpath("//input[@type='submit']"));
            continueBtn.click();

            List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
            Assertions.assertEquals(2, cartItems.size(), "The number of items in the cart is not correct");

            WebElement productOneSummary = cartItems.get(0);
            Assertions.assertEquals(productOne, productOneSummary.findElement(By.className("inventory_item_name")).getText(), "The product one name is not correct");

            double price = Double.valueOf(productOneSummary.findElement(By.className("inventory_item_price")).getText().split("\\$")[1]);
            Assertions.assertEquals(productOnePrice, price, "The product one price is " + price + " and should be " + productOnePrice);

            WebElement productTwoSummary = cartItems.get(1);
            Assertions.assertEquals(productTwo, productTwoSummary.findElement(By.className("inventory_item_name")).getText(), "The product two name is not correct");

            price = Double.valueOf(productTwoSummary.findElement(By.className("inventory_item_price")).getText().split("\\$")[1]);
            Assertions.assertEquals(productTwoPrice, price, "The product two price is " + price + " and should be " + productTwoPrice);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm() {
        InventoryPage inventoryPage = new InventoryPage(driver, wait);
        try {
            inventoryPage.addProductToCartByTitle(productOne);
            inventoryPage.addProductToCartByTitle(productTwo);

            inventoryPage.clickShoppingCartLink();

            WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='firstName']"));
            firstNameInput.sendKeys(firstName);
            WebElement lastNameInput = driver.findElement(By.xpath("//input[@name='lastName']"));
            lastNameInput.sendKeys(lastName);
            WebElement postalCodeInput = driver.findElement(By.xpath("//input[@name='postalCode']"));
            postalCodeInput.sendKeys(postalCode);

            WebElement continueBtn = driver.findElement(By.xpath("//input[@type='submit']"));
            continueBtn.click();

            WebElement confirmBtn = driver.findElement(By.xpath("//button[@name='finish']"));
            confirmBtn.click();

            WebElement confirmTitle = driver.findElement(By.xpath("//span[@class='title']"));
            Assertions.assertEquals("Checkout: Complete!".toLowerCase(), confirmTitle.getText().toLowerCase(), "The order is not completed");

//            cartBtn = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
//            Assertions.assertEquals("", cartBtn.findElement(By.cssSelector("a")).getText(), "The cart is not empty!");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    private void addProductToCartByTitle(String title) {
        try {
            WebElement cardContainer = driver.findElement(By.xpath(String.format("//div[@class='inventory_item' and descendant::div[text()='%s']]", title)));
            WebElement addBtn = cardContainer.findElement(By.className("btn_inventory"));
            addBtn.click();
        } catch (Exception e) {
            throw new RuntimeException(String.format("The product %s is not added", title));
        }
    }

    private WebElement findProductInCart(String title) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//div[@class='cart_item' and descendant::div[text()='%s']]", title))));
        } catch (Exception e) {
            throw new RuntimeException(String.format("The product %s is not displayed in the cart", title));
        }
        return driver.findElement(By.xpath(String.format("//div[@class='cart_item' and descendant::div[text()='%s']]", title)));
    }

}
