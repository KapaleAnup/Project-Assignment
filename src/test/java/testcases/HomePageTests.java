package testcases;

import basetest.TestBase;
import constants.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class HomePageTests extends TestBase {

    private WebDriver driver;

    HomePage homePage;


    @BeforeClass
    public void setUp(){
        driver=  getDriver();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("verify error messages")
    @Story("To verify the user is able to see the error messages")
    @Test
    public void testVerifyErrorMessages(){

        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.clickOnLetsBeginButton();
        String profileMessage = homePage.getCreateProfileErrorMessage();
        homePage.getCommunityErrorMessage();

        Assert.assertEquals(profileMessage,Constants.CREATE_PROFILE_ERROR_MESSAGE,
                "Error message doesn't match with the expected message.");
        String communityMessage = homePage.getCommunityErrorMessage();
        Assert.assertEquals(communityMessage,Constants.COMMUNITY_SELECTION_ERROR_MESSAGE,
                "Error message doesn't match with the expected message.");
    }
}
