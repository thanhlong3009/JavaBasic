import java.util.Arrays;

public class Array2Demo {
    public static void main(String[] args) {
        int[] numbers = {1,2,3};
        int[][] numbersOther = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        for (int i = 0; i < numbersOther.length; i++) {
            System.out.println(Arrays.toString(numbersOther[i]));

            for (int j = 0; j < numbersOther.length; j++) {
                System.out.println(numbersOther[i][j]);
            }
        }

        System.out.println("Sử dụng for-each");
        for (int[] row: numbersOther) {
            for (int number: row) {
                System.out.println(number);
            }
        }
    }
}
