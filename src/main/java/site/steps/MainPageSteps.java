package site.steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.data.MainPageBlockData;
import site.pages.MainPage;

import static org.junit.Assert.assertTrue;

/**
 * Steps for Main Page
 */
@Component
public class MainPageSteps {

    private static final Logger LOGGER = Logger.getLogger(MainPageSteps.class.getName());

    @Autowired
    private MainPage mainPage;

    /**
     * Open Main Page
     */
    public void open() {
        LOGGER.info("Step start: Open main page");
        mainPage.open();
    }

    /**
     * Main Page Should Be Opened
     */
    public void pageShouldBeOpened() {
        LOGGER.info("Step start: Main Page Should Be Opened");
        assertTrue("Main Page should be opened",
                mainPage.isPageOpened());
    }

    /**
     * Check if block is present on the Main Page
     * @param mainPageBlockData block
     */
    public void blockShouldBePresent(MainPageBlockData mainPageBlockData) {
        LOGGER.info(String.format("Step start: Block <%s> should be present", mainPageBlockData.name()));
        assertTrue(String.format("Block <%s> should be present on the Main Page", mainPageBlockData.name()),
                mainPage.isBlockPresent(mainPageBlockData));

    }
}
