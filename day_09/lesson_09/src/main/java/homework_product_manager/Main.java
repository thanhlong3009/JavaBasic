package homework_product_manager;

import homework_product_manager.controller.ProductController;


public class Main {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.run();
    }
}
