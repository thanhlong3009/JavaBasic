import java.sql.SQLOutput;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên :");
        String name = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();
        System.out.println("Nhập tuổi :");
        //Cách 1:  khắc phục lỗi trôi lệnh
        //        int age = Integer.parseInt(sc.nextLine());
        // Cách 2
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập email :");
        String email = sc.nextLine();

        // println : tự động xuống dòng

        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Email: " + email);
        // print : không tự xuống dòng
        System.out.print("Tên: " + name + "\n\t");
        System.out.print("Tuổi: " + age + "\n\t");
        System.out.print("Email: " + email + "\n");

        //printf :  In theo định dạng

        System.out.printf("Tên: %s\n" , name);
        System.out.printf("Tuổi: %d\n" , age);
        System.out.printf("Email: %s\n" ,email);


        System.out.printf("%-20s %-18s %-18s\n", "Họ tên", "Email", "Số điện thoại");
        System.out.printf("%-20s %-18s %-18d\n", "Bùi Văn Hiên", "hien@gmail.com", 25);
        System.out.printf("%-20s %-18s %-18d\n", "Nguyễn Thị Thu Hằng", "hien@gmail.com", 27);
        System.out.printf("%-20s %-18s %-18d\n", "Bùi Phương Loan", "hien@gmail.com", 18);

    }
}
