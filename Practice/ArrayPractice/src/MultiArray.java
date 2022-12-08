import java.util.Scanner;

public class MultiArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số hàng của mảng");
        int row = sc.nextInt();
        System.out.println("Nhập số cột của mảng");
        int col = sc.nextInt();
        int[][] arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Nhập phần tử vị trí (" + i + "," + j + ") của mảng: ");
                arr[i][j] = sc.nextInt();
            }
        }
        for (int h = 0; h < row; h++) {
            for (int g = 0; g < col; g++) {
                System.out.printf("%d ", arr[h][g]);
            }
            System.out.println();
        }
        int sumOfEven = 0;
        for (int m = 0; m < row; m++) {
            for (int n = 0; n < col; n++) {
                if (arr[m][n] % 2 == 0) {
                    sumOfEven += arr[m][n];
                }
            }
        }
        System.out.println("Tổng các số chẵn của mảng là: " + sumOfEven);
        int maxOfArray = 0;
        for (int a = 0; a < row; a++) {
            for (int b = 0; b < col; b++) {
                if (arr[a][b] > maxOfArray) {
                   maxOfArray = arr[a][b] ;
                }
            }
        }
        System.out.println("Giá trị lớn nhất của mảng là: " + maxOfArray);

        int maxOfRow = 0;
        for (int c = 0; c < row; c++) {
            for (int d = 0; d < col; d++) {
                if (arr[c][d] > maxOfRow) {
                    maxOfRow = arr[c][d] ;
                }
            }

        }

    }


}
