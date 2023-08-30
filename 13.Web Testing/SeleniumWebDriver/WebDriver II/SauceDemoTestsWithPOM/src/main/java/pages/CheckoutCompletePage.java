package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-complete.html");
    }

    public By shoppingCartLinkLoc = By.className("shopping_cart_link");
    public By completeHeaderLoc = By.className("complete-header");

    public boolean isShoppingCartEmpty(){
        return driver.findElement(shoppingCartLinkLoc).getText().isEmpty();
    }
    public String shoppingCartText(){
        return driver.findElement(shoppingCartLinkLoc).getText();
    }

    public String getCompleteHeaderText(){
        return driver.findElement(completeHeaderLoc).getText();
    }
}
