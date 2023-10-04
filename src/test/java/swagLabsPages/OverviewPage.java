package swagLabsPages;

import driver.BaseSeleniumPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends BaseSeleniumPage {

    @FindBy(css = ".summary_subtotal_label")
    private WebElement itemAmount;
    @FindBy(css = "#finish")
    private WebElement finishBtn;
    @FindBy(css = "#react-burger-menu-btn")
    private WebElement sidebarBtn;
    @FindBy(css = "#logout_sidebar_link")
    private WebElement logoutBtn;

    public OverviewPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Проверяем что указанная сумма совпадает с ценой товара")
    public OverviewPage checkAmount(String expectedResult) {
        itemAmount.getText().contains(expectedResult);
        finishBtn.click();
        return this;
    }

    @Step("Выполнить logout")
    public LoginPage logout() {
        sidebarBtn.click();
        logoutBtn.click();
        return new LoginPage();
    }
}
