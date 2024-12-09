package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountLocators {
    public MyAccountLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
