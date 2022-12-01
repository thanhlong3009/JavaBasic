import java.util.Scanner;

public class PracticeWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.print("Nhập  số: ");
            int number = sc.nextInt();
            if (number != 0) {
                System.out.println("bạn đã nhập số " + number);
                break;
            }else  {
                System.out.println("bạn đã nhập số 0, yêu cầu nhập lại!");
            }
        }
    }
}