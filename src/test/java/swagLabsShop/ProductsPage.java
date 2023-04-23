package swagLabsShop;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BaseSeleniumPage {

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }
}
