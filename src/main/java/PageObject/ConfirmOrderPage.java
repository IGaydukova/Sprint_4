package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmOrderPage extends BasePage{
    public ConfirmOrderPage (WebDriver driver)
    {
        super (driver);
    }
    private final By confirmOrderButton = By.xpath(".//*[@class='Order_Modal__YZ-d3']/*[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private final By confirmOrderInfo = By.xpath(".//*[contains(text(),'Заказ оформлен')]"); // Подтверждение оформления заказа

    public ConfirmOrderPage clickConfirmButton(){
        driver.findElement(confirmOrderButton).click();
        return this;
    }
    public boolean isOrderConfirm()
    {
        return driver.findElement(confirmOrderInfo).isDisplayed();
    }
}
