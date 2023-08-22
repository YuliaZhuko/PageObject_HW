package driver.impl;

import exceptions.DriverNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public interface IDriver {
    WebDriver newDriver() throws DriverNotSupportedException;

    default void downloadLoicalWebDriver(DriverManagerType driverType) throws DriverNotSupportedException {
        Config wdmConfig = WebDriverManager.globalConfig();
        wdmConfig.setAvoidBrowserDetection(true);

        String browserVersion = System.getProperty("browser.version", "");

        if (!browserVersion.isEmpty()) {
            switch (driverType) {
                case CHROME:
                    wdmConfig.setChromeDriverVersion(browserVersion);
                    break;
                default:
                    throw new DriverNotSupportedException(driverType.name());
            }
        }
        WebDriverManager.getInstance(driverType).setup();
    }
}
