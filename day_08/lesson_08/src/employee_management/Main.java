package employee_management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Số Dev cần nhập: ");
        int devNumber = Integer.parseInt(sc.nextLine());
        System.out.println("Số Tester cần nhập: ");
        int testerNumber = Integer.parseInt(sc.nextLine());



        Dev[] devs = new Dev[devNumber];

        for (int i = 0; i < devNumber; i++) {
            devs[i] = new Dev();
            System.out.println("Nhập thông tin Dev thứ " + (i+1));
            devs[i].enter();
        }

        Tester[] testers = new Tester[testerNumber];
        for (int i = 0; i < testerNumber; i++) {
            testers[i] = new Tester();
            System.out.println("Nhập thông tin tester thứ " + (i+1));
            testers[i].enter();
        }

        for (int i = 0; i < devNumber; i++) {
            System.out.println("Lập trình viên thứ " + (i+1));
            System.out.println(devs[i]);
        }

        for (int i = 0; i < testerNumber; i++) {
            System.out.println("Tester thứ " + (i+1));
            System.out.println(testers[i]);
        }


    }
}
