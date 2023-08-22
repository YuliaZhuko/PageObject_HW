package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends AbsBasePage{


    public String EnterButtonSelector = ".enxKCy";

    public MainPage(WebDriver driver) {
        super(driver);
    }
    public WebElement findButton(By text){
        return  driver.findElement(text);
            }
    public void clickButton(By text){
        driver.findElement(text).click();
    }
}
