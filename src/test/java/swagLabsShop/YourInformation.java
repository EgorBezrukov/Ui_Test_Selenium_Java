package swagLabsShop;

import core.BaseSeleniumPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformation extends BaseSeleniumPage {

    @FindBy(name = "firstName")
    private WebElement firstNameField;
    @FindBy(name = "lastName")
    private WebElement lastNameField;
    @FindBy(name = "postalCode")
    private WebElement postalCodeField;
    @FindBy(css = "#continue")
    private WebElement continueBtn;

    public YourInformation() {
        PageFactory.initElements(driver, this);
    }
@Step("Заполняем информацию о себе и переходим на следующую страницу")
    public OverviewPage fillField(String firstName, String lastName, String postalCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        continueBtn.click();
        return new OverviewPage();
    }
}
