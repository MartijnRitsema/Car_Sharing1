package carsharing.menu;

import carsharing.car.Car;
import carsharing.car.CarDAO;
import carsharing.company.Company;
import carsharing.company.CompanyDAO;

import java.util.List;
import java.util.Scanner;

public class MenuHandler {
    private CompanyDAO companyDAO;
    private CarDAO carDAO;
    private Scanner scanner;

    // Constructor to initialize DAOs and scanner
    public MenuHandler(CompanyDAO companyDAO, CarDAO carDAO) {
        this.companyDAO = companyDAO;
        this.carDAO = carDAO;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the main menu and handle user input
    public void displayMainMenu() {
        while (true) {
            MenuOption.MAIN_MENU.printOptions(); // Print main menu options
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayManagerMenu(); // Display manager menu if user chooses to log in as manager
                    break;
                case 0:
                    return; // Exit the program if user chooses to exit
            }
        }
    }

    // Method to display the manager menu and handle user input
    private void displayManagerMenu() {
        while (true) {
            MenuOption.MANAGER_MENU.printOptions(); // Print manager menu options
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    handleCompanyList(); // Handle company list if user chooses company list option
                    break;
                case 2:
                    handleCreateCompany(); // Handle creating a company if user chooses create company option
                    break;
                case 0:
                    return; // Go back to the main menu if user chooses to go back
            }
        }
    }

    // Method to handle displaying the company list and handling company-related options
    private void handleCompanyList() {
        List<Company> companies = companyDAO.getAllCompanies(); // Get all companies from the database
        if (companies.isEmpty()) {
            System.out.println("The company list is empty!");
        } else {
            System.out.println("Choose a company:");
            for (int i = 0; i < companies.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, companies.get(i).getName());
            }
            System.out.println("0. Back");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice > 0 && choice <= companies.size()) {
                handleCompanyMenu(companies.get(choice - 1)); // Handle company menu for the chosen company
            }
        }
    }

    // Method to handle creating a company
    private void handleCreateCompany() {
        System.out.println("Enter the company name:");
        String name = scanner.nextLine();
        companyDAO.saveCompany(new Company(name)); // Save the new company to the database
        System.out.println("The company was created!");
    }

    // Method to handle displaying the company menu and handling car-related options
    private void handleCompanyMenu(Company company) {
        while (true) {
            System.out.printf("'%s' company%n", company.getName());
            MenuOption.COMPANY_MENU.printOptions(); // Print company menu options
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    handleCarList(company); // Handle car list if user chooses car list option
                    break;
                case 2:
                    handleCreateCar(company); // Handle creating a car if user chooses create car option
                    break;
                case 0:
                    return; // Go back to the manager menu if user chooses to go back
            }
        }
    }

    // Method to handle displaying the car list for a specific company
    private void handleCarList(Company company) {
        List<Car> cars = carDAO.getCarsByCompanyId(company.getId()); // Get all cars for the specified company
        if (cars.isEmpty()) {
            System.out.println("The car list is empty!");
        } else {
            System.out.printf("'%s' cars:%n", company.getName());
            for (int i = 0; i < cars.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, cars.get(i).getName());
            }
        }
    }

    // Method to handle creating a car for a specific company
    private void handleCreateCar(Company company) {
        System.out.println("Enter the car name:");
        String name = scanner.nextLine();
        carDAO.saveCar(new Car(name, company.getId())); // Save the new car to the database with the specified company ID
        System.out.println("The car was added!");
    }
}
