package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import site.data.MainPageBlockData;

/**
 * Main Page
 */
@Component
public class MainPage extends Page{

    @FindBy(id = "main")
    private WebElement creditMainFormBlock;

    private final String blockLocator = "//*[@id='%s']";

    public void open(){
        openAt("/");
    }

    /**
     * Check if Main Page is opened
     * @return boolean
     */
    public boolean isPageOpened() {
        return waitForElementPresent(creditMainFormBlock);
    }

    /**
     * Check if block present on page
     * @param mainPageBlockData block
     * @return boolean
     */
    public boolean isBlockPresent(MainPageBlockData mainPageBlockData) {
        String locator = String.format(blockLocator, mainPageBlockData.getId());
        return waitForElementPresent(By.xpath(locator));
    }
}

