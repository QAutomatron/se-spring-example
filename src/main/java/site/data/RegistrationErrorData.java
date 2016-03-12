package site.data;

public enum RegistrationErrorData {

    PersonalIdBlank("error_personal_id_blank"),
    MobilePhoneBlank("error_mobile_phone_blank"),
    EmailBlank("error_email_blank"),
    PasswordTooShort("error_password_too_short"),
    PasswordRepeatTooShort("error_password_repeat_too_short"),
    AgreementAccepted("error_accept_agreement_accepted"),
    PersonalIdInvalid("error_personal_id_invalid"),
    MobilePhoneInvalid("error_mobile_phone_invalid"),
    PasswordShouldContainLetters("error_password_should_contain_letters"),
    PasswordRepeatConfirmation("error_password_repeat_confirmation");

    private final String id;

    RegistrationErrorData(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
