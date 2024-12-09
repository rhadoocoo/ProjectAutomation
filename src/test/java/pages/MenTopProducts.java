package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenTopProducts {

    @FindBy(xpath="//div[@class='page-wrapper']//div[2]//p[1]")
    public WebElement numberOfItemsPreFilterLabel;

    @FindBy(xpath="//a[contains(text(),'Jackets')]")
    public WebElement categoryJacketsButton;

    @FindBy(xpath="//div[@class='page-wrapper']//div[2]//p[1]")
    public WebElement jacketsFilteredLabel;









    public MenTopProducts (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
