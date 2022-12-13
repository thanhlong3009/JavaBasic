package classDemo;

public class Persion {
    // thuộc tính(property)
    public String name;
    public String email;
    public int age;
    public String address;

    public Persion() {}
    public Persion(String name,String email) {
        this.name = name;
        this.email = email;
    }

    public Persion(String name, String email, int age, String address) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
    }



    // phương thức (method-hành động)
    public void play(String sprortName) {
        System.out.println("Chơi " + sprortName);
    }

    public void eat() {
        System.out.println("Ăn ...");
    }

    public void usePhone(Phone phone) {
        System.out.println(name + " đang sử dụng điện thoại " + phone.name + " của hãng " + phone.brand);
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
