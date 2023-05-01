package swagLabsShop;

import core.BaseSeleniumPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends BaseSeleniumPage {

    @FindBy(css = ".summary_subtotal_label")
    private WebElement itemAmount;
    @FindBy(css = "#finish")
    private WebElement finishBtn;

    public OverviewPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Проверяем что указанная сумма совпадает с ценой товара")
    public OverviewPage checkAmount(String expectedResult) {
        itemAmount.getText().contains(expectedResult);
        finishBtn.click();
        return this;
    }
}
