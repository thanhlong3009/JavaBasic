public class Bai4 {
    public static void main(String[] args) {
        System.out.print("10 số nguyên tố đầu tiên là: ");
        int i = 2;
        for (int count = 0 ; count < 10; ) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
                count ++;
            }
            i++;
        }
        System.out.println();

        System.out.print("Các số nguyên tố nhỏ hơn 10 là: ");
        for (int j = 0; j < 10; j++) {
                if (isPrimeNumber(j)) {
                    System.out.print(j+ " ");
                }
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
