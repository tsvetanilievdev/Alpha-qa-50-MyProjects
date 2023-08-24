package search;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TelerikAcademyAlphaSearchTests {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void classSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    @AfterAll
    public static void classTearDown() {
        driver.close();
    }

    @Test
    public void bingSearch_returned_providedStringAsFirstResult() {
        //Navigate to bing.com
        driver.get("https://www.bing.com/");

        //Click agree to consent
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='bnp_btn_accept']")));
        WebElement agreeBtn = driver.findElement(By.xpath("//button[@id='bnp_btn_accept']"));
        agreeBtn.click();

        //Type text in search field
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='sb_form_q']"));
        searchInput.sendKeys("Telerik Academy Alpha");
        searchInput.click();

        //Click search button
        WebElement searchBtn = driver.findElement((By.xpath("//label[@id='search_icon']")));
        searchBtn.click();

        //Assert result found
        WebElement firstSearchResultHeader = driver.findElement(By.xpath("//h2[contains(@class, 'b_topTitle')]/a"));
        Assertions.assertEquals("IT Career Start in 6 Months - Telerik Academy Alpha", firstSearchResultHeader.getText(),
                "First search result does not equal 'IT Career Start in 6 Months - Telerik Academy Alpha'");
    }

    @Test
    public void googleSearch_returned_providedStringAsFirstResult() {
        //Navigate to google.com
        driver.get("https://www.google.com/");

        //Click agree to consent
        WebElement agreeBtn = driver.findElement(By.xpath("//button[@id='L2AGLb']"));
        agreeBtn.click();

        //Type text in search field
        WebElement searchInput = driver.findElement(By.xpath("//textarea[@type='search']"));
        searchInput.sendKeys("Telerik Academy Alpha");
        searchInput.click();

        //Click search button
        WebElement searchBtn = driver.findElement(By.xpath("(//input[@name='btnK'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
        searchBtn.click();

        //Assert result found
        WebElement firstSearchResultHeader = driver.findElement(By.xpath("(//h3)[1]"));
        Assertions.assertEquals("IT Career Start in 6 Months - Telerik Academy Alpha", firstSearchResultHeader.getText(),
                "First search result does not contain 'IT Career Start in 6 Months - Telerik Academy Alpha'");
    }
}
