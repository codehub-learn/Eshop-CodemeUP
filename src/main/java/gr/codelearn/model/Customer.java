package gr.codelearn.model;

public class Customer {
    private long id;
    private String name;
    private String address;
    private String email;
    private double balance;
    private String username;
    private String password;

    public Customer(long id, String name, String address, String email, double balance, String username, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.balance = balance;
        this.username = username;
        this.password = password;
    }

    public Customer(String name, String address, String email) {
        this.id = 0;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
