package carsharing;

import carsharing.car.Car;
import carsharing.car.CarDAO;
import carsharing.database.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOImpl implements CarDAO {
    private static final String GET_CARS_BY_COMPANY_ID_SQL = "SELECT * FROM CAR WHERE COMPANY_ID = ? ORDER BY ID";
    private static final String INSERT_CAR_SQL = "INSERT INTO CAR (NAME, COMPANY_ID) VALUES (?, ?)";

    private DatabaseManager dbManager;

    public CarDAOImpl(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public List<Car> getCarsByCompanyId(int companyId) {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CARS_BY_COMPANY_ID_SQL)) {
            statement.setInt(1, companyId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String name = resultSet.getString("NAME");
                    cars.add(new Car(id, name, companyId));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public void saveCar(Car car) {
        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CAR_SQL)) {
            statement.setString(1, car.getName());
            statement.setInt(2, car.getCompanyId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
