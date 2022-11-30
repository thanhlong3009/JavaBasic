import java.lang.Math;
public class HomeWork {
    public static void main(String[] args) {
        // bài 1
        System.out.println(repeatString1("Trần"));

        // bài 2
        System.out.println(repeatString2("Thành"));

        // bài 3
        System.out.println(repeat3("Long", 5));

        // bài 4
        System.out.println(sumOf());

        // bài 5
        System.out.println(calculateVolumeOfSphere(5));

       

        // bài 6
        printForLoop();
    }


    // bài 1:
    public static String repeatString1(String str) {
        String rp = "";
        for (int i = 1; i <= 10; i++) {
            rp += str;
        }
        return rp;
    }

    // bài 2

    public static String repeatString2(String str) {
        String rp = str;
        for (int i = 1; i < 10; i++) {
            rp = rp + "-" + str;
        }
        return rp;
    }

    // bài 3
    public static String repeat3(String str, int number) {
        String rp = str;
        for (int i = 1; i < number; i++) {
            rp = rp + "-" + str;
        }
        return rp;
    }

    // bài 4
    public static int sumOf() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // bài 5
    public static double calculateVolumeOfSphere(double radius) {
        return 3d / 4 * Math.PI * Math.pow(radius,3);
    }

    // bài 6
    public static void printForLoop() {
        for (int i = 1 ; i <= 100 ; i++) {
            if (i % 3 == 0 & i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
