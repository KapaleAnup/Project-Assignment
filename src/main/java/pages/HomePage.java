package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    protected WebDriver driver;

  //  CommanActions commanActions;

    @FindBy(xpath ="//div[contains(text(),'Lets Begin')]" )
    private WebElement letsBeginbutton;

    @FindBy(xpath = "//p[contains(@class,'MuiFormHelperText')]")
    private WebElement createProfileErrorMessage;

    @FindBy(xpath = "//span[@class='text--danger txt-xs']")
    private WebElement communityErrorMessage;


    /**
     * This constructor will call the super(parent properties) by extending the BasePage class.
     * @param driver
     */
    public HomePage(WebDriver driver){
       super(driver);
    }

    /**
     * This method will help to get error message of profile section
     * @return
     */
    public String getCreateProfileErrorMessage(){

        String errorMessageProfile = createProfileErrorMessage.getText();
        System.out.println(errorMessageProfile);
        return errorMessageProfile;
    }

    /**
     * This method will help to get error message of Community section
     * @return
     */
    public String getCommunityErrorMessage(){

        String errorMessage = communityErrorMessage.getText();
        System.out.println(errorMessage);
        return errorMessage;
    }

    /**
     * This method will check if the button is active and click.
     *
     */
    public void clickOnLetsBeginButton(){

        WebElement letsbeginbtn = letsBeginbutton;
        try {
            if (letsbeginbtn.isDisplayed() || letsbeginbtn.isEnabled()) {
                letsbeginbtn.click();
                System.out.println("Button is clicked");
            } else {
                System.out.println("Element is not found");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
