package employee_management;


import java.util.Scanner;

public class Dev extends Employee {
    private  int overtimeHours;



    public Dev(int id, String name, int age, String phone, String email, int salaryBasic, int overtimeHours) {
        super(id, name, age, phone, email, salaryBasic);

        this.overtimeHours = overtimeHours;
    }

    public Dev() {

    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public int calculateSalary() {
        return getSalaryBasic() + getOvertimeHours()*200_000;
    }

    public void enter() {
        Scanner sc = new Scanner(System.in);

        super.enter();
        System.out.println("Nhập số giờ OT: ");

        this.setOvertimeHours(Integer.parseInt(sc.nextLine()));

    }


    @Override
    public String toString() {
        return "Dev{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", salaryBasic=" + getSalaryBasic() +
                ", overtimeHours=" + overtimeHours + ", Salary=" + calculateSalary() +
                '}';
    }
}
