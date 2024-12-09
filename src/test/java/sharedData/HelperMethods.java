package sharedData;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperMethods extends Hooks{


    public HelperMethods(WebDriver driver) {
        this.driver = driver;

    }
    public void hoverAndClick(WebElement hoverElement, WebElement clickElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
    }

    public void click(WebElement button) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",button);
    }

    public void completeField(WebElement element, String textToSend){
        element.sendKeys(textToSend);
    }
}
