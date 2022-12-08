import java.util.Scanner;

public class ArrayPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu cua mang: ");
        int volElement = sc.nextInt();
        int[] arr = new int[volElement];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Nhap phan tu vi tri %d cua mang: \n", i);
            arr[i] = sc.nextInt();
        }

        getRemainder(arr); //bài 1
        copyString("a"); // bài 2
        copyString2("a1"); // bài 3
        System.out.println(checkElementExist(arr, 1)); //bài 4

        randomRgbCode(); //bài 6

    }


    //    ---------------------bai 1---------------
    public static void getRemainder(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }

    //---------------------bai 2-------------------
    public static void copyString(String str) {
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = str;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //    ---------------------bài 3------------------
    public static void copyString2(String str) {
        String[] arr = new String[10];
        arr[0] = str;
        for (int i = 1; i < 10; i++) {
            arr[i] = "-" + str;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
    //--------------------bài 4-------------------
    public static boolean checkElementExist(int[] arr, int a) {
        boolean check = false;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == a) {
                check = true;
            }
        }
        return check;
    }

//    -----------------------bài 5---------------------
    public static void randomHexCode() {
        char[] arr = new char[6];

    }
//    ---------------------bài 6-------------------------
    public static void randomRgbCode() {
        int[] arr = new int[3];
        for (int i = 0 ; i < 3 ; i++) {
            arr[i] = (int) ((Math.random()) * ((255-0)+1 ) + 0);
        }
        System.out.print("rgb(" + arr[0] + "," + arr[1] + "," + arr[2] + ")");
    }
}
