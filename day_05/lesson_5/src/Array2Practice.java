import java.util.Scanner;

public class Array2Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số hàng cửa mảng: ");
        int row = sc.nextInt();
        System.out.print("Nhập vào số cột của mảng: ");

        int col = sc.nextInt();

        // nhập thông tin của mảng
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập phần tử của mảng vị trí [%d][%d]: \n", i, j);
                arr[i][j] = sc.nextInt();
            }
        }

        // In ra mảng dạng ma trận
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }

        // Tính tổng các phần tử chẵn của mảng
        int sum = 0;
        for (int[] subRow : arr) {
            for (int subRol: subRow){
                if (subRol % 2 == 0) {
                    sum += subRol;
                }
            }
        }
        System.out.print("Tổng các phần tử chẵn của mảng là: " + sum);

        //Tìm giá trị lớn nhất của mảng
    }
}
