import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Tạo mảng
        System.out.print("Nhập số dòng của mảng: ");
        int row = sc.nextInt();
        System.out.print("Nhập số cột của mảng: ");
        int col = sc.nextInt();

        // Nhập các phần tử của mảng
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập phần tử vị trí [%d][%d] của mảng: \n",i,j);
                arr[i][j] = sc.nextInt();
            }
        }

        // In ra mảng đã tạo
        System.out.println("Mảng đã tạo: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // Liệt kê các phần tử nằm trên đường tréo chính của mảng
        System.out.println("Liệt kê các phần tử nằm trên đường tréo chính của mảng: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == j) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
        System.out.println();

        //Cộng 2 mảng 2 chiều cùng hàng và cột
        int[][] arr2 = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập phần tử vị trí [%d][%d] của mảng thứ 2: \n",i,j);
                arr2[i][j] = sc.nextInt();
            }
        }

        int[][] newArr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newArr[i][j] = arr[i][j] + arr2[i][j];
            }
        }
        System.out.println("Mảng mới sau khi cộng 2 mảng 2 chiều là: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
