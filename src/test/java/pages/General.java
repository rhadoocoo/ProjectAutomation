package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class General {

    @FindBy(xpath="//div[@class='filter-options']/div[@data-role='collapsible']")
    public List<WebElement> sidePanelList;

    @FindBy(xpath="//div[@class='filter-current']//ol[@class='items']")
    public List<WebElement> activeFiltersList;

    @FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    public WebElement notification;

    @FindBy(xpath="//span[@class='counter-number']")
    public WebElement cartQuantityLabel;

    @FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
    public WebElement signInButton;



    public General (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
