package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private long id;
    private Customer customer;
    private ArrayList<Product> products;
    private Date dateCreated;
    private int productCount;
    private double totalCost;

    public Order(long id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.dateCreated = new Date();
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void addProduct(Product product) {
        products.add(product);
        productCount++;
        totalCost += product.getPrice();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        productCount--;
        totalCost -= product.getPrice();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", products=" + products +
                ", dateCreated=" + dateCreated +
                ", productCount=" + productCount +
                ", totalCost=" + df.format(totalCost) +
                '}';
    }
}
