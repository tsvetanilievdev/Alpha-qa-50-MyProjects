package googlesearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    @Test
    public void test() {
        // Setup browser
        WebDriver driver = new ChromeDriver();

        // Navigate to Google.com
        driver.get("https://www.google.com/");
        // Type Text in search field

        // Click search button

        // Assert Result found

        driver.close();
    }
}
