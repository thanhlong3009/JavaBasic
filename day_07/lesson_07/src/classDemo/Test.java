package classDemo;

public class Test {


    public static void main(String[] args) {
        // khởi tạo đối tượng
        Persion person = new Persion();

        System.out.println(person.name); // null(default value của String)

        // gán các giá trị cho thuộc tính cuả đối tượng

        person.name = "Tran Thanh long";
        person.email = "thanhlong@gmail.com";
        person.age = 22;
        person.address = "Ha Noi";

        //In ra thông tin của đối tượng
        System.out.println(person.name + "-" + person.email + "-" + person.age + "-" + person.address + ".");

        System.out.println(person);

        //Khởi tạo đối tượng phone
        Phone phone = new Phone();
        phone.name = "Iphone 13 PRM";
        phone.brand = "Apple";

        person.usePhone(phone);


        Calculator calculator = new Calculator();
        calculator.number1 = 5 ;
        calculator.number2 = 0 ;

//        System.out.println(calculator.division());
        System.out.println(calculator.addition());

        // Khởi tạo đối tượng person với constructor
        Persion persion1 = new Persion("Tran thanh long", "thanhlongite6");
        Persion persion2 = new Persion("Tran thanh B", "b@gmail.com", 6, "ha noi");



        System.out.println(persion1);
        System.out.println(persion2);
    }
}
