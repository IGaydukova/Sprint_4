import PageObject.ConfirmOrderPage;
import PageObject.MainPage;
import PageObject.OrderPage;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class OrderTest extends BaseUITest {

    private String name;
    private String surname;
    private String adress;
    private String phone;

    public OrderTest(String name, String surname, String adress, String phone) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phone = phone;
    }
    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getData() {
        return new Object[][]{
                {"Ирина", "Гайдукова", "Лермонтова 12", "89170981111"},
                {"Иван", "Иванов", "Ломоносова 35", "89999999999"}
        };
    }

    @Test
    public void checkOrderMake(){
         boolean isOrderConfirm = new MainPage(driver)
                .openPage()
                .clickCookieInfoButton()
                .clickOrderMakeButton("up")
                .enterOrderData(name, surname, adress, phone)
                .chooseMetroStation()
                .clickNextButton()
                .chooseDateDelivery("18.07.2022")
                .chooseRentPeriod()
                .chooseScooterColor()
                .makeOrder()
                .clickConfirmButton()
                .isOrderConfirm();
        assertTrue("Order not Make! Confirm Message don't display", isOrderConfirm);
    }
    @Test
    public void checkOrderMakeDownButton(){
        boolean isOrderConfirm = new MainPage(driver)
                .openPage()
                .clickCookieInfoButton()
                .clickOrderMakeButton("down")
                .enterOrderData(name, surname, adress, phone)
                .chooseMetroStation()
                .clickNextButton()
                .chooseDateDelivery("20.07.2022")
                .chooseRentPeriod()
                .chooseScooterColor()
                .makeOrder()
                .clickConfirmButton()
                .isOrderConfirm();
        assertTrue("Order not Make! Confirm Message don't display", isOrderConfirm);
    }
}
