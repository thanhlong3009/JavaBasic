import java.util.Scanner;

public class PracticeSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ngày trong tuần: ");
        int day = sc.nextInt();
        switch (day) {

            case 0: {
                System.out.println("Hôm nay là chủ nhật");
                break;
            }
            case 1: {
                System.out.println("Hôm nay là thứ 2 ");
                break;
            }
            case 2: {
                System.out.println("Hôm nay là thứ 3");
                break;
            }
            case 3: {
                System.out.println("Hôm nay là thứ 4");
                break;
            }
            case 4: {
                System.out.println("Hôm nay là thứ 5");
                break;
            }
            case 5: {
                System.out.println("Hôm nay là thứ 6");
                break;
            }
            case 6: {
                System.out.println("Hôm nay là thứ 7");
                break;
            }
            default: {
                System.out.println("Bạn đã nhập sai, vui lòng nhập lại");
            }

        }


        int month = 6;
        switch (month) {
            case 1:
            case 2:
            case 3:
            {
                System.out.println("Mùa xuân");
                break;
            }
            case 4:
            case 5:
            case 6:
            {
                System.out.println("Mùa hạ");
                break;
            }
            case 7:
            case 8:
            case 9:
            {
                System.out.println("Mùa thu");
                break;
            }
            case 10:
            case 11:
            case 12:
            {
                System.out.println("Mùa đông");
                break;
            }
            default: {
                System.out.println("bạn nhập không chính xác");
            }
        }
    }
}
