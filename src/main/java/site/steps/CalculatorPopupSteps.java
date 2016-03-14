package site.steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.data.CalculatorFormFieldData;
import site.data.CalculatorFormSliderData;
import site.data.SliderDirectionData;
import site.elements.CalculatorPopupElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Steps for Calculator Popup on Registration Page
 */
@Component
public class CalculatorPopupSteps {

    private static final Logger LOGGER = Logger.getLogger(CalculatorPopupSteps.class.getName());

    @Autowired
    private CalculatorPopupElement calculatorPopupElement;

    /**
     * Check is form is present
     */
    public void popupShouldBePresent() {
        LOGGER.info("Step start: Calculator Popup should be present");
        assertTrue("Calculator Popup should be present",
                calculatorPopupElement.isPopupPresent());
    }

    /**
     * Check is form not present
     */
    public void popupShouldNotBePresent() {
        LOGGER.info("Step start: Calculator Popup should not be present");
        assertTrue("Calculator Popup should not be present",
                calculatorPopupElement.isPopupNotPresent());
    }

    /**
     * Click Submit Button
     */
    public void clickSubmitButton() {
        calculatorPopupElement.clickSubmitButton();
    }

    /**
     * Set input field value
     * @param calculatorFormFieldData field
     * @param s value
     */
    public void setField(CalculatorFormFieldData calculatorFormFieldData, String s) {
        calculatorPopupElement.setField(calculatorFormFieldData, s);
    }

    /**
     * Check field value
     * @param fieldData field
     * @param s value
     */
    public void fieldShouldBeSameAs(CalculatorFormFieldData fieldData, String s) {
        assertEquals(String.format("Wrong <%s> Field value", fieldData.name()),
                s,
                calculatorPopupElement.getFieldValue(fieldData));
    }

    /**
     * Check slider actial value
     * @param formSliderData slider
     * @param s value
     */
    public void sliderValueShouldBeSameAs(CalculatorFormSliderData formSliderData, String s) {
        assertTrue(String.format("Slider <%s> should have value <%s>", formSliderData.name(), s),
                calculatorPopupElement.isSliderWithValuePresent(formSliderData, s));
    }

    /**
     * Click plus button for slider
     * @param formFieldData field slider
     * @param sliderDirectionData direction plus or minus
     */
    public void clickSliderButton(CalculatorFormFieldData formFieldData, SliderDirectionData sliderDirectionData) {
        calculatorPopupElement.clickSliderButton(formFieldData, sliderDirectionData);
    }
}
