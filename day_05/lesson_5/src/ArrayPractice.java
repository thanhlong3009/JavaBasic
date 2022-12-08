import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayPractice {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(modulo2(arr)));

        System.out.println(stringReapeat2("ab"));

        System.out.println(stringReapeat3("ab"));

        int[] arrCheck = {1, 3, 4, 5};
        System.out.println(checkElementExist(arrCheck, 4));

        //bài 5
        randomHexCode();

        randomRgbCode();
    }

    public static int[] modulo2(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }

        }
        return arr;
    }

    public static String stringReapeat2(String str) {
        String[] arrReapeat = new String[10];
        for (int i = 0; i < arrReapeat.length; i++) {
            arrReapeat[i] = str;
        }
        String strReapeat = String.join(" ", arrReapeat);
        return strReapeat;
    }

    public static String stringReapeat3(String str) {
        String[] arrReapeat = new String[10];
        for (int i = 0; i < arrReapeat.length; i++) {
            arrReapeat[i] = str;
        }
        String strReapeat = String.join("-", arrReapeat);
        return strReapeat;
    }

    public static boolean checkElementExist(int[] arr, int a) {
        boolean check = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                check = true;
            }
        }
        return check;
    }

    public static void randomHexCode() {
        int[] arr = new int[3];
        for (int i = 0 ; i < 3 ; i++) {
            arr[i] = (int) ((Math.random()) * ((255-0)+1 ) + 0);

        }
        System.out.print("Mã màu hex ngầu nhiên là: ");
        System.out.println("#"+ Integer.toHexString(arr[0]) + Integer.toHexString(arr[1]) + Integer.toHexString(arr[2]) );
    }
    public static void randomRgbCode() {
        int[] arr = new int[3];
        for (int i = 0 ; i < 3 ; i++) {
            arr[i] = (int) ((Math.random()) * ((255-0)+1 ) + 0);

        }
        System.out.print("Mã mày RGB ngẫu nhiên là: ");
        System.out.print("rgb(" + arr[0] + "," + arr[1] + "," + arr[2] + ")");
    }
}
