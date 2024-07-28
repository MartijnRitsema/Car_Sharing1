package carsharing;

import carsharing.car.CarDAO;
import carsharing.company.CompanyDAO;
import carsharing.company.CompanyDAOImpl;
import carsharing.database.DatabaseConfig;
import carsharing.database.DatabaseManager;
import carsharing.menu.MenuHandler;

public class Main {
    public static void main(String[] args) {
        // Get the database name from the command line arguments or use the default
        String dbName = getDatabaseName(args);

        // Initialize the database configuration, manager, and DAO
        DatabaseConfig dbConfig = new DatabaseConfig(dbName);
        DatabaseManager dbManager = new DatabaseManager(dbConfig);
        CompanyDAO companyDAO = new CompanyDAOImpl(dbManager);
        CarDAO carDAO = new CarDAOImpl(dbManager);

        // Initialize and display the main menu
        MenuHandler menuHandler = new MenuHandler(companyDAO, carDAO);
        menuHandler.displayMainMenu();
    }

    // Helper method to get the database name from command line arguments
    private static String getDatabaseName(String[] args) {
        if (args.length > 1 && args[0].equals("-databaseFileName")) {
            return args[1];
        }
        return DatabaseConfig.DEFAULT_DB_NAME;
    }
}

