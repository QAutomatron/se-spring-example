package site.steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
        LOGGER.info("Step start: Click Submit button");
        calculatorPopupElement.clickSubmitButton();
    }

    /**
     * Set input field value
     * @param calculatorFormFieldData field
     * @param s value
     */
    public void setField(CalculatorFormSliderData calculatorFormFieldData, String s) {
        LOGGER.info(String.format("Step start: Set field <%s> to value <%s>", calculatorFormFieldData.name(), s));
        calculatorPopupElement.setField(calculatorFormFieldData, s);
    }

    /**
     * Check field value
     * @param fieldData field
     * @param s value
     */
    public void fieldShouldBeSameAs(CalculatorFormSliderData fieldData, String s) {
        LOGGER.info(String.format("Step start: Field <%s> should be same as <%s>", fieldData.name(), s));
        assertEquals(String.format("Wrong <%s> Field value", fieldData.name()),
                s,
                calculatorPopupElement.getFieldValue(fieldData));
    }

    /**
     * Check slider actial value
     * @param formSliderData slider
     * @param s value
     */
    public void sliderHandleValueShouldBeSameAs(CalculatorFormSliderData formSliderData, String s) {
        LOGGER.info(String.format("Step start: Slider <%s>  handle value should be same as <%s>", formSliderData.name(), s));
        assertTrue(String.format("Slider <%s> should have value <%s>", formSliderData.name(), s),
                calculatorPopupElement.isSliderWithValuePresent(formSliderData, s));
    }

    /**
     * Click plus button for slider
     * @param formFieldData field slider
     * @param sliderDirectionData direction plus or minus
     */
    public void clickSliderButton(CalculatorFormSliderData formFieldData, SliderDirectionData sliderDirectionData) {
        LOGGER.info(String.format("Step start: Click slider <%s> button <%s>", formFieldData.name(), sliderDirectionData.name()));
        calculatorPopupElement.clickSliderButton(formFieldData, sliderDirectionData);
    }

    /**
     * Check if therms info link present for form
     * @param amount amount
     * @param term term
     */
    public void termsLinkShouldBePresent(String amount, String term) {
        LOGGER.info(String.format("Step start: Term link with: amount value <%s> and term value <%s> should be present", amount, term));
        assertTrue(String.format("Term link with: amount value <%s> and term value <%s> should be present", amount, term),
                calculatorPopupElement.isTermLinkPresent(amount, term));
    }
}
