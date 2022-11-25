public class MethodDemo {
    public static void main(String[] args) {
        // Cong viec A; ton mat 20 dong code
        // Thuc hien cong viec A 10 lan: ton 200 dong code.
        // Co method : ton them 10 dong de goi

        // Tinh tong 2 so: tra ve ket qua la tong cua 2 so a va b.
        int data = sumTwoNumber(3, 7);
        System.out.println(data);
        System.out.println(sumTwoNumber(6, 7));
        sayHello();
        // Định nghĩa ra một đối tượng và gọi method của đối tượng( thể hiện, instance) đấy.
        // class: khuôn bánh( chỉ có một cái )
        // Objects(instance): bánh sinh ra từ khuôn
        MethodDemo methodDemo = new MethodDemo();   // tạo ra một đối tượng
        methodDemo.sayHelloWithMe("Thanh Long"); // truyền đối số cho phương thức.
    }

    // tham số: parameter : giá trị ảo, chưa biết trước khi định nghĩa method
    // đối số: argument : giá trị thật khi gọi method
    public static int sumTwoNumber(int a, int b) {
        return a + b;
    // Những câu lệnh đằng sau từ khóa return sẽ k được thực thi
    }
    public static void sayHello(){
        System.out.println("xin chao cac ban");
    }
    public void sayHelloWithMe(String name) {
        System.out.println("Xin chào " + name);
    }
}
