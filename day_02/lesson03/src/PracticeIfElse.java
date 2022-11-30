import java.util.Scanner;

public class PracticeIfElse {
    public static void main(String[] args) {
//        getMark(40);

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập cân nằng: ");
        float weight = sc.nextFloat();
        System.out.print("Nhập chiều cao: ");
        float height = sc.nextFloat();
        float BMI = weight / (height * 2);
        System.out.printf("Chỉ số BMI = %.2f\n" , BMI);
        if (BMI < 18.5) {
            System.out.println("Thiếu cân");
        } else if (BMI >= 18.5 && BMI < 24.9) {
            System.out.println(" Bình thuờng");
        } else if (BMI > 24.9) {
            System.out.println("Thừa cân");
        }
    }

    // bài 3
    public static int getMark(int number) {
        if (number > 85) {
            System.out.println("A");
        } else if (70 <= number && number < 85) {
            System.out.println("B");
        } else if (40 <= number && number < 70) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }
        return number;
    }
}
