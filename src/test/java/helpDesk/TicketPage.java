package helpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketPage extends BaseSeleniumPage {

    @FindBy(id="search_query")
    private WebElement searchField;

    public TicketPage(){
        PageFactory.initElements(driver, this);
    }
}
