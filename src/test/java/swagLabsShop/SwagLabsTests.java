package swagLabsShop;

import core.BaseSeleniumTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import readProperties.ConfigProvider;

public class SwagLabsTests extends BaseSeleniumTest {

    @DisplayName("Успешный вход")
    @Description("Проверить, что при вводе правильного логина и пароля пользователь успешно авторизуется и перенаправляется на страницу с продуктами")
    public void successfullyLogged() {
        driver.get(ConfigProvider.SWAG_BASE_URL);
        driver.findElement(By.cssSelector("#user-name")).sendKeys(ConfigProvider.SWAG_LOGIN);
        driver.findElement(By.cssSelector("#password")).sendKeys(ConfigProvider.SWAG_PASSWORD, Keys.ENTER);
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(url, ConfigProvider.SWAG_PRODUCT_PAGE);
    }
    @Test
    @DisplayName("Успешный вход")
    @Description("Проверить, что при вводе правильного логина и пароля пользователь успешно авторизуется и перенаправляется на страницу с продуктами")
    public void successfullyLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.auth(ConfigProvider.SWAG_LOGIN, ConfigProvider.SWAG_PASSWORD);
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(url, ConfigProvider.SWAG_PRODUCT_PAGE);
    }

    @Test
    @DisplayName("Вход с пустыми полями")
    @Description("Вход с пустыми полями логина и пароля, проверка сообщения об ошибке")
    public void emptiesField() {
        LoginPage loginPage = new LoginPage();
        loginPage.auth("","");
        String url = driver.getCurrentUrl();
        loginPage.checkErrorMessage("Epic sadface: Username is required");
    }

    @Test
    @DisplayName("Вход с невалидным логином")
    @Description("Проверить, что при вводе неправильного логина или пароля отображается сообщение об ошибке")
    public void incorrectLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.auth(ConfigProvider.DEMO_LOGIN, ConfigProvider.SWAG_PASSWORD);
        loginPage.checkErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }
}
