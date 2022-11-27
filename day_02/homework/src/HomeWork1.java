import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Nhập chiều rộng của hình chữ nhật: ");
        double width = a.nextDouble();
        System.out.print("Nhập chiều dài của hình chữ nhật: ");
        double length = a.nextDouble();
        System.out.printf("Chu vi của hình chữ nhật là: %.2f\n", (width + length) * 2);
        System.out.printf("Diện tích của hình chữ nhật là: %.2f\n", width * length);
    }
}
