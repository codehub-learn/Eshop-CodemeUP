package gr.codelearn.model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private long id;
    private Customer customer;
    private ArrayList<OrderProduct> orderProducts;
    private Date dateCreated;
    private double totalCost;

    public Order(Customer customer) {
        this.id = 0;
        this.customer = customer;
        this.orderProducts = new ArrayList<>();
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public ArrayList<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(ArrayList<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderProducts=" + orderProducts +
                ", dateCreated=" + dateCreated +
                ", totalCost=" + totalCost +
                '}';
    }
}
