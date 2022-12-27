package upcasting_demo;

public class Test {
    public static void main(String[] args) {
        Person p = new Student("Long");

        p.eat();
        p.work();
        p.sleep();
        ((Student) p).display();
        System.out.println();

        // Downcasting
        Student student = (Student) p;
        student.eat();
        student.work();
        student.sleep();
        student.display();

    }
}
