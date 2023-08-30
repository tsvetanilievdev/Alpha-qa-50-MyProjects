package sausedemotests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsTests extends BaseTest {
    @BeforeEach
    public void beforeTest(){
        loginPage.navigate();
        loginPage.fillLoginForm("standard_user", "secret_sauce");
        inventoryPage.waitForPageTitle();
    }

    @Test
    public void productAddedToShoppingCart_when_addToCart(){

        String backpackTitle = "Sauce Labs Backpack";
        String shirtTitle = "Sauce Labs Bolt T-Shirt";

        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        List<WebElement> items = shoppingCartPage.getItems();

        Assertions.assertEquals(2, items.size(), "Items count not as expected");
        Assertions.assertEquals(backpackTitle, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(shirtTitle, items.get(1).getText(), "Item title not as expected");
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation(){
        String backpackTitle = "Sauce Labs Backpack";
        String shirtTitle = "Sauce Labs Bolt T-Shirt";
        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        shoppingCartPage.clickCheckoutBtn();

        // fill form
        checkoutYourInformationPage.fillShippingDetails("Fname", "lname", "zip");
        checkoutYourInformationPage.clickContinueBtn();

        // checkout overview page
        List<WebElement> items = checkoutOverviewPage.getItems();
        Assertions.assertEquals(2, items.size(), "Items count not as expected");

        double total = checkoutOverviewPage.getTotalDouble();
        double expectedPrice = 29.99 + 15.99 + 3.68;

        Assertions.assertEquals(2, items.size(), "Items count not as expected");
        Assertions.assertEquals(backpackTitle, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(shirtTitle, items.get(1).getText(), "Item title not as expected");
        Assertions.assertEquals(expectedPrice, total, "Items total price not as expected");
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm(){
        String backpackTitle = "Sauce Labs Backpack";
        String shirtTitle = "Sauce Labs Bolt T-Shirt";
        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        shoppingCartPage.clickCheckoutBtn();

        // fill form
        checkoutYourInformationPage.fillShippingDetails("Fname", "lname", "zip");
        checkoutYourInformationPage.clickContinueBtn();
        checkoutOverviewPage.clickFinishBtn();

        // Assert Items removed from Shopping Cart
        Assertions.assertEquals("Thank you for your order!", checkoutCompletePage.getCompleteHeaderText(), "Complete header text does not match!");
        Assertions.assertEquals(true, checkoutCompletePage.isShoppingCartEmpty(), "Shopping cart is not empty!");

    }
}