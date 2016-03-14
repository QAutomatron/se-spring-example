package site.steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.data.CalculatorFormSliderData;
import site.elements.CalculatorFormElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Steps for Calculator Form on Main Page
 */
@Component
public class CalculatorFormSteps {

    private static final Logger LOGGER = Logger.getLogger(CalculatorFormSteps.class.getName());

    @Autowired
    private CalculatorFormElement calculatorFormElement;

    /**
     * Check is form is present
     */
    public void formShouldBePresent() {
        LOGGER.info("Step start: Calculator Form should be present");
        assertTrue("Calculator form should be present",
                calculatorFormElement.isFormPresent());
    }

    /**
     * Click Submit Button
     */
    public void clickSubmitButton() {
        LOGGER.info("Step start: Click Submit Button");
        calculatorFormElement.clickSubmitButton();
    }

    /**
     * Get Field value
     * @param fieldData field
     * @param s expected value
     */
    public void fieldShouldBeSameAs(CalculatorFormSliderData fieldData, String s) {
        LOGGER.info(String.format("Step start: field <%s> should be same as <%s>", fieldData.name(), s));
        assertEquals(String.format("Wrong <%s> Field value", fieldData.name()),
                s,
                calculatorFormElement.getFieldValue(fieldData));
    }

    /**
     * Set slider value by drag and drop slider
     * @param calculatorFormSliderData slider
     * @param i value
     */
    public void setSlider(CalculatorFormSliderData calculatorFormSliderData, int i) {
        LOGGER.info(String.format("Step start: Set <%s> slider to value <%d>", calculatorFormSliderData.name(), i));
        calculatorFormElement.setSlider(calculatorFormSliderData, i);
    }
}
