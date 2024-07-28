package carsharing.car;

public class Car {
    private int id;
    private String name;
    private int companyId;

    // Constructor to create a Car object with a name and company ID
    public Car(String name, int companyId) {
        this.name = name;
        this.companyId = companyId;
    }

    // Constructor to create a Car object with an ID, name, and company ID
    public Car(int id, String name, int companyId) {
        this.id = id;
        this.name = name;
        this.companyId = companyId;
    }

    // Getter for the car ID
    public int getId() {
        return id;
    }

    // Getter for the car name
    public String getName() {
        return name;
    }

    // Getter for the company ID
    public int getCompanyId() {
        return companyId;
    }

    // Setter for the car ID
    public void setId(int id) {
        this.id = id;
    }

    // Setter for the car name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for the company ID
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
