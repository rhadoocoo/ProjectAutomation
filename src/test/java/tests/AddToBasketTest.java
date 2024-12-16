package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sharedData.BaseTest;

import java.time.Duration;

public class AddToBasketTest extends BaseTest {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @Test
    public void addItemToBasket() throws InterruptedException {
        //helperMethods.acceptConsentIfPresent();
        helperMethods.hover(homepageLocators.menDropdown);
        helperMethods.click(homepageLocators.dropdownMenTops);
        WebElement selectedProduct = helperMethods.getRandomElementFromList();
        helperMethods.hover(selectedProduct);
        String productName = helperMethods.getProductName(selectedProduct);
        helperMethods.selectRandomColor(selectedProduct);
        helperMethods.selectRandomSize(selectedProduct);
        helperMethods.addToCart(selectedProduct);
        wait.until(ExpectedConditions.visibilityOf(general.notification));
        softAssert.assertEquals(general.notification.getText(),"You added "+productName+" to your shopping cart.","The product name added does not match");
        softAssert.assertEquals(general.cartQuantityLabel.getText(),"1","Item has not been added to basket");
        softAssert.assertAll();
    }
}
