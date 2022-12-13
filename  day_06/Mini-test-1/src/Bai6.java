import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Định nghĩa email:
//        - Bắt đầu bằng chữ cái.
//        - Chỉ chứa chữ cái, chữ số và dấu gạch ngang (-)
//        - Chứa một ký tự @, sau @ là tên miền.
//        - Tên miền có thể là domain.xxx.yyy hoặc domain.xxx. Trong đó xxx và yyy là các chữ cái và có độ dài từ 2 trở lên.
        String EMAIL_PATTERN =  "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";

//        Định nghĩa số điện thoại:
//        - chứa 9 đến 11 chữ số
        String PHONE_PATTERN = "\\d{9,11}";

        // Nhập từ bàn phím
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = sc.nextLine();

        // kiểm tra
        System.out.println("email nhập có chính xác không?: " + Pattern.matches(EMAIL_PATTERN,email));
        System.out.println("Số điện thoại nhập có chính xác không?: " + Pattern.matches(PHONE_PATTERN,phoneNumber));
    }
}
