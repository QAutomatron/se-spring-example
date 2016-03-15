package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import site.util.PropertyLoader;

public class SharedDriver extends EventFiringWebDriver {
    private static final WebDriver REAL_DRIVER = createDriver();

    private static WebDriver createDriver() {
        String driverName = PropertyLoader.loadProperty("browser.name");
        final WebDriver driver;
        switch (driverName.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
        }
        return driver;
    }

    public SharedDriver() {
        super(REAL_DRIVER);
    }
}