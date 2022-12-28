package funtional_interface;

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class Person implements Greeting{
    public void sayHello(String name) {
        System.out.println("Xin chào " + name);
    }

    public static void main(String[] args) {
        // Cach : sử dụng class cụ thế
        Greeting greeting = new Person();
        greeting.sayHello("THành Long");

        // Cách 2: sử dụng anonymous class
        Greeting greeting1 = new Greeting() {
            @Override
            public void sayHello(String name) {
                System.out.println("Hello " + name);
            }
        };
        greeting1.sayHello("Nguyễn Văn A");

        // Cách 3: Sử dụng lambda expression
        Greeting greeting2 = name -> System.out.println("Konnichiha " + name);

        greeting2.sayHello("Trần Văn B");
    }
}
