package site.steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.pages.MainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Steps for Main Page
 */
@Component
public class MainPageSteps {

    private static final Logger LOGGER = Logger.getLogger(MainPageSteps.class.getName());

    @Autowired
    private MainPage mainPage;

    public void open() {
        LOGGER.info("Step start: Open main page");
        mainPage.open();
    }

    public void pageShouldBeOpened() {
        LOGGER.info("Step start: Main Page Should Be Opened");
        assertTrue("Main Page should be opened",
                mainPage.isPageOpened());
    }
}
