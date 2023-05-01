package swagLabsShop;

import core.BaseSeleniumPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseSeleniumPage {

    @FindBy(css = "#checkout")
    private WebElement checkoutBtn;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Преходим на страницу заполнения информации о себе")
    public YourInformation checkoutBtnClick() {
        checkoutBtn.click();
        return new YourInformation();
    }
}
