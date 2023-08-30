package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutYourInformationPage extends BasePage{
    public CheckoutYourInformationPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-step-one.html");
    }
//loc
    public By firstNameLoc = By.id("first-name");
    public By lastNameLoc = By.id("last-name");
    public By postalCodeLoc = By.id("postal-code");
    public By continueBtnLoc = By.id("continue");
    public void clickContinueBtn() {
        driver.findElement(continueBtnLoc).click();
    }

    public void fillShippingDetails(String firstName, String lastName, String zip) {
        driver.findElement(firstNameLoc).sendKeys(firstName);
        driver.findElement(lastNameLoc).sendKeys(lastName);
        driver.findElement(postalCodeLoc).sendKeys(zip);
    }

}
