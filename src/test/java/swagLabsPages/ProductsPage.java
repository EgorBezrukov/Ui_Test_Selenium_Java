package swagLabsPages;

import driver.BaseSeleniumPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends BaseSeleniumPage {

    @FindBy(css = ".inventory_item_name")
    private WebElement productNames;

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    private WebElement addToCartSauceLabsBackpack;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(css = ".shopping_cart_link")
    private WebElement shoppingCartLink;
    @FindBy(css = "#react-burger-menu-btn")
    private WebElement sidebarBtn;
    @FindBy(css = "#logout_sidebar_link")
    private WebElement logoutBtn;


    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Проверить что страница: {0} открылась")
    public ProductsPage checkPageOpen(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl, expectedUrl);
        return this;
    }

    @Step("Добавляем товар корзину и переходим в корзину")
    public CartPage addToCart() {
        addToCartSauceLabsBackpack.click();
        shoppingCartLink.click();
        return new CartPage();
    }

    public ProductsPage checkSizePageElements(int actual) {
        List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item_name"));
        Assertions.assertEquals(list.size(), actual);
        return this;
    }

    public ProductsPage checkSizeCartElements(int actual) {
        String size = String.valueOf(shoppingCartBadge.getText());
        Assertions.assertEquals(size, actual);
        return this;
    }

    @Step("Выполнить logout")
    public LoginPage logout() {
        sidebarBtn.click();
        logoutBtn.click();
        return new LoginPage();
    }
}


