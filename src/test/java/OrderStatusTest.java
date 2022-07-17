import PageObject.MainPage;
import PageObject.OrderStatusPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static PageObject.MainPage.URL;
import static org.junit.Assert.*;

public class OrderStatusTest extends BaseUITest {


    @Test
    public void checkOrderStatusWhenOrderNotExist(){
        boolean isOrderStatusNotFound = new MainPage(driver)
                .openPage()
                .clickCookieInfoButton()
                .clickOrderStatusButton()
                .enterOrderNum("111")
                .clickOrderStartFindButton()
                .isOrderNotFound();
        //Проверяем результат
        assertTrue("Image 'Order not found' don't displayed", isOrderStatusNotFound);
    }

}
