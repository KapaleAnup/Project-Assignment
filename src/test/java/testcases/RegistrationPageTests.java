package testcases;

import basetest.TestBase;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationPageTests extends TestBase {

    private WebDriver driver;


    RegistrationPage registerPage;


    @BeforeClass
    public void setUp(){
        driver=  getDriver();
        registerPage = new RegistrationPage(driver);

    }

    @Test(priority = 6)
    public void testTitle(){
        String pagetitle =  driver.getCurrentUrl();
        System.out.println(pagetitle);
        String headerTitle = registerPage.getheaderTitle();
        Assert.assertEquals(headerTitle, Constants.HEADER_TITLE,"Header Title doesn't match");

    }

}
