import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int numberOfelement = sc.nextInt();

        int[] arr = new int[numberOfelement];

        boolean isQuit = false;
        while (!isQuit) {
            showMenuHW2();

            System.out.print("Nhập lựa chọn : ");
            int option = sc.nextInt();

            switch (option) {
                case 1: {
                    enterElementOfArray(arr);
                    break;
                }
                case 2: {
                    printArray(arr);
                    break;
                }
                case 3: {
                    printNewArray(arr);
                    break;
                }
                case 4: {
                    isQuit = true;
                    System.out.println("Kết thúc bài tập 2!!!");
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ, nhập lại!");
                    break;
                }
            }
        }
    }

    public static void enterElementOfArray(int[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Nhập phần tử thứ %d của mảng: ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println("Nhận thành công!");
    }

    public static void printArray(int[] arr) {
        System.out.println("In ra màn hình mảng nhận được");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void printNewArray(int[] arr) {
        System.out.println("In ra màn hình mảng mới");
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 2 == 0) {
                arr[i] += 1;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }

    public static void showMenuHW2() {
        System.out.println("\n********* MENU HOMEWORK 02 *********");
        System.out.println("1 - Nhập phần tử của mảng");
        System.out.println("2 - In mảng ra màn hình");
        System.out.println("3 - In ra màn hình mảng mới");
        System.out.println("4 - Thoát\n");
    }
}

