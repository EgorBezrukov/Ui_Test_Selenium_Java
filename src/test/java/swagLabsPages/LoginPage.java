package swagLabsPages;

import driver.BaseSeleniumPage;
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
        if (!driver.getTitle().equals("Swag Labs")) {
            throw new IllegalStateException("This is not Login Page, " +
                    "current page is: "+ driver.getCurrentUrl());
        }
    }

    @Step("Успешная авторизация")
    public ProductsPage successAuth(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password, Keys.ENTER);
        return new ProductsPage();
    }
    @Step("Неуспешная авторизация")
    public LoginPage unSuccessAuth(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password, Keys.ENTER);
        return this;
    }

    @Step("Проверить, что отображаемое сообщение равно ожидаемому")
    public LoginPage checkErrorMessage(String message) {
        String result = errorMessage.getText();
        Assertions.assertEquals(result, message);
        return this;
    }
    @Step("Очистить поля логина и пароля")
    public LoginPage cleanField(){
        loginField.clear();
        passwordField.clear();
        return this;
    }
}
