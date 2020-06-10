package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    protected WebDriver driver;

  //  CommanActions commanActions;

    @FindBy(xpath ="//div[contains(text(),'Lets Begin')]" )
    private WebElement letsBeginbutton;

    @FindBy(xpath = "//p[contains(@class,'MuiFormHelperText')]")
    private WebElement createProfileErrorMessage;

    @FindBy(xpath = "//span[@class='text--danger txt-xs']")
    private WebElement communityErrorMessage;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getCreateProfileErrorMessage(){

        String errorMessageProfile = createProfileErrorMessage.getText();
        System.out.println(errorMessageProfile);
        return errorMessageProfile;
    }


    public String getCommunityErrorMessage(){

        String errorMessage = communityErrorMessage.getText();
        System.out.println(errorMessage);
        return errorMessage;
    }

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
