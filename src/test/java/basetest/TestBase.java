package basetest;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;

public class TestBase {

    private static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
                driver = initChromeDriver(appURL);
        }
    }

    /**
     * This method will return chromedriver with url.
     * @param appURL
     * @return
     *
     * Used WebDriverManager class to fetch the driver properties directly instead of assigning in path
     */
    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome..");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }
    /**
     * This method will return firefoxdriver with url.
     * @param appURL
     * @return
     *
     * Used WebDriverManager class to fetch the driver properties directly instead of assigning in path
     */
    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser..");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.navigate().to(appURL);
        return driver;
    }

    /**
     * This method will invoke the browser and url
     * @param browserType
     * @param appURL
     *
     * Eg: browserType=chrome , appURL = url of the application.
     */
    @Parameters({ "browserType", "appURL" })
    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL) {
        try {
            setDriver(browserType, appURL);

        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }

    /**
     * This is screeshot capture utility which will called when the testcase will get failed.
     * @param result
     */
    @BeforeMethod
    public void failedTestCasesScreenshots(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot image = (TakesScreenshot) driver;
            File screenshot = image.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot,new File("src/test/resources/Screenshots" + result.getName() + ".png"));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * This method will help to close or quite the open browsers.
     */
    @AfterClass
    public void tearDown() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

}
