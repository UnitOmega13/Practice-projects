package service;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void add(Product product);
    List<Product> getAll();
    Optional<Product> getProduct(long productID);
    void removeProduct(long productID);
}
