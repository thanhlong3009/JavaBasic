package employee_manager.controller;

import employee_manager.database.EmployeeDB;

import employee_manager.service.EmployeeService;

import java.util.Scanner;

public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            showMenu();

            System.out.print("Nhập lựa chọn : ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    System.out.println("--------Thông tin nhân viên------");
                    employeeService.printEmployees();

                    break;
                }
                case 2: {
                    employeeService.addEmployee();
                    break;
                }
                case 3: {
                    System.out.println("Nhập tên cần tìm kiếm");
                    String name = sc.nextLine();
                    employeeService.findByNameContainsIgnoreCase(name);
                    break;
                }
                case 4: {
                    System.out.println("Nhập id cần tìm:");
                    int id = Integer.parseInt(sc.nextLine());
                    employeeService.findByID(id);


                    break;
                }
                case 5: {
                    System.out.println("Nhập id cần xóa: ");
                    int id = Integer.parseInt(sc.nextLine());
                    employeeService.delete(id);
                    break;
                }
                case 6: {
                    System.out.println("Nhập số tiền tối thiểu để tìm: ");
                    int minSalary = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập số tiền tối đa để tìm: ");
                    int maxSalary = Integer.parseInt(sc.nextLine());
                    employeeService.findBySalary(minSalary,maxSalary);

                    break;
                }
                case 7: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }
    public static void showMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - In thông tin của tất cả nhân viên");
        System.out.println("2 - Thêm nhân viên mới");
        System.out.println("3 -Tìm kiếm nhân viên theo name");
        System.out.println("4 -Tìm kiếm nhân viên theo id");
        System.out.println("5 -Xóa nhân viên theo id");
        System.out.println("6 -Tìm kiếm nhân viên theo khoảng lương");
        System.out.println("7 - Thoát\n");
    }
}
