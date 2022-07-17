package PageObject;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebElement;

public class MainPage extends BasePage{

    // Заголовок страницы
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    // Кнопка "Статус заказа"
    private final By orderStatusButton = By.className("Header_Link__1TAG7");
    // Кнопка "Заказать" (верх)
    public static final By orderMakeUpButton = By.className("Button_Button__ra12g");
    // Кнопка "Заказать" (низ)
    public static final By orderMakeDownButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Поле ввода номера заказа
    private final By orderNumInput = By.xpath (".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");

    //Кнопка согласия использования куки
    private final By cookieInfoButton = By.className("App_CookieButton__3cvqF");
    public MainPage clickCookieInfoButton(){
        driver.findElement(cookieInfoButton).click();
        driver.manage().timeouts().implicitlyWait (5, TimeUnit.SECONDS);
        return this;
    }
    // Кнопка старта поиска
    private final By orderStartFindButton = By.xpath (".//button[@class='Button_Button__ra12g Header_Button__28dPO']");
    public MainPage (WebDriver driver)
    {
        super(driver);
    }
    public MainPage clickOrderStatusButton()
    {
        driver.findElement(orderStatusButton).click();
        return this;
    }
    public MainPage enterOrderNum (String orderNum)
    {
        driver.findElement(orderNumInput).sendKeys(orderNum);
        return this;
    }
   public OrderStatusPage clickOrderStartFindButton() {
       driver.findElement(orderStartFindButton).click();
       return new OrderStatusPage(driver);
   }

    public OrderPage clickOrderMakeButton(String buttonPosition) {
        if (buttonPosition == "up") {
            driver.findElement(orderMakeUpButton).click();
        } else if (buttonPosition == "down"){
            driver.findElement(orderMakeDownButton).click();
        }
        return new OrderPage(driver);
    }
   public MainPage openPage(){
       driver.get(URL);
       driver.manage().deleteAllCookies();
       return this;
   }
}

