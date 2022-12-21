package employee_manager.database;

import employee_manager.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {
    public static ArrayList<Employee> employees = new ArrayList<>(List.of(
            new Employee(1,"Trần Thành Long","long@gmail.com",7_000_000),
            new Employee(2,"Trần Thành Dương","duong@gmail.com",8_000_000),
            new Employee(3,"Nguyễn Ngọc Sơn","son@gmail.com",9_000_000),
            new Employee(4,"Trần Thành Trung","trung@gmail.com",10_000_000),
            new Employee(5,"Trần Trung Đức","duc@gmail.com",15_000_000)
    ));
}
