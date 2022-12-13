package student_management.service;

import student_management.model.Student;

import java.util.Scanner;

public class StudentService {

    Student student = new Student();



    public  Student createStudent() {

        Scanner sc = new Scanner(System.in);
        int id = (int) (Math.random() * (100 + 1));


        System.out.println("nhập tên sinh viên: ");
        String name = sc.nextLine();
        System.out.println("Nhập điểm lý thuyêts: ");
        double theoryPoint = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập điểm thực hành: ");
        double practicePoint = Double.parseDouble(sc.nextLine());

        return new Student(id,name,theoryPoint,practicePoint);

    }

    public double calculateAvgPoint(double theoryPoint, double practicePoint) {

        return (theoryPoint + practicePoint)/2;
    }


    public void printInfo(Student s) {
        System.out.println("id : " + s.id);
        System.out.println("name : " + s.name);
        System.out.println("theoryPoint : " + s.theoryPoint);
        System.out.println("practicePoint : " + s.practicePoint);
        System.out.println("avgPoint : " + calculateAvgPoint(s.theoryPoint,s.practicePoint));



    }

}
