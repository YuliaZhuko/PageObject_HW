package components.popups;

import components.AbsBaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilPopup extends AbsBaseComponent implements IPopup{

    private String profileNameSelector = ".fJMWHf";

    private String myProfileSelector = "Мой профиль";

    public ProfilPopup(WebDriver driver) {
        super(driver);
            }

    @Override
    public void popupShouldBeVisible(By locator) {

    }

    @Override
    public void popupShouldNotBeVisible(By locator) {

    }
    public void clickButton() {

        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.cssSelector(profileNameSelector))));
      driver.findElement(By.cssSelector(profileNameSelector)).click();
    }

    public void clickProfil()  {

        driver.findElement(By.linkText(myProfileSelector)).click();

    }
}
