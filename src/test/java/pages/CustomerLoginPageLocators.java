package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPageLocators {
    @FindBy(id="email")
    public WebElement emailInput;

    @FindBy(id="pass")
    public WebElement passwordInput;

    @FindBy(id="send2")
    public WebElement signInButton;

    public CustomerLoginPageLocators (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
