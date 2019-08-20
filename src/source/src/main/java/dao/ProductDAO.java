package dao;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    void add(Product product);
    List<Product> getAll();
    Optional<Product> getProduct(Long productID);
    void removeProduct(Long productID);
    void updateProduct(Product oldProduct, Product newProduct);
}
