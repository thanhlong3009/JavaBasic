package optional_demo;

import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Optional<String> optionalS = Optional.empty();


        Optional<String> optionalS1 = Optional.of("hello");


        Optional<String> optionalS2 = Optional.ofNullable("Hi");

        // isEmpty() :  Nếu bên trong optional không có giá trị -> true , ngược lại -> false
        // isPresent() : Nếu bên trong optional không có giá trị -> false, ngược lại -> true
        if (optionalS.isEmpty()) {
            System.out.println("no value");
        }else {
            System.out.println(optionalS.get());
        }
        // get() : Trả về giá trị bên trong optional
//        if (optionalS.isPresent()) {
//            System.out.println(optionalS.get());
//        } else {
//            System.out.println("no value");
//        }

        if (optionalS1.isPresent()) {
            System.out.println(optionalS1.get());
        } else {
            System.out.println("no value");
        }

        // Nếu có giá trị bên trong optional => làm hành động gì đó với giá trị này ( consumer)
        optionalS1.ifPresent(value -> System.out.println(value));

        // Nếu ko có giá trị bên trong optional => trả về giá trị mặc định
        String message = optionalS.orElse("world");
        System.out.println(message);

        try {
            String message1 = optionalS.orElseThrow(() -> {
                throw new RuntimeException("Có lỗi xảy ra ");
            }) ;
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
