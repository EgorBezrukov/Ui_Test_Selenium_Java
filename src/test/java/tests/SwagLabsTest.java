package tests;

import driver.BaseSeleniumTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import swagLabsPages.LoginPage;

@DisplayName("Тесты для сайта https://www.saucedemo.com/")
public class SwagLabsTest extends BaseSeleniumTest {
    private static LoginPage loginPage;
    @BeforeAll
    public static void init() {
        loginPage = new LoginPage();
    }

    @Test
    @DisplayName("Успешный вход")
    @Description("Проверить, что при вводе правильного логина и пароля пользователь успешно авторизуется и перенаправляется на страницу с продуктами")
    public void successfullyLogin() {
        loginPage
                .successAuth(SWAGLAB_LOGIN, SWAGLAB_PASSWORD)
                .checkPageOpen(SWAGLAB_PRODUCT_PAGE_URL)
                .logout();
    }

    @Test
    @DisplayName("Вход с пустыми полями")
    @Description("Вход с пустыми полями логина и пароля, проверка сообщения об ошибке")
    public void emptiesField() {
        loginPage.
                unSuccessAuth("", "").
                checkErrorMessage("Epic sadface: Username is required")
                .cleanField();
    }

    @Test
    @DisplayName("Вход с невалидным логином")
    @Description("Проверить, что при вводе неправильного логина или пароля отображается сообщение об ошибке")
    public void incorrectLogin() {
        loginPage.
                unSuccessAuth(HELPDESK_LOGIN, SWAGLAB_PASSWORD).
                checkErrorMessage("Epic sadface: Username and password do not match any user in this service")
                .cleanField();
    }

    @Test
    @DisplayName("Проверка количества элементов на странице")
    @Description("Проверить, что при входе на главную страницу, количество элементов равно 6")
    public void checkSizeElement() {
        loginPage.
                successAuth(SWAGLAB_LOGIN, SWAGLAB_PASSWORD).
                checkSizePageElements(6)
                .logout();
    }

    @Test
    @DisplayName("Пользовательский сценарий, выполнение покупки")
    public void swagShopUserCase() {
        loginPage.
                successAuth(SWAGLAB_LOGIN, SWAGLAB_PASSWORD).
                addToCart().
                checkoutBtnClick().
                fillField("Lol","Balabol","1231").
                checkAmount("$29.99")
                .logout();
    }
}
