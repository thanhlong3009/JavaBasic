package exception_demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckCallStack {
    public static void main(String[] args) {
        methodThree();
    }

    public static void methodOne() throws FileNotFoundException {
        System.out.println("One");

        File file = new File("text.txt");
        FileReader fileReader = new FileReader(file);
    }

    public static void methodTwo() throws FileNotFoundException {
        System.out.println("Two");
        methodOne();
    }

    public static void methodThree() {
        System.out.println("Three");
        try {
            methodTwo();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
