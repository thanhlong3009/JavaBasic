package abstract_class;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Developer(1,"Trần Thành Long",22,5_000_000,30);

        System.out.println(employee.calculateSalary());


        Employee employee1 = new Tester(2,"Trần Thành Dương",30,7_000_000,10);
        System.out.println(employee1.calculateSalary());

        // Tạo một danh sách nhân viên
        ArrayList<Employee>  employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);

        employees.add(new Developer(3,"Nguyễn Ngọc A",15,7_000_000,10));
        employees.add(new Tester(4,"Phạm Thị C",25,4_000_000,20));



        System.out.println("Lương của từng nhân viên");
        for (Employee e:employees) {
            e.showInfo();
        }

        // sắp xếp theo lương giảm dận
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                // 1, 0, -1
                return o2.calculateSalary() - o1.calculateSalary();
            }
        });
        System.out.println("Lương giảm dần");
        for (Employee e:employees) {
            e.showInfo();
        }

        // Sắp xếp tuổi tăng dần
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                // 1, 0, -1
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println("Tuổi tăng dần");
//        for (Employee e:employees) {
//            e.showInfo();
//        }
        //lambda expression
//        employees.forEach(e -> e.showInfo());

//        method reference
        employees.forEach(Employee::showInfo);

        // Sử dụng stream (demo)
        // stream, method reference, lambda expression (java 8)
        System.out.println("sắp xếp theo lương cơ bản");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalaryBasic))
                .forEach(Employee::showInfo);

    }
}
