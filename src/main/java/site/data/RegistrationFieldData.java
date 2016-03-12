package site.data;

/**
 * Registration Form Fields
 */
public enum RegistrationFieldData {
    PersonalId0("step_data_personal_id_0"),
    PersonalId1("step_data_personal_id_1"),
    MobilePhone("step_data_mobile_phone"),
    Email("step_data_email"),
    Password("step_data_password"),
    RepeatPassword("step_data_password_repeat");

    private final String id;

    RegistrationFieldData(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
