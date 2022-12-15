package employee_management;

import java.util.Scanner;

public class Tester extends Employee{
    private int error;



    public Tester(){

    }

    public Tester(int id, String name, int age, String phone, String email, int salaryBasic, int error) {
        super(id, name, age, phone, email, salaryBasic);
        this.error = error;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public int calculateSalary() {
        return getSalaryBasic() + getError()*50_000;
    }


    public void enter() {
        Scanner sc = new Scanner(System.in);
        super.enter();
        System.out.println("Nhập số lỗi phát hiện được: ");
        this.setError(Integer.parseInt(sc.nextLine()));
    }


    @Override
    public String toString() {
        return "Tester{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", salaryBasic=" + getSalaryBasic() +
                ", error=" + error + ", Salary=" + calculateSalary() +
                '}';
    }
}
