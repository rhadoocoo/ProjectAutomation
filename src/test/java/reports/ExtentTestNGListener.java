package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import sharedData.BaseTest;

public class ExtentTestNGListener implements ITestListener {
    private static ExtentReports extent = createInstance("test-output/extent.html");
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        sparkReporter.config().setDocumentTitle("Test Report");
        sparkReporter.config().setReportName("Automated Test Results");
        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Radu");
        return extent;
    }

    @Override
    public void onStart(ITestContext context) {
        // Poate fi folosit pentru setări globale
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
                result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
        // Adaugă capturi de ecran
        Object currentClass = result.getInstance();
        if (currentClass instanceof BaseTest) {
            WebDriver driver = ((BaseTest) currentClass).getDriver();
            if (driver != null) {
                try {
                    String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
                    test.get().addScreenCaptureFromBase64String(base64Screenshot, "Failed Test Screenshot");
                } catch (Exception e) {
                    test.get().fail("Failed to capture screenshot: " + e.getMessage());
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Implementare dacă este necesar
    }
}