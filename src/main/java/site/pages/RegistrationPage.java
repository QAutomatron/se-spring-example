package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import site.data.CalculatorFormSliderData;
import site.data.RegistrationErrorData;
import site.data.RegistrationFieldData;

/**
 * Registration Page
 */
@Component
public class RegistrationPage extends Page{

    @FindBy(css = ".registration.register")
    private WebElement registrationBlock;

    private final String workflowFormLocator = "//*[@id='workflow_form']";
    private final String fieldLocator = workflowFormLocator + "//input[@id='%s']";
    private final String errorTextLocator = workflowFormLocator + "//*[@class='help-block'][@id='%s']";
    private final String submitButtonLocator = workflowFormLocator + "//button[@type='submit']";

    private final String creditInfoFieldLocator = "//*[contains(@class,'amount-info')]//*[@id][@class='value %s']";
    private final String editButtonLocator = "//button[@data-target='#modal-calculator']";

    /**
     * Check if Registration Page is opened
     * @return boolean
     */
    public boolean isPageOpened() {
        return waitForElementPresent(registrationBlock);
    }

    /**
     * Click Submit button
     */
    public void clickSubmitButton() {
        $(By.xpath(submitButtonLocator)).click();
    }

    /**
     * Check is error present
     * @param errorData error
     * @return boolean
     */
    public boolean isErrorPresent(RegistrationErrorData errorData) {
        String locator = String.format(errorTextLocator, errorData.getId());
        return waitForElementPresent(By.xpath(locator));
    }

    /**
     * Set field value
     * @param fieldData field
     * @param s value
     */
    public void setField(RegistrationFieldData fieldData, String s) {
        String locator = String.format(fieldLocator, fieldData.getId());
        typeInto($(By.xpath(locator)), s);
    }

    /**
     * Click Edit button
     */
    public void clickEditButton() {
        getWebDriver().findElement(By.xpath(editButtonLocator)).click();
    }

    /**
     * Get Credit Info field value
     * @param fieldData field
     * @return value
     */
    public String getCreditInfoValue(CalculatorFormSliderData fieldData) {
        String locator = String.format(creditInfoFieldLocator, fieldData.name().toLowerCase());
        return $(By.xpath(locator)).getText().split(" ")[0];
    }
}

