package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import testData.TestData;

import java.io.File;

public class BaseTest {

    public WebDriver driver;
    public SoftAssert softAssert;
    protected HomepageLocators homepageLocators;
    protected CreateAccountLocators createAccountLocators;
    protected MyAccountLocators myAccountLocators;
    protected MenTopProducts menTopProducts;
    protected TestData testData;
    protected General general;
    protected HelperMethods helperMethods ;



    public String getRandomEmail;
    public String getRandomPassword;
    public String getRandomFirstName;
    public String getRandomLastName;


    public BaseTest() {
        // Generate random data once for the entire test class.
        getRandomEmail = CredentialsGenerator.getRandomEmail();
        getRandomPassword = CredentialsGenerator.getRandomPassword();
        getRandomFirstName = CredentialsGenerator.generateRandomFirstName(5);
        getRandomLastName = CredentialsGenerator.generateRandomLastName(7);
    }
    @BeforeMethod
    public void prepareEnvironment(){
        ChromeOptions options = new ChromeOptions();

        // Adaugă extensia uBlock Origin
        options.addExtensions(new File("C:\\Users\\radun\\Documents\\CJPALHDLNBPAFIAMEJDNHCPHJBKEIAGM_1_61_2_0.crx"));


        driver = new ChromeDriver(options);
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();

        softAssert=new SoftAssert();
        homepageLocators =new HomepageLocators(driver);
        createAccountLocators= new CreateAccountLocators(driver);
        myAccountLocators=new MyAccountLocators(driver);
        menTopProducts=new MenTopProducts(driver);
        helperMethods=new HelperMethods(getDriver());
        testData=new TestData();
        general=new General(driver);

    }

//    @AfterMethod
//    public void clearEnvironment(){
//
//        driver.quit();
//
//    }
    public WebDriver getDriver() {
        return driver;
    }
}