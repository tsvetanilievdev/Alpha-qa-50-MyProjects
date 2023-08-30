package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutYourInformationPage extends BasePage {
    public CheckoutYourInformationPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait, "/");
    }
    public By continueBtn = By.xpath("//div[@class='cart_footer']/button[contains(@class,'checkout_button')]");
    public void clickCheckoutButton() {
        driver.findElement(continueBtn).click();
    }

}
