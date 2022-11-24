package service;

import model.Category;
import model.Customer;
import model.Order;
import model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private List<Product> productsInShop;
    private List<Customer> customers;
    private Order currentOrder;

    public OrderService(List<Product> productsInShop, List<Customer> customers, Order currentOrder) {
        this.productsInShop = productsInShop;
        this.customers = customers;
        this.currentOrder = currentOrder;
    }

    public void removeProductFromOrder(int productPosition) {
        if (productPosition >= 0 && productPosition < productsInShop.size()){
            Product product = productsInShop.get(productPosition);
        currentOrder.removeProduct(product);
        }
        else {
            System.out.println("This product does not exist");
        }
    }

    public void addProductToOrder(int productPosition) {
        if (productPosition >= 0 && productPosition < productsInShop.size()) {
            Product product = productsInShop.get(productPosition);
            currentOrder.addProduct(product);
        } else {
            System.out.println("This product does not exist");
        }
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}
