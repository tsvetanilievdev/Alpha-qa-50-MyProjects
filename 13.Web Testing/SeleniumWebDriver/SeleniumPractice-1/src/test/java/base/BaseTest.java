package base;

import org.example.BrowserTypes;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeAll
    public static void classSetUp() {
        driver = startWebBrowser(BrowserTypes.CHROME, false);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
    }

    @AfterAll
    public static void classTearDown() {
//        driver.close();
    }

    public static WebDriver startWebBrowser(BrowserTypes type, boolean headless) {
        switch (type) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }
                return new FirefoxDriver(firefoxOptions);
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless");
                }
                return new EdgeDriver(edgeOptions);
        }
        return null;
    }

    protected void authenticatedWithUser(String username, String password){
        WebElement usernameElement = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameElement.sendKeys(username);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
        passwordElement.sendKeys(password);
        WebElement loginButtonElement = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButtonElement.click();
        WebElement inventoryIcon = driver.findElement(By.xpath("//div[@class='app_logo']"));
        wait.until(ExpectedConditions.visibilityOf(inventoryIcon));
    }

}
