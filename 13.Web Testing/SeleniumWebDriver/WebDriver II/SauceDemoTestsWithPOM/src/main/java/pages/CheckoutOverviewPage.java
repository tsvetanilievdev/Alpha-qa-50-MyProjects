package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-step-two.html");
    }

    public By addedItemsLoc = By.className("inventory_item_name");
    public By summaryTotalLoc = By.className("summary_total_label");
    public By finishBtnLoc = By.xpath("//button[@name='finish']");

    public List<WebElement> getItems() {
        return driver.findElements(addedItemsLoc);
    }

    public String getTotalString(){
        return driver.findElement(summaryTotalLoc).getText().replace("Total: $","");
    }
    public Double getTotalDouble(){
        return Double.parseDouble(getTotalString());
    }

    public void clickFinishBtn() {
        driver.findElement(finishBtnLoc).click();
    }
}
