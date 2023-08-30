package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String pageSpecUrl;
    public BasePage(WebDriver webDriver, WebDriverWait webDriverWait, String pageSpecificUrl){
        driver = webDriver;
        wait = webDriverWait;
        pageSpecUrl = pageSpecificUrl;
    }

    private String basePageUrl = "https://www.saucedemo.com";
    public String getPageUrl(){
        return  basePageUrl + pageSpecUrl;
    }
    public void navigate(){
        driver.get(getPageUrl());
    }
    public void assertNavigated(){
        Assertions.assertEquals(getPageUrl(), driver.getCurrentUrl(), "Not navigated to login page");
    }
}
