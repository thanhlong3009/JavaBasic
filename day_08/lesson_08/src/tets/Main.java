package tets;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//
        Students students = new Students();
        students.enter();
        System.out.println(students);
//        Person person = new Person();
//        person.enter();
//        System.out.println(person);
        Students[] students1 = new Students[3];
        for (int i = 0; i < 3; i++) {
            students1[i] = new Students();
            students1[i].enter();

        }

        for (int i = 0; i < 3; i++) {
            System.out.println(students1[i]);
        }


    }
}
