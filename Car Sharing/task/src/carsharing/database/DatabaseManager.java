package carsharing.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    // SQL statement to create the COMPANY table if it doesn't exist
    private static final String CREATE_COMPANY_TABLE_SQL = "CREATE TABLE IF NOT EXISTS COMPANY ("
            + "ID INT PRIMARY KEY AUTO_INCREMENT, "
            + "NAME VARCHAR(255) UNIQUE NOT NULL)";

    // SQL statement to create the CAR table if it doesn't exist
    private static final String CREATE_CAR_TABLE_SQL = "CREATE TABLE IF NOT EXISTS CAR ("
            + "ID INT PRIMARY KEY AUTO_INCREMENT, "
            + "NAME VARCHAR(255) UNIQUE NOT NULL, "
            + "COMPANY_ID INT NOT NULL, "
            + "FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY(ID))";

    private DatabaseConfig dbConfig;

    // Constructor to initialize DatabaseConfig and create the database schema
    public DatabaseManager(DatabaseConfig dbConfig) {
        this.dbConfig = dbConfig;
        initializeDatabase();
    }

    // Method to get a connection to the database
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbConfig.getDatabaseUrl());
    }

    // Method to initialize the database schema by creating necessary tables
    private void initializeDatabase() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(true); // Enable auto-commit mode
            statement.executeUpdate(CREATE_COMPANY_TABLE_SQL); // Execute the SQL statement
            statement.executeUpdate(CREATE_CAR_TABLE_SQL); // Execute the SQL statement for CAR table
        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception stack trace if an error occurs
        }
    }
}
