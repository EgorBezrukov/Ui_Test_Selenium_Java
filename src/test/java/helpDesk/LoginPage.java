package helpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BaseSeleniumPage {
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    public TicketPage auth(String login, String password){
        usernameField.sendKeys(login);
        passwordField.sendKeys(password, Keys.ENTER);
        return new TicketPage();
    }

}
