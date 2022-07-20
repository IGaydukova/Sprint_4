package PageObject;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected final WebDriver driver;
    protected static final String URL = "https://qa-scooter.praktikum-services.ru/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}



