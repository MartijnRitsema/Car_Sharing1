package carsharing.company;

import carsharing.database.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAOImpl implements CompanyDAO {
    // SQL statement to retrieve all companies from the database
    private static final String GET_ALL_COMPANIES_SQL = "SELECT * FROM COMPANY ORDER BY ID";
    // SQL statement to insert a new company into the database
    private static final String INSERT_COMPANY_SQL = "INSERT INTO COMPANY (NAME) VALUES (?)";

    private DatabaseManager dbManager;

    // Constructor to initialize DatabaseManager
    public CompanyDAOImpl(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    // Method to get a list of all companies from the database
    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();

        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_COMPANIES_SQL);
             ResultSet resultSet = statement.executeQuery()) {

            // Iterate through the result set and add each company to the list
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                companies.add(new Company(id, name));
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception stack trace if an error occurs
        }
        return companies;
    }

    // Method to save a company to the database
    @Override
    public void saveCompany(Company company) {
        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_COMPANY_SQL)) {

            statement.setString(1, company.getName()); // Set the company name parameter
            statement.executeUpdate(); // Execute the insert statement

        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception stack trace if an error occurs
        }
    }
}
