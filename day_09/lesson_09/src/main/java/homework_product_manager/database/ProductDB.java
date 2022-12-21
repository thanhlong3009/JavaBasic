package homework_product_manager.database;

import com.github.javafaker.Faker;
import homework_product_manager.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    public static ArrayList<Product> products = new ArrayList<>(List.of(
            new Product(1,"Chổi","Đồ gia dụng",10,20_000),
            new Product(2,"Thau","Đồ gia dụng",20,30_000),
            new Product(3,"Chậu","Đồ gia dụng",15,50_000),
            new Product(4,"Quạt điện","Đồ điện",6,100_000),
            new Product(5,"Máy sấy","Đồ điện",17,80_000),
            new Product(6,"Loa kéo","Đồ điện tử",8,200_000),
            new Product(7,"TV","Đồ điện tử",20,10_000_000),
            new Product(8,"Máy ảnh","Đồ điện tử",10,5_200_000),
            new Product(9,"Iphone 14","Đồ điện tử",25,28_000_000),
            new Product(10,"Tủ gỗ","Nội thất",5,5_000_000),
            new Product(11,"Giường ngủ","Nội thất",5,7_000_000),
            new Product(12,"Kệ TV","Nội thất",10,3_000_000),
            new Product(13,"Thảm sàn nhà","Nội thất",30,100_000)
    )
    );

}
