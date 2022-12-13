package student_management.service;

import student_management.model.Student;

import java.util.Scanner;

public class StudentService {

    Student students = new Student();
    Scanner sc = new Scanner(System.in);


    public Student student = new Student();


    public Student createStudents() {
        Student students = new Student();
        student.id = (int) (Math.random() * (100 + 1));
        System.out.println("Nhập tên sinh viên");
        student.name = sc.nextLine();
        System.out.println("Nhập điểm lý thuyết: ");
        student.theoryPoint = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập điểm thực hành");
        student.theoryPoint = Double.parseDouble(sc.nextLine());

        return students;
    }
    public Student[] createStudent() {

        System.out.println("Nhập số lượng học viên: ");
        int number = Integer.parseInt(sc.nextLine());
        Student[] students = new Student[number];
        for (int i = 0; i < number; i++) {
            students[i] = createStudents() ;
        }
        return students;
    }

}
