import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isQuit = false;
        while (!isQuit) {
            showMenu();

            System.out.print("Nhập lựa chọn : ");
            int option = sc.nextInt();

            switch (option) {

                case 1: {
                    HomeWork1();
                    break;
                }
                case 2: {
                    HomeWork2();
                    break;
                }
                case 3: {
                    isQuit = true;
                    System.out.println("Kết thúc chương trình!!!");
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ, nhập lại!");
                    break;
                }
            }
        }
    }

    public static void HomeWork1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập họ tên của bạn: ");
        String fullNamePrimitive = sc.nextLine();
        String fullName = fullNamePrimitive.toLowerCase();

        char[] fullNameArray = fullName.toCharArray();
        boolean space = true;
        for (int i = 0; i < fullNameArray.length; i++) {
            if (Character.isLetter(fullNameArray[i])) {
                if (space) {
                    fullNameArray[i] = Character.toUpperCase(fullNameArray[i]);
                    space = false;
                }
            } else {
                space = true;
            }
        }
        String newFullName = String.valueOf(fullNameArray);
        System.out.println("Tên sau khi chuẩn hóa: " + newFullName);
    }

    public static void HomeWork2() {
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

    public static void showMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Bài tập 1");
        System.out.println("2 - Bài tập 2");
        System.out.println("3 - Thoát\n");
    }

    //    ----------------------HomeWork2-----------------------
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
