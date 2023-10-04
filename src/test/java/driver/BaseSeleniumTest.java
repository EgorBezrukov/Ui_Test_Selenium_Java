package driver;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.AllureListeners;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@ExtendWith(AllureListeners.class)
abstract public class BaseSeleniumTest {
    protected static final String HELPDESK_URL = ConfigReader.testDataConfig.helpdeskUrl();
    protected static final String HELPDESK_LOGIN = ConfigReader.testDataConfig.helpdeskLogin();
    protected static String HELPDESK_PASSWORD = ConfigReader.testDataConfig.helpdeskPassword();
    protected static String SWAGLAB_PRODUCT_PAGE_URL = ConfigReader.testDataConfig.SwagLabProductPageUrl();
    protected static final String SWAGLAB_BASE_URL = ConfigReader.testDataConfig.SwagLabBaseUrl();
    protected static final String SWAGLAB_LOGIN = ConfigReader.testDataConfig.SwagLabLogin();
    protected static final String SWAGLAB_PASSWORD = ConfigReader.testDataConfig.SwagLabPassword();

    protected static WebDriver driver;
    protected static ChromeOptions options = new ChromeOptions();

    @BeforeAll
    public static void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kate\\IdeaProjects\\Ui_Test_Selenium_Java\\src\\test\\resources\\driver\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        options.addArguments(new String[]{"window-size=1920,1080"});
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().setup();
        BaseSeleniumPage.setDriver(driver);
    }

    private static ChromeOptions getChromeOptions() {
//        options.setCapability(BROWSER_NAME, "CHROME");
//        options.setCapability(PLATFORM_NAME, Platform.WIN10);
        options.addArguments("--start-maximized");
        options.setBrowserVersion("117");
        options.addArguments(new String[]{"window-size=1920,1080"});
        options.setPlatformName("Windows");
        return options;
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        //driver.quit();
    }
}
