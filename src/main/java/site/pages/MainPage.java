package site.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * Main Page
 */
@Component
public class MainPage extends Page{

    @FindBy(id = "main")
    private WebElement creditMainFormBlock;

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
}

