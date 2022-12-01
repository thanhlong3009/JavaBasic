import java.util.Random;
import java.util.Scanner;

public class PracticeWhile2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int randomNumber = (int) Math.floor(Math.random() * 100);
        // cách 2 random
//        Random rd = new Random();
//        int rdNumber = rd.nextInt(101);
        while (true) {
            System.out.print("Nhập  số: ");
            int number = sc.nextInt();
            if (number == randomNumber) {
                System.out.println("Bạn đã đoán chính xác");
                break;
            } else if (number > randomNumber) {
                System.out.println("Bạn nhập số lớn hơn rồi, nhập lại!");
            } else {
                System.out.println("Bạn nhập số nhỏ hơn rồi, nhập lại!");
            }
        }
    }
}
