package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sharedData.BaseTest;

import java.time.Duration;

public class AddToWishlistTest extends BaseTest {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @Test
    public void addToWishlistLoggedIn() throws InterruptedException {

        helperMethods.click(general.signInButton);
        helperMethods.completeField(customerLoginPageLocators.emailInput, testData.EMAIL);
        helperMethods.completeField(customerLoginPageLocators.passwordInput, testData.PASSWORD);
        helperMethods.click(customerLoginPageLocators.signInButton);
        helperMethods.hover(homepageLocators.menDropdown);
        helperMethods.click(homepageLocators.dropdownMenTops);
        WebElement selectedProduct = helperMethods.getRandomElementFromList();
        helperMethods.hover(selectedProduct);
        String productName = helperMethods.getProductName(selectedProduct);
        helperMethods.selectRandomColor(selectedProduct);
        helperMethods.selectRandomSize(selectedProduct);
        helperMethods.addToWishlist(selectedProduct);
        wait.until(ExpectedConditions.visibilityOf(general.notification));
        System.out.println(general.notification.getText());
        softAssert.assertEquals(general.notification.getText(),productName+ " has been added to your Wish List. Click here to continue shopping.","The product name added does not match");
        softAssert.assertEquals(wishListPageLocators.itemsInWishlistLabel.getText(),"1 Item","Item has not been added to wishlist");
        softAssert.assertEquals(wishListPageLocators.wishListTitleLabel.getText(),"My Wish List", "This is not wishlist page");
        helperMethods.click(wishListPageLocators.removeItemFromWishlistButton);
        softAssert.assertAll();


    }




}
