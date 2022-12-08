import java.util.Random;

public class Bai3 {
    public static void main(String[] args) {
        // random từ 1 đên 100
        int n = (int) Math.floor(Math.random() * 100);
        System.out.println("số ngẫu nhiên được sinh ra là: " + n);
        if (isPrimeNumber(n)) {
            System.out.println("Là số nguyên tố");
        }else {
            System.out.println("Không là số nguyên tố");
        }
    }
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
