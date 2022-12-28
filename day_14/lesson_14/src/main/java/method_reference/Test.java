package method_reference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Triển khai functional interface
        Student student = new Student(1, "Bùi Hiên", "hiengmail.com");
        IStudent iStudent = student::printInfo;
        iStudent.display();

        // Tham chiếu đến method của 1 instance
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Bùi Hiên", "hiengmail.com"));
        students.add(new Student(2, "Thu Hằng", "hanggmail.com"));
        students.add(new Student(3, "Phương Loan", "loangmail.com"));

        // Theo lambda
//        students.forEach(std -> std.printInfo());
//        students.forEach(std -> System.out.println(std));
        students.forEach(Student::printInfo);
        students.forEach(System.out::println);

        // Sắp xếp theo tên
        // triển khai theo huớng lambda
//        students.sort((std1, std2) -> std1.getName().compareTo(std2.getName()));
        students.sort(Comparator.comparing(Student::getName));
        students.forEach(System.out::println);
    }

}
