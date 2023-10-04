package listeners;

import driver.BaseSeleniumTest;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.lang.reflect.Method;

public class AllureListeners extends BaseSeleniumTest implements AfterTestExecutionCallback {

    /**
     * Добавляем скриншот в аллюр отчет через аннотацию
     * @return
     */
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot() {
       return  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Описание:
     * <p>1.получаем тестовый метод</p>
     * <p>2.получаем название тестового метода</p>
     * <p>3.проверяем упал ли тест</p>
     * <p>4.если тест упал и если название метода не содержит Screenshot добавляем скриншот к упавшему тесту</p>
     * @param context
     */
    @Override
    public void afterTestExecution(ExtensionContext context) {
        Method testMethod = context.getRequiredTestMethod();
        String testName = testMethod.getName();
        boolean testFailed = context.getExecutionException().isPresent();
        if (testFailed) {//если тест упал
            if (!testName.contains("Screenshot")) {
                saveScreenshot();
            }
        }
    }
}
