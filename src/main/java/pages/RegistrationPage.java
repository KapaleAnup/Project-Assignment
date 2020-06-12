package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    @FindBy(xpath = "//h1[@class='reg-frm-head--txt']")
    private WebElement headerTitle;


    /**
     * This constructor will Initiate with PageFactory class
     * @param driver
     */
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getheaderTitle(){
        return headerTitle.getText();
    }
}
