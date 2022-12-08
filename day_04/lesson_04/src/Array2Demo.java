import java.util.Scanner;

public class Array2Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số hàng của mảng: ");
        int row = sc.nextInt();
        System.out.print("Nhập số cột của mảng: ");
        int col = sc.nextInt();

        int[][] arrB = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập mảng vị trí %d %d: \n", i, j);
                arrB[i][j] = sc.nextInt();
            }
        }

        for (int h = 0; h < row; h++) {
            for (int g = 0; g < col; g++) {
                System.out.printf("%d ", arrB[h][g]);
            }
            System.out.println();
        }

        int max = 0;
        for (int m = 0 ; m < row ; m++) {
            for (int n = 0 ; n < col ; n++ ) {
                if (max < arrB[m][n]) {
                    max = arrB[m][n];
                }
            }
        }
        System.out.println("max = " + max);




    }
}
