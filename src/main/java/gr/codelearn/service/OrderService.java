package gr.codelearn.service;

import gr.codelearn.model.Customer;
import gr.codelearn.model.Order;
import gr.codelearn.model.OrderProduct;
import gr.codelearn.model.Product;
import gr.codelearn.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

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
        orderRepository.save(order);
    }

    public List<Order> getAll(){
        return orderRepository.getAll();
    }
}
