package main.controller;

import main.dao.impl.ProductDAO;
import main.factories.ProductDAOFactory;
import main.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductRegistrationServlet extends HttpServlet {

    private static final ProductDAO productDAO = ProductDAOFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/new_product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = -1;
        if (!req.getParameter("price").isEmpty()) {
            price = Double.valueOf(req.getParameter("price"));
        }
        if (name.isEmpty() || description.isEmpty() || price < 0) {
            req.setAttribute("isEmpty", "All fields must be filled and price must be biggest than 0.");
            req.getServletContext().getRequestDispatcher("/new_product.jsp").forward(req, resp);
        } else {
            productDAO.add(new Product(name, description, price));
            resp.setStatus(HttpServletResponse.SC_OK);
            req.getRequestDispatcher("/users.jsp").forward(req, resp);
        }
    }
}