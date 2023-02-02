package service;

import model.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthenticatorService {
    private static final Map<String, String> usernamesAndPasswords = new HashMap<>();

    public AuthenticatorService(List<Customer> customers) {
        for (Customer customer : customers) {
            usernamesAndPasswords.put(customer.getUsername(), customer.getPassword());
        }
    }

    public boolean authenticate(String username, String password){
        if (usernamesAndPasswords.containsKey(username)){
            return usernamesAndPasswords.get(username).equals(password);
        }
        return false;
    }
}
