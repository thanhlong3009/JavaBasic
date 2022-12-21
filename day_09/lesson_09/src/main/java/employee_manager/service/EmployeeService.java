package employee_manager.service;

import employee_manager.database.EmployeeDB;
import employee_manager.model.Employee;
import employee_manager.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    public void printEmployees() {
        for (Employee s:employeeRepository.findAll()) {
            System.out.println(s);
        }
    }
    public void addEmployee() {
        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Nhập Id");
        employee.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập tên: ");
        employee.setName(sc.nextLine());
        System.out.println("Nhập email: ");
        employee.setEmail(sc.nextLine());
        System.out.println("nhập lương: ");
        employee.setSalary(Integer.parseInt(sc.nextLine()));

        employeeRepository.save(employee);
    }

    public void findByNameContainsIgnoreCase(String name) {
        for (Employee s:employeeRepository.findByNameContainsIgnoreCase(name)) {
            System.out.println(s);
        }
    }
    public void findByID(int id) {
        System.out.println(employeeRepository.findByID(id));;
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    public void findBySalary(int minSalary,int maxSalary) {
        for (Employee s:employeeRepository.findBySalary(minSalary,maxSalary)) {
            System.out.println(s);
        }
    }
}
