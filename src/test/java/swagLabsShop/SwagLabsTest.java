package swagLabsShop;

import core.BaseSeleniumTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import readProperties.ConfigProvider;

@DisplayName("Тесты для сайта https://www.saucedemo.com/")
public class SwagLabsTest extends BaseSeleniumTest {
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
        loginPage.auth("", "");
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

    @Test
    @DisplayName("Проверка колличесва элементов на странице")
    @Description("Проверить, что при входе на главную страницу, колличесва элементов равно 6")
    public void checkSizeElement() {
        LoginPage loginPage = new LoginPage();
        loginPage.auth(ConfigProvider.SWAG_LOGIN, ConfigProvider.SWAG_PASSWORD)
                .checkSizePageElements(6);
    }

    @Test
    @DisplayName("Пользовательский сценарий, выполнение покупки")
    public void swagShopUserCase() {
        LoginPage loginPage = new LoginPage();
        loginPage.auth(ConfigProvider.SWAG_LOGIN, ConfigProvider.SWAG_PASSWORD)
                .addToCart()
                .checkoutBtnClick()
                .fillField("Lol","Balabol","1231")
                .checkAmount("$29.99");
    }
}
