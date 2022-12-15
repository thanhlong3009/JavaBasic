package employee_management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dev[] devs = new Dev[2];

        for (int i = 0; i < 2; i++) {
            devs[i] = new Dev();
            System.out.println("Nhập thông tin Dev thứ " + (i+1));
            devs[i].enter();
        }

        Tester[] testers = new Tester[2];
        for (int i = 0; i < 2; i++) {
            testers[i] = new Tester();
            System.out.println("Nhập thông tin tester thứ " + (i+1));
            testers[i].enter();
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("Lập trình viên thứ " + (i+1));
            devs[i].display();
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("Tester thứ " + (i+1));
            testers[i].display();
        }


    }
}
