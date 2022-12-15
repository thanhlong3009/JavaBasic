package tets;
import java.util.Scanner;
public class Students extends Person{
    private double math;

    public Students() {
    }

    public Students(int id, String name, double math) {
        super(id,name);
        this.math = math;
    }

    public void setMath(double math) {
        this.math = math;
    }
    public double getMath() {
        return math;
    }
    public void display() {
        super.display();
        System.out.println("\tDiem toan: " + math);

    }
    public void enter() {
        Scanner sc = new Scanner(System.in);
        super.enter();
        System.out.print("\tNhap diem toan: ");
        this.math = Double.parseDouble(sc.nextLine());
    }


    @Override
    public String toString() {
        return "Students{" + "id=" + getId() +
                ", name='" + getName() + "'" +
                ", math=" + math +
                '}';
    }
}
