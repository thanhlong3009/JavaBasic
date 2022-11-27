import java.sql.SQLOutput;
import java.util.Scanner;

public class PracticeScanner01 {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.print("Nhập số thứ nhất: ");
        int a = number.nextInt();
        System.out.print("Nhập vào số  thứ 2: ");
        int b = number.nextInt();
        System.out.printf("%d + %d = %d\n" , a,b,a+b);
        System.out.printf("%d - %d = %d\n" , a,b,a-b);
        System.out.printf("%d * %d = %d\n" , a,b,a*b);
        System.out.printf("%d / %d = %f\n" , a,b, (double)a/b);
        System.out.printf("%d ^ %d = %d\n" , a,b,(int)Math.pow(a,b));
        System.out.printf("%d %% %d = %d\n" , a,b, a%b);

    }
}
