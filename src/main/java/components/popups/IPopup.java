package components.popups;

import org.openqa.selenium.By;

public interface IPopup {

    void popupShouldBeVisible(By locator);
    void popupShouldNotBeVisible(By locator);
}
