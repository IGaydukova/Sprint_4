package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatusPage extends BasePage{
    //Заказ не найден
    private final By orderNotFoundImage = By.className("Track_NotFound__6oaoY");
    //Заказ найден

    // Поле ввода номера заказа
    //Кнопка "Посмотреть"
    public OrderStatusPage (WebDriver driver)
    {
        super (driver);
    }
    public boolean isOrderNotFound()
    {
        return driver.findElement(orderNotFoundImage).isDisplayed();
    }

}
