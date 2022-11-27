import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập họ tên của bạn: ");
        String name = input.nextLine();
        System.out.print("Nhập tuổi của bạn: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.print("Nhập giới tính của bạn: ");
        String gender = input.nextLine();
        System.out.print("Nhập địa chỉ của bạn: ");
        String address = input.nextLine();
        System.out.printf("Xin chào các bạn, mình tên là %s" +
                ", năm nay mình %d tuổi" +
                ", giới tính %s" +
                ". Mình sinh ra và lớn lên tại %s\n", name,age,gender,address);
    }
}
