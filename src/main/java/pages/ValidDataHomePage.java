package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ValidDataHomePage {


    private WebDriver driver;
    private WebDriverWait wait;

    public String language;
    public String community;

    /**
     * This constructor will Initiate with PageFactory class
     * @param driver
     */
    public ValidDataHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //profile selection properties:
    @FindBy(xpath = "//div[contains(@class,'MuiInputBase-root-211')]")
    private WebElement profileSelection;

    @FindBy(xpath = "//ul[contains(@role,'listbox')]//li")
    private List<WebElement> profileListOptions;


    //Mother tongue selection properties:
    @FindBy(xpath = "//div[@class='Mt(20px)--s Mt(20px)--D']//div//div[@class='Pos(r) soft-half-h--ends Cur(p) txt-g-primary']")
    private WebElement motherTongueSelection;

    @FindBy(xpath = "//input[@placeholder='Search Mother Tongue']")
    private WebElement motherTongueSearch;

    @FindBy(xpath = "//div[@class='Mt(58px)']//div")
    private  List<WebElement>  motherTongueSearchedResult;


    //Community selection properties:
    @FindBy(xpath = "//div[@class='push--top']//div//div[@class='Pos(r) soft-half-h--ends Cur(p) txt-g-primary']")
    private WebElement communityProfileSelection;

    @FindBy(xpath = "//input[@type='custom-input']")
    private WebElement communitySearch;

    @FindBy(xpath = "//div[@class='Mt(58px)']//div")
    private List<WebElement> communitySearchResult;

    // Date of Birth selection:
    @FindBy(xpath = "//input[@class='mskd-inpt  ']")
    private WebElement dateOfBirth;

    //Lets begin button selection
    @FindBy(xpath ="//div[contains(text(),'Lets Begin')]" )
    private WebElement letsBeginbutton;

    //Error message xpath
    @FindBy(xpath = "//div[contains(@class,'push-half-h--top')]")
    private WebElement dateOfBirthErrorMessage;

    /**
     * This method is used for profile selection in the provided drop down.
     * @param option
     *
     * provide an value of the given list.
     */
    public void setProfileSelection(String option){
        profileSelection.click();
        List<WebElement> optionList =  profileListOptions;

        for (int i=0 ;i<optionList.size();i++){
            System.out.println(optionList.get(i).getText());
            if (optionList.get(i).getText().contains(option)){
                optionList.get(i).click();
                break;
            }
        }

    }

    /**
     * This method is used to select and search the mother tongue section.
     * @param mothertongue
     *
     * Provide value of mother tongue eg.English.
     */
    public void setMotherTongueSelection(String mothertongue){
        motherTongueSelection.click();
        motherTongueSearch.sendKeys(mothertongue);
        searchResultMotherTounge();
    }

    /**
     * This method is used to iterate the searched language
     */
    private void searchResultMotherTounge(){
        List<WebElement> listoflanguages = motherTongueSearchedResult;

        System.out.println(listoflanguages.size());

        for(int i=0;i<listoflanguages.size();i++){
            language = listoflanguages.get(i).getText();
            System.out.println(language);
            listoflanguages.get(i).click();

        }

    }

    /**
     * This method is used to select and search the community section.
     * @param community
     *
     *  Provide value of community eg.Hindu - Kunbi.
     */

    public void setCommunitySelection(String community){
        communityProfileSelection.click();
        communitySearch.sendKeys(community);
        searchResultCommunity();
    }

    private void searchResultCommunity(){
        List<WebElement> listOfCommunity = communitySearchResult;

        System.out.println(listOfCommunity.size());

        for(int i=0;i<listOfCommunity.size();i++){
            community = listOfCommunity.get(i).getText();
            System.out.println(community);
            listOfCommunity.get(i).click();

        }
    }

    /**
     * This method is used for providing date of birth
     * @param dateofbirth
     *
     *  Provide value for date of birth eg;08011991
     */
    public void setDateOfBirth(String dateofbirth){
        dateOfBirth.sendKeys(dateofbirth);
    }

    /**
     * It will provide text in return
     * @return
     */
    public String getErrorMessage(){
        return dateOfBirthErrorMessage.getText();
    }

    /**
     * This method will check if the button is active and click.
     * It will return RegistrationPage as next page to redirect and fetch the properties of that page.
     * @return
     */
    public RegistrationPage clickOnLetsBeginButton(){

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

        return new RegistrationPage(driver);

    }


}
