package helpDesk;

import core.BaseSeleniumTest;
import org.junit.Test;
import readProperties.ConfigProvider;
import static helpers.StringModifier.getUniqueString;
public class HelpDeskTest extends BaseSeleniumTest {



    @Test
    public void checkTicket(){
        System.out.println();
        String title = getUniqueString("Karabas Barabas");
        String body  = "Сообщение в тех поддержку от Карабаса Барабаса";
        String email = "KarabasBarabas@karamba.com";
        MainPage mainPage = new MainPage();
        mainPage.createTicket(title,body,email)
                .openLoginPage()
                .auth(ConfigProvider.DEMO_LOGIN, ConfigProvider.DEMO_PASSWORD);
    }

}
