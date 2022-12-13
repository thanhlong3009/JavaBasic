package ThisDemo;

import java.io.FilterOutputStream;

public class Test {
    public static void main(String[] args) {
        // Từ khóa this trong student
        Student student = new Student("Trần Thị C", 30, Gender.FEMALE);
        System.out.println(student);
        student.methodTwo();
        System.out.println(student.setAge());
    }
}
