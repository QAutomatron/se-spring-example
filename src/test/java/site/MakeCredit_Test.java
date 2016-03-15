package site;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import site.data.*;
import site.steps.CalculatorFormSteps;
import site.steps.CalculatorPopupSteps;
import site.steps.MainPageSteps;
import site.steps.RegistrationPageSteps;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class MakeCredit_Test {

    @Autowired
    private MainPageSteps mainPageSteps;
    @Autowired
    private CalculatorFormSteps calculatorFormSteps;
    @Autowired
    private RegistrationPageSteps registrationPageSteps;
    @Autowired
    private CalculatorPopupSteps calculatorPopupSteps;

    @Test
    public void make_credit() {

        // 1. User opens smscredit.lv web page
        mainPageSteps.open();

        // 2. Test checks if all main blocks are present on page
        mainPageSteps.pageShouldBeOpened();
        mainPageSteps.blockShouldBePresent(MainPageBlockData.Header);
        mainPageSteps.blockShouldBePresent(MainPageBlockData.Logo);
        mainPageSteps.blockShouldBePresent(MainPageBlockData.Language);
        mainPageSteps.blockShouldBePresent(MainPageBlockData.LoginField);
        mainPageSteps.blockShouldBePresent(MainPageBlockData.PasswordField);
        mainPageSteps.blockShouldBePresent(MainPageBlockData.LogInButton);
        mainPageSteps.blockShouldBePresent(MainPageBlockData.MainMenu);
        mainPageSteps.blockShouldBePresent(MainPageBlockData.SidebarHome);
        mainPageSteps.blockShouldBePresent(MainPageBlockData.SidebarHomeNew);
        mainPageSteps.blockShouldBePresent(MainPageBlockData.Footer);

        calculatorFormSteps.formShouldBePresent();

        // 3. Using sliders in calculator selects non-default values
        calculatorFormSteps.setSlider(CalculatorFormSliderData.Amount, 295);
        calculatorFormSteps.fieldShouldBeSameAs(CalculatorFormSliderData.Amount, "295");

        calculatorFormSteps.setSlider(CalculatorFormSliderData.Term, 29);
        calculatorFormSteps.fieldShouldBeSameAs(CalculatorFormSliderData.Term, "29");

        // 4. User clicks button to take a loan
        calculatorFormSteps.clickSubmitButton();
        registrationPageSteps.pageShouldBeOpened();

        // 5. User try to submit empty registration form
        registrationPageSteps.clickSubmitButton();

        // 6. Test will check if all error messages appears
        registrationPageSteps.errorShouldBePresent(RegistrationErrorData.PersonalIdBlank);
        registrationPageSteps.errorShouldBePresent(RegistrationErrorData.MobilePhoneBlank);
        registrationPageSteps.errorShouldBePresent(RegistrationErrorData.EmailBlank);
        registrationPageSteps.errorShouldBePresent(RegistrationErrorData.PasswordTooShort);
        registrationPageSteps.errorShouldBePresent(RegistrationErrorData.PasswordRepeatTooShort);
        registrationPageSteps.errorShouldBePresent(RegistrationErrorData.AgreementAccepted);

        // 7. User fills all fields with incorrect data
        registrationPageSteps.setField(RegistrationFieldData.PersonalId0, "!!!");
        registrationPageSteps.setField(RegistrationFieldData.PersonalId1, "#$@");
        registrationPageSteps.setField(RegistrationFieldData.MobilePhone, "12345");
        registrationPageSteps.setField(RegistrationFieldData.Email, "test@test.com");
        registrationPageSteps.setField(RegistrationFieldData.Password, "123456");
        registrationPageSteps.setField(RegistrationFieldData.RepeatPassword, "321");

        // 8. Test will check if all error messages appears
        registrationPageSteps.clickSubmitButton();
        registrationPageSteps.errorShouldBePresent(RegistrationErrorData.PersonalIdInvalid);
        registrationPageSteps.errorShouldBePresent(RegistrationErrorData.MobilePhoneInvalid);
        registrationPageSteps.errorShouldBePresent(RegistrationErrorData.PasswordShouldContainLetters);
        registrationPageSteps.errorShouldBePresent(RegistrationErrorData.PasswordRepeatConfirmation);
        registrationPageSteps.errorShouldBePresent(RegistrationErrorData.AgreementAccepted);

        // 9. User change amount and term of loan from registration page
        registrationPageSteps.clickEditButton();
        calculatorPopupSteps.popupShouldBePresent();

        calculatorPopupSteps.fieldShouldBeSameAs(CalculatorFormSliderData.Amount, "295");
        calculatorPopupSteps.clickSliderButton(CalculatorFormSliderData.Amount, SliderDirectionData.Minus);
        calculatorPopupSteps.fieldShouldBeSameAs(CalculatorFormSliderData.Amount, "290");

        calculatorPopupSteps.fieldShouldBeSameAs(CalculatorFormSliderData.Term, "29");
        calculatorPopupSteps.clickSliderButton(CalculatorFormSliderData.Term, SliderDirectionData.Plus);
        calculatorPopupSteps.fieldShouldBeSameAs(CalculatorFormSliderData.Term, "30");
        calculatorPopupSteps.termsLinkShouldBePresent("290", "30");

        calculatorPopupSteps.clickSubmitButton();
        calculatorPopupSteps.popupShouldNotBePresent();

        // 10. After closing pop-up test will check if all data changed
        registrationPageSteps.creditInfoShouldBePresent(CalculatorFormSliderData.Amount, "290.00 EUR");
        registrationPageSteps.creditInfoShouldBePresent(CalculatorFormSliderData.Term, "30 dienām");

        // 11. Browser closed
    }
}