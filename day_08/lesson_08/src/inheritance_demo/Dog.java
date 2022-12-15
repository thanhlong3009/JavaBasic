package inheritance_demo;

public class Dog extends Animal {
    private String color;
    private int legs;

    public Dog() {
    }


    public Dog(String color, int legs) {
        this.color = color;
        this.legs = legs;
    }

    public Dog(String name, String color, int legs) {
        super(name);
        this.color = color;
        this.legs = legs;
    }

    // Định nghĩa phương thức của lớp con
    public void display() {
        System.out.println("My name is " + this.getName());
    }


    // Triển khai thay đổi logic của method lớp cha -> generate -> Override method
    @Override
    public void eat() {
        System.out.println("Chó ăn thịt");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }
}
