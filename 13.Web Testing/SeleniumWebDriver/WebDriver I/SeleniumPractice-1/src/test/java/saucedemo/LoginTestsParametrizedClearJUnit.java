package saucedemo;

import base.BaseTest;
import org.example.BrowserTypes;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class LoginTestsParametrizedClearJUnit{
    static WebDriver driver = BaseTest.startWebBrowser(BrowserTypes.CHROME, false);
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    @Before
    public void classSetUp() {
        driver.get("https://www.saucedemo.com/");
    }
    @AfterClass
    public static void classTearDown() {
        driver.close();
    }

    @Parameterized.Parameters(name = " ---> Login credentials: >>> user: {0} >>> password: {1}")
    public static Iterable<Object[]> data(){
        //DO WHAT YOU WANT HERE
        return Arrays.asList(new Object[][] {
                {"standard_user","secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user","secret_sauce"}});
    }
    @Parameterized.Parameter(value = 0)
    public String username;
    @Parameterized.Parameter(value = 1)
    public String password;
    @Test
    public void loginWithValidCredentials() {
//        driver.get("https://www.saucedemo.com/");
        WebElement usernameElement = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameElement.sendKeys(username);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
        passwordElement.sendKeys(password);
        WebElement loginButtonElement = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButtonElement.click();
        WebElement inventoryIcon = driver.findElement(By.xpath("//div[@class='app_logo']"));
        wait.until(ExpectedConditions.visibilityOf(inventoryIcon));

        WebElement hamburgerBtn = driver.findElement(By.id("react-burger-menu-btn"));
        hamburgerBtn.click();

        WebElement logoutBtn = driver.findElement(By.id("logout_sidebar_link"));
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));
        Assert.assertEquals("Logout", driver.findElement(By.id("logout_sidebar_link")).getText());
    }

//    @Test
//    public void test(){
//        Assert.assertEquals("standard_user",username);
//    }

}
