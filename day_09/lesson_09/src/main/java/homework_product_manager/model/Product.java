package homework_product_manager.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private int price;
}
