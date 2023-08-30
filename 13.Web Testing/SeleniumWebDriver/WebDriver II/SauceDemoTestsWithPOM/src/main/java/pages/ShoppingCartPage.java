package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShoppingCartPage  extends BasePage {

    public ShoppingCartPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "cart.html");
    }

    public By itemsList = By.className("inventory_item_name");

    public List<WebElement> getItems() {
        return driver.findElements(itemsList);
    }
    public By checkoutBtnLoc = By.id("checkout");
    public void clickCheckoutBtn() {
        driver.findElement(checkoutBtnLoc).click();
    }
}
