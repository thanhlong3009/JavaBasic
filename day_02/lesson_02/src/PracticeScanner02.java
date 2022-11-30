import java.util.Scanner;

public class PracticeScanner02 {
    public static void main(String[] args) {
        Scanner string = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi : ");
        String str = string.nextLine();
        System.out.printf("Chuỗi in hoa của chuỗi \"%s\" là : %s\n", str,str.toUpperCase());
        System.out.printf("Chuỗi in thuờng của chuỗi \"%s\" là: %s\n", str,str.toLowerCase());
        System.out.printf("Số ký tự của chuỗi \"%s\" là: %d\n", str,(Integer)str.length());
        System.out.printf("Ký tự cuối cùng của chuỗi \"%s\" là: %s\n", str,str.charAt(str.length()-1));
        System.out.printf("5 ký tự đầu tiên của chuỗi \"%s\" là: %s\n", str,str.substring(0,5));
        System.out.printf("Chuỗi \"%s\" có chứa chuỗi \"Hello\" không: %s\n", str,str.contains("Hello"));
    }
}
