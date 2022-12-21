package homework_product_manager;

import homework_product_manager.controller.ProductController;
import homework_product_manager.service.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.run();
    }
}
