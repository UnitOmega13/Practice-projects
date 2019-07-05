package service;

import dao.ProductDAO;

public class ProductDAOFactory {
    private static ProductDAO instance;

    private ProductDAOFactory() {
    }

    public static ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }
}
