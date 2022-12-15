package student_management;



import student_management.model.Student;
import student_management.service.StudentService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
//        Student student = studentService.createStudent();
//        studentService.printInfo(student);

        Student[] students = new Student[3];
        for (int i = 0 ; i < students.length ; i++) {
            students[i] = studentService.createStudent();
        }

        for (int i = 0 ; i < students.length ; i++) {
            studentService.printInfo(students[i]);
        }



    }
}
