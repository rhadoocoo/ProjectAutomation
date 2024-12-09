package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountLocators {
    @FindBy(id="firstname")
    public WebElement firstNameField;

    @FindBy(id="lastname")
    public WebElement lastNameField;

    @FindBy(id="email_address")
    public WebElement emailField;

    @FindBy(id="password")
    public WebElement passwordField;
    @FindBy(id="password-confirmation")
    public WebElement passwordConfirmationField;

    @FindBy(xpath="//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
    public WebElement submitButton;

    public CreateAccountLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
