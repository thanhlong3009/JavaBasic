package homework_product_manager.repository;

import homework_product_manager.database.ProductDB;
import homework_product_manager.model.Product;

import java.util.ArrayList;

public class ProductRepository {

    public ArrayList<Product> findAll() {
        return ProductDB.products;
    }

    public ArrayList<Product> findByNameContainsIgnoreCase(String name) {
        ArrayList<Product> rs = new ArrayList<>();
        for (Product p:findAll()) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                rs.add(p);
            }
        }
        return rs;
    }

    public Product findById(int id) {
        Product product = new Product();
        for (Product p: findAll()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        Product product = findById(id);
        ProductDB.products.remove(product);
    }

    public void updateQuantity (int quantity,int id) {
        for (Product p:findAll()) {
            if (p.getId() == id) {
                p.setQuantity(quantity);
            }
        }
    }

    public ArrayList<Product> findByQuantity(int quantity) {
        ArrayList<Product> rs = new ArrayList<>();
        for (Product p:findAll()) {
            if (p.getQuantity() < quantity) {
                rs.add(p);
            }
        }
        return rs;
    }

    public ArrayList<Product> findByPrice(int minPrice,int maxPrice) {
        ArrayList<Product> rs = new ArrayList<>();
        for (Product p:findAll()) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                rs.add(p);
            }
        }
        return rs;
    }
}
