package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class General {

    @FindBy(xpath="//div[@class='block-content filter-content']")
    public List<WebElement> sidePanelList;

    @FindBy(xpath="//div[@class='filter-current']//ol[@class='items']")
    public List<WebElement> activeFiltersList;



    public General (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
