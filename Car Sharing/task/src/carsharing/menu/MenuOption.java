package carsharing.menu;

public enum MenuOption {
    // Enum values for main, manager, company, and car menus with their titles and options
    MAIN_MENU("Main Menu", new String[]{"1. Log in as a manager", "0. Exit"}),
    MANAGER_MENU("Manager Menu", new String[]{"1. Company list", "2. Create a company", "0. Back"}),
    COMPANY_MENU("Company Menu", new String[]{"'Company name' company", "1. Car list", "2. Create a car", "0. Back"}),;


    private final String title;
    private final String[] options;

    // Constructor to set the title and options for each menu
    MenuOption(String title, String[] options) {
        this.title = title;
        this.options = options;
    }

    // Getter for the menu title
    public String getTitle() {
        return title;
    }

    // Getter for the menu options
    public String[] getOptions() {
        return options;
    }

    // Method to print the menu title and options
    public void printOptions() {
        System.out.println(getTitle());
        for (String option : getOptions()) {
            System.out.println(option);
        }
    }
}
