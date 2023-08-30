package search;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class TelerikAcademyAlphaSearchTests extends BaseTest {
    
    String searchTerm = "Telerik Academy Alpha";
    String searchResultExpected = "IT Career Start in 6 Months - Telerik Academy Alpha";

    @Test
    public void bingSearch_returned_expectedStringAsFirstResult() {
        //Navigate to bing.com
        driver.get("https://www.bing.com/");

        //Click agree to consent
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='bnp_btn_accept']")));
        WebElement agreeBtn = driver.findElement(By.xpath("//button[@id='bnp_btn_accept']"));
        agreeBtn.click();

        //Type text in search field
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='sb_form_q']"));
        searchInput.sendKeys(searchTerm);
        searchInput.click();

        //Click search button
        WebElement searchBtn = driver.findElement((By.xpath("//label[@id='search_icon']")));
        searchBtn.click();

        //Assert result found
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2/a")));
        WebElement firstSearchResultHeader = driver.findElement(By.xpath("//h2/a"));
        Assertions.assertEquals(searchResultExpected, firstSearchResultHeader.getText(),
                String.format("First search result does not equal '%s'", searchResultExpected));
    }

    @Test
    public void googleSearch_returned_expectedStringAsFirstResult() {
        //Navigate to google.com
        driver.get("https://www.google.com/");

        //Click agree to consent
        WebElement agreeBtn = driver.findElement(By.xpath("//button[@id='L2AGLb']"));
        agreeBtn.click();

        //Type text in search field
        WebElement searchInput = driver.findElement(By.xpath("//textarea[@type='search']"));
        searchInput.sendKeys(searchTerm);
        searchInput.click();

        //Click search button
        WebElement searchBtn = driver.findElement(By.xpath("(//input[@name='btnK'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
        searchBtn.click();

        //Assert result found
        WebElement firstSearchResultHeader = driver.findElement(By.xpath("(//h3)[1]"));
        Assertions.assertEquals(searchResultExpected, firstSearchResultHeader.getText(),
                String.format("First search result does not equal '%s'", searchResultExpected));
    }
}
