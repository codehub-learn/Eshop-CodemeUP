package factory;

import model.Product;

import java.util.List;

public interface Factory<T> {
    List<T> parse(List<String> strings);
}
