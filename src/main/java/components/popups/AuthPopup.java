package components.popups;

import components.AbsBaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AuthPopup extends AbsBaseComponent implements IPopup {

    private String loginSelector = "email";
    private String passwordSelector = "[type='password']";
    private final Properties prop = new Properties();
    private FileInputStream fileInputStream;
    private static final String PATH_TO_CONFIG_PROPERTIES = "src/test/resources/config.properties";
    private String LOGIN, PASSWORD;

    public void readProperties() throws FileNotFoundException {
        try{
            fileInputStream = new FileInputStream(PATH_TO_CONFIG_PROPERTIES);
            prop.load(fileInputStream);

            LOGIN = prop.getProperty("USER_LOGIN");
            PASSWORD = prop.getProperty("USER_PASS");

        }
        catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_CONFIG_PROPERTIES + " не обнаружен");
            e.printStackTrace();
        }

    }
    //private String LOGIN = System.getProperty("site.login");
  //  private String LOGIN = "towoc78451@sparkroi.com";
   // private String PASSWORD = System.getProperty("site.password");
  // private String PASSWORD = "Megere11+";

    private String enterButtonSelector = "//button/*[contains(text(),'Войти')]";

     public AuthPopup(WebDriver driver) {
        super(driver);
    }

    @Override
    public void popupShouldBeVisible(By locator) {

    }

    @Override
    public void popupShouldNotBeVisible(By locator) {

    }
    public void clickButton(By text){
        driver.findElement(text).click();
    }
    public WebElement findButton(By text){
        return  driver.findElement(text);
    }

    public void auth(MainPage mainPage) throws FileNotFoundException {
        webDriverWait.until(ExpectedConditions.visibilityOf(mainPage.findButton(By.cssSelector(mainPage.EnterButtonSelector))));
        mainPage.clickButton(By.cssSelector(mainPage.EnterButtonSelector));
        readProperties();
        driver.findElement(By.name(loginSelector)).sendKeys(LOGIN);
        driver.findElement(By.cssSelector(passwordSelector)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(enterButtonSelector)).click();
    }
}
