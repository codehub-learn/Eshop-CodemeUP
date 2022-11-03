package model;

import java.util.Date;
import java.util.List;

public class Order {
    private long id;
    private Customer customer;
    private List<Product> products;
    private Date dateCreated;

    public Order(long id, Customer customer, List<Product> products, Date dateCreated) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", products=" + products +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
