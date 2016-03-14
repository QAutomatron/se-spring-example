package site.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;
import site.data.CalculatorFormSliderData;
import site.pages.Page;

/**
 * Calculator Form Element
 */
@Component
public class CalculatorFormElement extends Page{

    private final String calculatorFormLocator = "//*[@id='calculator-form']";
    private final String totalSliderLocator = calculatorFormLocator + "//*[@name='%s']";
    private final String sliderHandleLocator = totalSliderLocator + "//*[contains(@class,'ui-slider-handle')]";
    private final String inputFieldLocator = calculatorFormLocator + "//input[@name='%s']";
    private final String submitButtonLocator = calculatorFormLocator + "//button[@type='submit']";

    /**
     * Check if Calculator Form present
     * @return boolean
     */
    public boolean isFormPresent() {
        return waitForElementPresent(By.xpath(calculatorFormLocator));
    }

    /**
     * Move slider left or right
     * @param sliderData slider
     * @param i amount
     */
    public void moveSlider(CalculatorFormSliderData sliderData, int i) {
        String locator = String.format(sliderHandleLocator, sliderData.getSelector());
        (new Actions(getWebDriver())).dragAndDropBy($(By.xpath(locator)), i, 0).perform();
    }

    /**
     * Click Submit button
     */
    public void clickSubmitButton() {
        $(By.xpath(submitButtonLocator)).click();
    }

    /**
     * Get field value
     * @param fieldData field
     * @return value
     */
    public String getFieldValue(CalculatorFormSliderData fieldData) {
        String locator = String.format(inputFieldLocator, fieldData.name().toLowerCase());
        return $(By.xpath(locator)).getAttribute("value");
    }

    /**
     * Set slider to value
     * @param calculatorFormSliderData slider
     * @param expectedSliderValue target value
     */
    public void setSlider(CalculatorFormSliderData calculatorFormSliderData, int expectedSliderValue) {
        int sliderSteps = (calculatorFormSliderData.getMaxValue() - calculatorFormSliderData.getMinValue()) / calculatorFormSliderData.getStep();

        String totalSlider = String.format(totalSliderLocator, calculatorFormSliderData.getSelector());
        int totalSliderWidth = $(By.xpath(totalSlider)).getSize().getWidth();

        double pixelValue = totalSliderWidth / sliderSteps;
        String fieldLocator = String.format(inputFieldLocator, calculatorFormSliderData.name().toLowerCase());
        int currentSliderValue = Integer.parseInt($(By.xpath(fieldLocator)).getAttribute("value"));

        double offsetValue = (expectedSliderValue - currentSliderValue) * ( pixelValue / calculatorFormSliderData.getStep());

        String locator = String.format(sliderHandleLocator, calculatorFormSliderData.getSelector());
        (new Actions(getWebDriver())).dragAndDropBy($(By.xpath(locator)), (int) offsetValue, 0).perform();
    }
}

