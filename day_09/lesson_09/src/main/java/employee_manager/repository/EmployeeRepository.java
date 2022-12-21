package employee_manager.repository;

import employee_manager.database.EmployeeDB;
import employee_manager.exception.InValidSalaryException;
import employee_manager.exception.NotFoundException;
import employee_manager.model.Employee;

import java.util.ArrayList;

public class EmployeeRepository {
    public ArrayList<Employee> findAll() {
        return EmployeeDB.employees;
    }

    public void save(Employee employee) {
        EmployeeDB.employees.add(employee);
    }

    public ArrayList<Employee> findByNameContainsIgnoreCase(String name) {
        ArrayList<Employee> rs = new ArrayList<>();
        for (Employee e:EmployeeDB.employees) {
            if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                rs.add(e);
            }
        }

        return rs;
    }

    public Employee findByID(int id) {

        for (Employee e:EmployeeDB.employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new NotFoundException("Not found employee with id = " + id);

    }

    public void deleteById(int id) {
        Employee employee = findByID(id);
        EmployeeDB.employees.remove(employee);
    }

    public ArrayList<Employee> findBySalary(int minSalary,int maxSalary) {
        if (minSalary >= maxSalary) {
            throw new InValidSalaryException("minSalary không được lớn hơn maxSalary");
        }
        ArrayList<Employee> rs = new ArrayList<>();
        for (Employee e:EmployeeDB.employees) {
            if (e.getSalary() > minSalary && e.getSalary() < maxSalary) {
                rs.add(e);
            }
        }

        return rs;
    }
}
