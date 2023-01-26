package service;

import model.Customer;
import model.Order;
import model.OrderProduct;
import model.Product;

import java.util.List;

public class OrderService {
    private List<Product> productsInShop;
    private List<Customer> customers;
    private Order currentOrder;

/*    public OrderService(List<Product> productsInShop, List<Customer> customers, Order currentOrder) {
        this.productsInShop = productsInShop;
        this.customers = customers;
        this.currentOrder = currentOrder;
    }*/

    public Order initiateOrder(Customer customer){
        return new Order(customer);
    }

    public void addProductToOrder(Product product, Order order){
        boolean productExists = false;
        // if product already exists
        for (OrderProduct oP : order.getOrderProducts()) {
            if(oP.getProduct().getName().equals(product.getName())){
                int previousQuantity = oP.getQuantity();
                oP.setQuantity(previousQuantity + 1);
                double previousPrice = oP.getPrice();
                oP.setPrice(previousPrice + product.getPrice());
                productExists = true;
                break;
            }
        }
        // if product does not exist
        if(!productExists){
            OrderProduct orderProduct = new OrderProduct(product, product.getPrice(), 1);
            order.getOrderProducts().add(orderProduct);
        }
    }

    public void removeProductFromOrder(Product product, Order order){
        int index = 0;
        for (int i = 0; i < order.getOrderProducts().size(); i++) {
            OrderProduct orderProduct = order.getOrderProducts().get(i);
            if(orderProduct.getProduct().getName().equals(product.getName())){
                index = i;
                break;
            }
        }
        order.getOrderProducts().remove(index);
    }

    public void checkout(Order order){
        // calculate total cost
        double totalCost = 0.0;
        for (OrderProduct oP : order.getOrderProducts()) {
            totalCost += oP.getPrice();
        }
        order.setTotalCost(totalCost);
    }



    /*public void removeProductFromOrder(int productPosition) {
        if (productPosition >= 0 && productPosition < productsInShop.size()) {
            Product product = productsInShop.get(productPosition);
            currentOrder.removeProduct(product);
        } else {
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
    }*/
}
