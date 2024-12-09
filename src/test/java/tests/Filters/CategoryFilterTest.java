package tests.Filters;

import org.testng.annotations.Test;
import sharedData.BaseTest;

public class CategoryFilterTest extends BaseTest {
    @Test
    public void categoryFilterTest(){
        helperMethods.click(homepageLocators.acceptConsent);
        helperMethods.hoverAndClick(homepageLocators.menDropdown, homepageLocators.dropdownMenTops);
        softAssert.assertTrue(menTopProducts.numberOfItemsPreFilterLabel.getText().contains(testData.MEN_TOPS_PREFILTER),"Number of total items mismatch");
        helperMethods.click(general.sidePanelList.get(0));
        helperMethods.click(menTopProducts.categoryJacketsButton);
        softAssert.assertEquals(menTopProducts.jacketsFilteredLabel.getText(),testData.MEN_TOPS_JACKETS+" Items","Wrong number of Jackets");
        softAssert.assertTrue(general.activeFiltersList.get(0).getText().contains("Category Jackets"),"Filter Category Jackets not applied");
        softAssert.assertAll();
    }




    //go to /men/tops-men.html
    //assert 48 total items
    //click on category dropdown
    //click on tanks
    //assert filters in left panel
    //assert 12 items
    //assert list elements contains "tank"
}
