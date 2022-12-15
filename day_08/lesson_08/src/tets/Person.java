package tets;

import java.util.Scanner;

public class Person {
    private int id;
    private String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.print(id + " " + name + " ");
    }

    public void enter(Person s) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\tNhap id: ");
        s.setId(Integer.parseInt(sc.nextLine()));
        System.out.print("\tNhap ho ten: ");
        s.setName(sc.nextLine());
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
