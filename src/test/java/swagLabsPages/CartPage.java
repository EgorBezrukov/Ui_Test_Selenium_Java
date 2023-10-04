package swagLabsPages;

import driver.BaseSeleniumPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseSeleniumPage {
    @FindBy(css = "#checkout")
    private WebElement checkoutBtn;

    @FindBy(css = "#react-burger-menu-btn")
    private WebElement sidebarBtn;
    @FindBy(css = "#logout_sidebar_link")
    private WebElement logoutBtn;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Преходим на страницу заполнения информации о себе")
    public YourInformation checkoutBtnClick() {
        checkoutBtn.click();
        return new YourInformation();
    }

    @Step("Выполнить logout")
    public LoginPage logout() {
        sidebarBtn.click();
        logoutBtn.click();
        return new LoginPage();
    }
}
