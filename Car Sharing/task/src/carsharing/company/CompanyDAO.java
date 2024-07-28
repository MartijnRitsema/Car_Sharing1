package carsharing.company;

import java.util.List;

public interface CompanyDAO {
    // Method to get a list of all companies from the database
    List<Company> getAllCompanies();

    // Method to save a company to the database
    void saveCompany(Company company);
}
