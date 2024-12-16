package sharedData;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HelperMethods extends BaseTest {


    public HelperMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptConsentIfPresent() {
        WebElement consentButtons = homepageLocators.acceptConsent;
        if (!consentButtons.isDisplayed()) {
            consentButtons.click();
        }
    }

    public void hover(WebElement element) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
        TimeUnit.SECONDS.sleep(1);

    }

    public void clickJS(WebElement button) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", button);
    }
    public void click(WebElement button) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element =wait.until(ExpectedConditions.visibilityOf(button));
        element.click();
    }

    public void completeField(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    public void selectRandomColor(WebElement product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement colorList = wait.until(ExpectedConditions.visibilityOf(
                product.findElement(By.xpath(".//div[@aria-label='Color']"))
        ));

        List<WebElement> colorOptions = wait.until(ExpectedConditions.visibilityOfAllElements(
                colorList.findElements(By.xpath(".//div[@role='option']"))
        ));
        int randomColorIndex = new Random().nextInt(colorOptions.size());
        WebElement selectedColor = colorOptions.get(randomColorIndex);
        clickJS(selectedColor);
    }

    public void selectRandomSize(WebElement product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement sizeList = wait.until(ExpectedConditions.visibilityOf(
                product.findElement(By.xpath(".//div[@aria-label='Size']"))
        ));

        List<WebElement> sizeOptions = wait.until(ExpectedConditions.visibilityOfAllElements(
                sizeList.findElements(By.xpath(".//div[@role='option']"))
        ));
        int randomSizeIndex = new Random().nextInt(sizeOptions.size());
        WebElement selectedSize = sizeOptions.get(randomSizeIndex);
        clickJS(selectedSize);
    }

    public void addToCart(WebElement product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                product.findElement(By.xpath(".//button[@title='Add to Cart']"))
        ));
        click(addToCartButton);
    }

    public void addToWishlist(WebElement product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToWishlistButton = wait.until(ExpectedConditions.elementToBeClickable(
                product.findElement(By.xpath(".//a[@title='Add to Wish List']"))
        ));
        click(addToWishlistButton);
    }

    public WebElement getRandomElementFromList() {
        List<WebElement> products = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li"));
        int randomIndex = new Random().nextInt(products.size());
        return products.get(randomIndex);
    }

    public String getProductName(WebElement product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productNameElement = wait.until(ExpectedConditions.visibilityOf(
                product.findElement(By.xpath(".//strong[@class='product name product-item-name']"))
        ));

        return productNameElement.getText().trim();
    }

}



