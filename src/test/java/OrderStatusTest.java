import PageObject.MainPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderStatusTest extends BaseUITest {

    @Test
    public void checkOrderStatusWhenOrderNotExist() {
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
