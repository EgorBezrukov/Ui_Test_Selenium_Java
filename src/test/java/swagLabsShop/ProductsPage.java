package swagLabsShop;

import core.BaseSeleniumPage;
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

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Добавляем товарв корзину и переходим в карзину")
    public CartPage addToCart() {
        addToCartSauceLabsBackpack.click();
        shoppingCartLink.click();
        return new CartPage();
    }

    public void checkSizePageElements(int actual) {
        List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item_name"));
        Assertions.assertEquals(list.size(), actual);
    }

    public void checkSizeCartElements(int actual) {
        String size = String.valueOf(shoppingCartBadge.getText());
        Assertions.assertEquals(size, actual);
    }
}


