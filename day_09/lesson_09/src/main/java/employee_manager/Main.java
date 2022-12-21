package employee_manager;

import employee_manager.controller.EmployeeController;

public class Main {
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        employeeController.run();
    }
}
