package carsharing.car;

import java.util.List;

public interface CarDAO {
    // Method to get a list of all cars for a specific company from the database
    List<Car> getCarsByCompanyId(int companyId);

    // Method to save a car to the database
    void saveCar(Car car);
}
