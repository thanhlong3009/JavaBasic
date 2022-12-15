package tets;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Person[] people = new Person[2];
//        for (int i = 0; i < 2; i++) {
//            people[i] = new Person();
//            people[i].enter(people[i]);
//        }
//
//        for (int i = 0; i < 2; i++) {
//            people[i].display();
//        }

        Students students = new Students();
        students.enter(students);
        students.display();
    }
}
