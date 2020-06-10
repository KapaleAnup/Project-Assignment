package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
       super(driver);
    }


    @FindBy(xpath = "//h1[@class='reg-frm-head--txt']")
    private WebElement headerTitle;


    public String getheaderTitle(){
        return headerTitle.getText();
    }
}
