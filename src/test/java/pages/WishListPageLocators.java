package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPageLocators {
    @FindBy(xpath="(//p)[2]")
    public WebElement itemsInWishlistLabel;

    @FindBy(xpath="//span[@class='base']")
    public WebElement wishListTitleLabel;

    @FindBy(xpath="//div[@class='actions-secondary']/a[@title='Remove This Item']")
    public WebElement removeItemFromWishlistButton;

    public WishListPageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
