package carsharing.company;

public class Company {
    private int id;
    private String name;

    // Constructor to create a Company object with a name
    public Company(String name) {
        this.name = name;
    }

    // Constructor to create a Company object with an ID and name
    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter for the company ID
    public int getId() {
        return id;
    }

    // Getter for the company name
    public String getName() {
        return name;
    }

    // Setter for the company ID
    public void setId(int id) {
        this.id = id;
    }

    // Setter for the company name
    public void setName(String name) {
        this.name = name;
    }
}
