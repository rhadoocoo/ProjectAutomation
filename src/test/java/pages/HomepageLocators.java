package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageLocators {

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//a[@id='ui-id-5']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']")
    public WebElement menDropdown;

    @FindBy(xpath = "//a[@id='ui-id-17']//span[contains(text(),'Tops')]")
    public WebElement dropdownMenTops;

    @FindBy(xpath = "//div[@class='fc-footer-buttons']//button[@aria-label='Consent']")
    public WebElement acceptConsent;

    public HomepageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
