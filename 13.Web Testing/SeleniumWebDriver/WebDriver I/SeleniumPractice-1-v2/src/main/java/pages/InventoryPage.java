package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait, "/inventory.html");
    }
    public By shoppingCartBtn = By.xpath("//div[@id='shopping_cart_container']");
    public By hamburgerMenu = By.xpath("//button[@id='react-burger-menu-btn']");

    public void clickShoppingCartLink() {
        var btn = driver.findElement(shoppingCartBtn);
        btn.click();
    }


    public void addProductToCartByTitle(String title) {
        try {
            WebElement cardContainer = driver.findElement(By.xpath(String.format("//div[@class='inventory_item' and descendant::div[text()='%s']]", title)));
            WebElement addBtn = cardContainer.findElement(By.className("btn_inventory"));
            addBtn.click();
        } catch (Exception e) {
            throw new RuntimeException(String.format("The product %s is not added", title));
        }
    }
}
