package gr.codelearn.controller;

import gr.codelearn.model.Order;
import gr.codelearn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BasicController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAll() {
        return orderService.getAll();
    }
}
