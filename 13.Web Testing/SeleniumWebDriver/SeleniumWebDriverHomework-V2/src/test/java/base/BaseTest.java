package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public enum BrowserTypes {
        CHROME,
        FIREFOX,
        EDGE
    }

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeAll
    public static void classSetUp() {
        // change browser type to run tests in different browsers and change headless to true if you want to run headless
        driver = startWebBrowser(BrowserTypes.CHROME, false);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterAll
    public static void classTearDown() {
        driver.close();
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

}
