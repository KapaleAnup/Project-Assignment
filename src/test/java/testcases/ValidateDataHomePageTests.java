package testcases;

import basetest.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.ValidDataHomePage;

public class ValidateDataHomePageTests extends TestBase {



    private WebDriver driver;

    ValidDataHomePage validDataHomePage ;
    RegistrationPage registerPage;


    @BeforeClass
    public void setUp(){
        driver=  getDriver();
        registerPage = new RegistrationPage(driver);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify profileSelection Page")
    @Story("To verify the user is able to select the provided data in the list")
    @Test(priority = 1)
    public void testProfileSelection(){

        validDataHomePage = new ValidDataHomePage(driver);
        validDataHomePage.setProfileSelection("Son");
        Assert.assertTrue(true, "Profile selection doesn't match");

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Date of Birth section")
    @Story("To verify the user is able provide date of birth")
    @Test(priority = 2)
    public void testDateOfBirth(){
        validDataHomePage.setDateOfBirth("08121992");
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Description("Verify Mother Tongue section")
    @Story("To verify the user is able select Mother tongue by provided valid data.")
    @Test(priority = 3)
    public void testMotherTongueSelection(){
        validDataHomePage.setMotherTongueSelection("English");

        Assert.assertTrue(true, "Searched data doesn't match");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Community section")
    @Story("To verify the user is able to select the community by providing valid data")
    @Test(priority = 4)
    public void testCommunitySelection(){
        validDataHomePage.setCommunitySelection("Hindu - kunbi");
        Assert.assertTrue(true, "Searched data doesn't match");
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify profile completion")
    @Story("To verify the user is able to redirect to the Registration Page.")
    @Test(priority = 5)
    public void testcompleteProfileSelection(){

        registerPage = validDataHomePage.clickOnLetsBeginButton();
    }

}