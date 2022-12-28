package collection_demo;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student implements Comparable<Student>{
    private String name;
    private double point;


    //Comparable chỉ có thể so sánh tiêu chí theo 1 thuộc tính
    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("John", 8.5));
        students.add(new Student("Anna", 9));
        students.add(new Student("Victor", 7));
        students.add(new Student("Chris", 6.5));

        System.out.println("Danh sách học sinh: ");
        show(students);

        Collections.sort(students);
        System.out.println("Danh sách sau khi sắp xếp: ");
        show(students);



        //Sắp xếp theo tên
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                //Cài đặt chỉ tiêu để so sánh trong đây
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
        // làm theo lambda
        Collections.sort(students,(o1, o2) -> {return o1.getName().compareTo(o2.getName());});

        System.out.println("Danh sách sau khi sắp xêṕ tên tăng dần: ");
        show(students);

        //Sắp xếp theo điểm --- đã chuyển qua lambda
        Collections.sort(students, (o1, o2) -> {
            //Cài đặt chỉ tiêu để so sánh trong đây
            return o2.getPoint() - o1.getPoint() > 0 ? 1 : -1;
        });
        System.out.println("Danh sách sau khi sắp xêṕ điểm giảm dần: ");
        show(students);


        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });
    }

    public static void show(ArrayList<Student> list){
        for (Student student: list) {
            System.out.println(student);
        }
    }
}