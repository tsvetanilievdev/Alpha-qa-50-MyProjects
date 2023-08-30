package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver webDriver, WebDriverWait webDriverWait){
        super(webDriver, webDriverWait, "/");
    }

    //url
    //locators
    public By usernameInput = By.xpath("//input[@id='user-name']");
    public By passwordInput = By.xpath("//input[@id='password']");
    public By loginButton = By.xpath("//input[@id='login-button']");
    //methods
    public void fillLoginForm(String username, String password){
        WebElement usernameElement = driver.findElement(usernameInput);
        usernameElement.sendKeys(username);
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.sendKeys(password);
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }


    //asserts??? must be at test level i
}
