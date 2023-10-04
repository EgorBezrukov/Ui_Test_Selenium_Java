package tests;

import driver.BaseSeleniumTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SwagLabShopTest extends BaseSeleniumTest {

    @Disabled
    @DisplayName("Пользовательский сценарий, выполнение покупки")
    public void swagLabsShop() {
        String shopAmount;
        String quantity;
        int res;
        driver.get(SWAGLAB_BASE_URL);
        driver.findElement(By.cssSelector("#user-name")).sendKeys(SWAGLAB_LOGIN);
        driver.findElement(By.cssSelector("#password")).sendKeys(SWAGLAB_PASSWORD, Keys.ENTER);
        driver.findElement(By.cssSelector(".inventory_item_name")).click();
        shopAmount = driver.findElement(By.cssSelector(".inventory_details_price")).getText();
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        quantity = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        res = Integer.parseInt(quantity);
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.name("checkout")).click();
        driver.findElement(By.name("firstName")).sendKeys("Lol");
        driver.findElement(By.name("lastName")).sendKeys("Balabol");
        driver.findElement(By.name("postalCode")).sendKeys("1231");
        driver.findElement(By.name("continue")).click();
        driver.findElement(By.cssSelector(".summary_subtotal_label"))
                .getText().contains(shopAmount);
        Assertions.assertEquals(res, 1);
    }
}
