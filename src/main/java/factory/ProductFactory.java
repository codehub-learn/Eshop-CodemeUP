package factory;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductFactory {

    public List<Product> parse(List<String> strings) {
        List<Product> products = new ArrayList<>();
        for (String productAsString : strings) {
            String[] splitProduct = productAsString.split(",");
            long id = Long.parseLong(splitProduct[0].trim());
            String name = splitProduct[1].trim();
            double price = Double.parseDouble(splitProduct[2].trim());
            Category category = Category.valueOf(splitProduct[3].trim());
            Product product = new Product(id, name, price, category);
            products.add(product);
        }
        return products;
    }
}
