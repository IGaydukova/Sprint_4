package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.Thread;

//Относится к главной странице, но там вроде и так перегружено уже (потом объединить, при необходимости)
public class QuestionPage extends BasePage{
    public QuestionPage (WebDriver driver, String id, String question)
    {
        super(driver);
        questionButton = By.id("accordion__heading-"+id);
        answer = By.xpath(".//*[contains(text(),'"+question+"')]");
        //System.out.println(questionButton);
    }
   private final By questionButton;
   private final By answer;
    public void scrollToQuestion()  {
        WebElement element = driver.findElement(By.className("Home_SubHeader__zwi_E"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
    }
    public void clickButton() {
        driver.findElement(questionButton).click();  }
    public boolean isAnswerCorrect(){
        try {
            return driver.findElement(answer).isDisplayed();
        } catch(org.openqa.selenium.NoSuchElementException e) {
            return false;
        }

    }

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    public QuestionPage openPage(){
        driver.get(URL);
        driver.manage().deleteAllCookies();
        return this;
    }
    private final By cookieInfoButton = By.className("App_CookieButton__3cvqF");
    public QuestionPage clickCookieInfoButton(){
        driver.findElement(cookieInfoButton).click();
        return this;
    }
}
