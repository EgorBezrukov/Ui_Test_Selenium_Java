package swagLabsShop;

import core.BaseSeleniumPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {

    @FindBy(css = "#user-name")
    private WebElement loginField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "[data-test=error]")
    private WebElement errorMessage;

    public LoginPage() {
        driver.get("https://www.saucedemo.com/");
        PageFactory.initElements(driver, this);
    }

    @Step("Выполнение авторизации")
    public ProductsPage auth(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password, Keys.ENTER);
        return new ProductsPage();
    }

    @Step("Проверяем, что отображаемое сообщение равно ожидаемому")
    public void checkErrorMessage(String message) {
        String result = errorMessage.getText();
        Assertions.assertEquals(result, message);
    }
}
