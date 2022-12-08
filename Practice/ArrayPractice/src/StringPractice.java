import java.util.Arrays;
import java.util.Scanner;

public class StringPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int number = sc.nextInt();
        int[] arr = new int[number];

        for (int i = 0; i < number; i++) {
            System.out.printf("Nhập phần tử vị trí %d của mảng: ", i);
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.print("Nhập phần tử thêm vào chuỗi: ");
        int k = sc.nextInt();


        int[] arrInsert = insert(arr, k);


        Arrays.sort(arrInsert);
        System.out.println(Arrays.toString(arrInsert));



    }
    // Thêm 1 phần tử vào mảng
    public static int[] insert(int[] arr, int k) {
        int arrISLength = arr.length+1;
        int[] arrIS = new int[arrISLength];
        arrIS[arr.length] = k;
        for (int i = 0; i < arrISLength - 1 ; i++) {
            arrIS[i] = arr[i];
        }
        return arrIS;
    }
}
