package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage{
    public OrderPage (WebDriver driver)
    {
        super(driver);
    }
    private final By nameInput = By.xpath (".//input[@placeholder='* Имя']"); //Имя
    private final By familyInput = By.xpath (".//input[@placeholder='* Фамилия']"); //Фамилия
    private final By adressInput = By.xpath (".//input[@placeholder='* Адрес: куда привезти заказ']"); //Адрес
    private final By metroStationList = By.xpath (".//input[@class='select-search__input']"); //Список станций метро
    private final By metroStation = By.xpath (".//*[@class='select-search__select']/ul[@class='select-search__options']/li[1]"); //Метро
    private final By phoneInput = By.xpath (".//input[@placeholder='* Телефон: на него позвонит курьер']"); //Телефон
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //Кнопка "Далее"
    private final By dateOrderDelivery = By.xpath (".//input[@placeholder='* Когда привезти самокат']");//Дата
    private final By rentPeriodList = By.className ("Dropdown-placeholder");//Срок
    private final By rentPeriod = By.xpath(".//*[contains(text(),'двое суток')]");

    private final By scooterColor = By.xpath (".//input[@class='Checkbox_Input__14A2w' and @id='black']");//Цвет
    private final By commentForCourier = By.xpath (".//input[@placeholder='Комментарий для курьера']");//Комментарий
    private final By makeOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPage enterOrderData (String name, String surname, String adress, String phone)
    {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(familyInput).sendKeys(surname);
        driver.findElement(adressInput).sendKeys(adress);
        driver.findElement(phoneInput).sendKeys(phone);
        return this;
    }
    public OrderPage chooseMetroStation(/*String metroStation*/){
        driver.findElement(metroStationList).click();
        driver.findElement(metroStation).click();
        //driver.findElement(metroStationList).sendKeys(metroStation + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
    public OrderPage clickNextButton(){
        driver.findElement(nextButton).click();
        return this;
    }
    public OrderPage chooseDateDelivery(String dateDelivery){
        //driver.findElement(dateOrderDelivery).click();
        driver.findElement(dateOrderDelivery).sendKeys(dateDelivery + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }
   public OrderPage chooseRentPeriod(){
        driver.findElement(rentPeriodList).click();
        driver.findElement(rentPeriod).click();
        return this;
   }
   public OrderPage chooseScooterColor(){
        driver.findElement(scooterColor).click();
        return this;
   }
public ConfirmOrderPage makeOrder(){
        driver.findElement(makeOrderButton).click();
        return new ConfirmOrderPage(driver);
}
}
