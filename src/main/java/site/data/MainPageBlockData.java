package site.data;

/**
 * Main Page blocks with ID
 */
public enum MainPageBlockData {
    Logo("logo"),
    Language("menu-languages"),
    LoginField("user_login"),
    PasswordField("user_pass"),
    LogInButton("wp-submit"),
    MainMenu("menu-main-menu"),
    SidebarHome("sidebarhome"),
    SidebarHomeNew("sidebarhome-or-new"),
    Footer("inner-footer"),
    Header("inner-header");

    private String id;

    MainPageBlockData(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
