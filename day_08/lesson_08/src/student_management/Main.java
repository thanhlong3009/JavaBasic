package student_management;

import student_management.service.StudentService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        System.out.println(Arrays.toString(studentService.createStudent()));

    }
}
