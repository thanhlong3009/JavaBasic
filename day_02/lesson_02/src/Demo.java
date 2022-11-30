import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int a = 0;
        CheckMark(a);


        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ngày trong tuần: ");
        int day = sc.nextInt();
        switch (day){

            case 0:
            {
                System.out.println("Hôm nay là chủ nhật");
                break;
            }
            case 1:
            {
                System.out.println("Hôm nay là thứ 2 ");break;
            }
            case 2:
            {
                System.out.println("Hôm nay là 3");break;
            }
            case 3:
            {
                System.out.println("Hôm nay là 4");break;
            }
            case 4:
            {
                System.out.println("Hôm nay là 5");break;
            }
            case 5:
            {
                System.out.println("Hôm nay là 6");break;3
            }
            default:{
                System.out.println("Bạn đã nhập sai, vui lòng nhập lại");
            }

        }
    }
    public static int CheckMark(int makr) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập giá trị của Mark: ");
        int mark = sc.nextInt();
        if (mark >= 85) {
            System.out.println("A");
        } else if (70 <= mark && mark < 85) {
            System.out.println("B");
        } else if (40 <= mark && mark < 70) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }

        return mark;
    }
}
