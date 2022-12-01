import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int numbers = sc.nextInt();

        int[] arrA = new int[numbers];
        for (int i = 0; i < arrA.length; i++) {
            System.out.printf("nhập phần tử vị trí %d của mảng: \n", i);
            arrA[i] = sc.nextInt();
        }

        int sum = 0;
        for (int j = 0 ; j < arrA.length; j++) {
            System.out.println(arrA[j]);
            sum += arrA[j];
        }
        System.out.println("Tổng của mảng là: " + sum);

        System.out.println(Arrays.toString(arrA));


        int[] arrB = new int[numbers];
        for (int k = 0 ; k < arrA.length ; k++) {
            arrB[k] = arrA[k];
        }

        int[] arrC = new int[5];
        arrC = arrA;
        for (int h = 0 ; h < arrC.length; h++) {
            System.out.println(arrC[h]);

        }


        Arrays.sort(arrB);
        System.out.println(Arrays.toString(arrB));
        System.out.println(Arrays.toString(arrA));
    }
}
