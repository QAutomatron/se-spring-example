package site.applogic;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class InvisibilityOfElementLocated implements ExpectedCondition<Boolean> {

    private final By locator;

    public InvisibilityOfElementLocated(By locator) {
        this.locator = locator;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        try {
            List<WebElement> elements = driver.findElements(locator);
            if (elements.isEmpty()) {
                return true;
            }
            return !elements.get(0).isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException | ElementNotVisibleException | NullPointerException  e) {
            return true;
        } catch (Throwable t) {
            throw new Error(t);
        }
    }
}