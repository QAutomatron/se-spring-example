package site.steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.data.CalculatorFormFieldData;
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
     * Move slider left or right
     * @param sliderData slider
     * @param i amount
     */
    public void moveSlider(CalculatorFormSliderData sliderData, int i) {
        calculatorFormElement.moveSlider(sliderData, i);
    }

    /**
     * Click Submit Button
     */
    public void clickSubmitButton() {
        calculatorFormElement.clickSubmitButton();
    }

    /**
     * Get Field value
     * @param fieldData field
     * @param s expected value
     */
    public void fieldShouldBeSameAs(CalculatorFormFieldData fieldData, String s) {
        assertEquals(String.format("Wrong <%s> Field value", fieldData.name()),
                s,
                calculatorFormElement.getFieldValue(fieldData));
    }
}
