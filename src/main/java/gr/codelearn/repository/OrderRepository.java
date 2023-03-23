package gr.codelearn.repository;

import gr.codelearn.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepository {
    private final List<Order> orderList = new ArrayList<>();

    public void save(Order order){
        orderList.add(order);
    }

    public List<Order> getAll(){
        return orderList;
    }
}
