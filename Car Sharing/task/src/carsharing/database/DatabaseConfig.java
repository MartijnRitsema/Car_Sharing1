package carsharing.database;

public class DatabaseConfig {
    public static final String DEFAULT_DB_NAME = "carsharing";
    private String databaseName;
    private String databaseUrl;

    // Constructor to set the database name and URL
    public DatabaseConfig(String databaseName) {
        this.databaseName = databaseName;
        this.databaseUrl = "jdbc:h2:./src/carsharing/db/" + databaseName;
    }

    // Getter for the database URL
    public String getDatabaseUrl() {
        return databaseUrl;
    }
}
